package org.cph.vhr.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.cph.vhr.model.RespBean;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 校验验证码
 *
 * @author cph
 * @date 2021/02/25
 */
//@Component
//public class VerificationCodeFilter extends GenericFilter {
//	@Override
//	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//		HttpServletRequest req = (HttpServletRequest) servletRequest;
//		HttpServletResponse resp = (HttpServletResponse) servletResponse;
//		// 并不是所有请求都需要过滤，登录请求才需要验证，其他放行
//		if ("POST".equals(req.getMethod()) && "/doLogin".equals(req.getServletPath())) {
//			String code = req.getParameter("code");
//			String verify_code =  (String)req.getSession().getAttribute("verify_code");
//			if (code == null || "" == code || !code.equalsIgnoreCase(verify_code)) {
//				resp.setContentType("application/json;charset=utf-8");
//				PrintWriter out = resp.getWriter();
//				out.write(new ObjectMapper().writeValueAsString(RespBean.error("验证码错误")));
//				out.flush();
//				out.close();
//				// 方法停止，不能忘记
//				return;
//			} else {
//				filterChain.doFilter(req, resp);
//			}
//		} else {
//			filterChain.doFilter(req, resp);
//		}
//	}
//
//	@Override
//	public void destroy() {}
//}
