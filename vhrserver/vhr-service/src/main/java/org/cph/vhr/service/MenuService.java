package org.cph.vhr.service;

import org.cph.vhr.mapper.MenuMapper;
import org.cph.vhr.model.Hr;
import org.cph.vhr.model.Menu;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MenuService {
    @Resource
    MenuMapper menuMapper;

    public List<Menu> getAllMenus() {
        return menuMapper.getAllMenus();
    }

    public List<Menu> getMenusByHrId() {
        // 获取已经登录保存在内存的用户登录对象(hr 对象)，再查询菜单
        return menuMapper.getMenusById(((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
    }

//    @Cacheable(cacheNames = "menusCache")
    public List<Menu> getAllMenusWithRole() {
        return menuMapper.getAllMenusWithRole();
    }

    public List<Integer> getAllMidById(Integer rid) {
        return menuMapper.getAllMidByRid(rid);
    }
}
