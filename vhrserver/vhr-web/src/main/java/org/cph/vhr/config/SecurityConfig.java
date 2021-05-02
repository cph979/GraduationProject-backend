package org.cph.vhr.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.cph.vhr.model.Hr;
import org.cph.vhr.model.RespBean;
import org.cph.vhr.service.HrService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;
import java.io.PrintWriter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource
    private HrService hrService;
    @Resource
    private CustomUrlDecisionManager customUrlDecisionManager;
    @Resource
    private CustomFilterInvocationSecurityMetadataSource customFilterInvocationSecurityMetadataSource;
//    @Resource
//    private VerificationCodeFilter verificationCodeFilter;

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(hrService);
    }

    /**
     * 配置不需要配备拦截的地址
     *
     * @param web
     */
    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/css/**",
                "/js/**",
                "/index.html",
                "/img/**",
                "/fonts/**",
                "/favicon.ico",
                "/verify",
                "/swagger*//**",
                "/v2/api-docs",
                "/webjars*//**");
    }

    // 配置登录表单、成功回调、失败回调、注销
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 在UsernamePasswordAuthenticationFilter过滤器之前先执行这个过滤器
//        http.addFilterBefore(verificationCodeFilter, UsernamePasswordAuthenticationFilter.class);
        http.authorizeRequests()
//                .anyRequest().authenticated()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O object) {
                        object.setAccessDecisionManager(customUrlDecisionManager);
                        object.setSecurityMetadataSource(customFilterInvocationSecurityMetadataSource);
                        return object;
                    }
                })
                .and()
                .formLogin()
                .loginProcessingUrl("/doLogin")
//                .loginPage("/login")
                // 登录成功回调
                .successHandler((req, resp, authentication) -> {
                    // 登录成功返回成功json
                    resp.setContentType("application/json;charset=utf-8");
                    PrintWriter out = resp.getWriter();
                    Hr hr = (Hr) authentication.getPrincipal();
                    hr.setPassword(null);
                    RespBean ok = RespBean.ok("登录成功", hr);
                    out.write(new ObjectMapper().writeValueAsString(ok));
                    out.flush();
                    out.close();
                })
                // 登录失败回调
                .failureHandler((req, resp, e) -> {
                    // 登录失败返回失败json
                    resp.setContentType("application/json;charset=utf-8");
                    PrintWriter out = resp.getWriter();
                    RespBean error = RespBean.error("登录失败");
                    if (e instanceof LockedException) {
                        error.setMsg("账户被锁定，请联系管理员");
                    } else if (e instanceof CredentialsExpiredException) {
                        error.setMsg("密码过期，请联系管理员");
                    } else if (e instanceof AccountExpiredException) {
                        error.setMsg("账户过期，请联系管理员");
                    } else if (e instanceof DisabledException) {
                        error.setMsg("账户被禁用，请联系管理员");
                    } else if (e instanceof BadCredentialsException) {
                        error.setMsg("用户名或者密码输入错误，请重新输入");
                    }
                    out.write(new ObjectMapper().writeValueAsString(error));
                    out.flush();
                    out.close();
                })
                .permitAll()
                .and()
                .logout()
                .logoutSuccessHandler((req, resp, authentication) -> {
                    resp.setContentType("application/json;charset=utf-8");
                    PrintWriter out = resp.getWriter();
                    RespBean ok = RespBean.ok("注销成功");
                    out.write(new ObjectMapper().writeValueAsString(ok));
                    out.flush();
                    out.close();
                })
                .permitAll()
                .and()
                .csrf().disable().exceptionHandling()
                // 没有认证时，在这里处理结果，不要重定向
                // 添加异常处理,在此方法里可以决定在请求失败了之后是想要重定向还是其他操作，或者返回json

                // 请求失败 (当前端不登录直接在地址栏访问菜单栏地址时，
                // 过滤器会因为它没有相应url和登录角色，转向登录接口
                // 服务器会返回前端一个重定向302到之前配置的'Login'控制器去登陆，
                // 而此时重定向会引起NodeJs跨域问题)
                .authenticationEntryPoint((req, resp, authenticationException) -> {
                    resp.setContentType("application/json;charset=utf-8");
                    // 服务器直接返回前端401未登录错误码，前端axios拦截器会拦截到，直接显示错误信息，路由切换到首页
                    resp.setStatus(401);
                    PrintWriter out = resp.getWriter();
                    RespBean respBean = RespBean.error("访问失败");
                    if (authenticationException instanceof InsufficientAuthenticationException) {
                        respBean.setMsg("请求失败，请联系管理员");
                        respBean.setObj(authenticationException.getMessage());
                    }
                    out.write(new ObjectMapper().writeValueAsString(respBean));
                    out.flush();
                    out.close();
                });
    }
}
