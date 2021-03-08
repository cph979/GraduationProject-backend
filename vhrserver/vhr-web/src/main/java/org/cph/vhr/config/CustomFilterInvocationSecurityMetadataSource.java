package org.cph.vhr.config;

import org.cph.vhr.model.Menu;
import org.cph.vhr.model.Role;
import org.cph.vhr.service.MenuService;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * 针对后端配置权限访问
 * 根据用户传来的请求地址，分析出请求需要的角色
 */
@Component
public class CustomFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    @Resource
    MenuService menuService;
    AntPathMatcher pathMatcher = new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        // 匹配数据库菜单项url字段
        List<Menu> menusWithRole = menuService.getAllMenusWithRole();
        for (Menu menu : menusWithRole) {
            if (pathMatcher.match(menu.getUrl(), requestUrl)) {
                List<Role> roles = menu.getRoles();
                String[] roleStr = new String[roles.size()];
                for (int i = 0; i < roles.size(); i++) {
                    roleStr[i] = roles.get(i).getName();
                }
                return SecurityConfig.createList(roleStr);
            }
        }
        // 没有匹配上的登录之后可以访问，返回登录标志login
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
