package org.cph.vhr.web.config;

import org.cph.vhr.model.Menu;
import org.cph.vhr.service.MenuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/system/config")
public class SystemConfigController {
    @Resource
    MenuService menuService;

    @GetMapping("/menu")
    public List<Menu> getMenusByHrId() {
        // 不能使用前端传过来的hrId进行查询，不安全
        return menuService.getMenusByHrId();
    }
}
