package org.cph.vhr.web.system.basic;

import org.cph.vhr.model.Menu;
import org.cph.vhr.model.RespBean;
import org.cph.vhr.model.Role;
import org.cph.vhr.service.MenuService;
import org.cph.vhr.service.RoleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author cph
 * @date 2020/12/25
 * 权限组
 */
@RestController
@RequestMapping("/system/basic/permission")
public class PermissionController {
    @Resource
    RoleService roleService;
    @Resource
    MenuService menuService;
    /**
     * 根据角色id查询所有可用菜单项id
     * @param rid 角色id
     * @return
     */
    @GetMapping("/{rid}")
    public List<Integer> getAllMidByRid(@PathVariable Integer rid) {
        return menuService.getAllMidById(rid);
    }

    /**
     * 获取所有菜单
     * @return
     */
    @GetMapping("/menus")
    public List<Menu> getAllMenus() {
        return menuService.getAllMenus();
    }

    /**
     * 获取所有角色
     * @return
     */
    @GetMapping
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

	/**
	 * 新增角色
	 * @param role 角色对象
	 * @return
	 */
	@PostMapping
    public RespBean addRole(@RequestBody Role role) {
		String name = role.getName();
		if (!name.startsWith("ROLE_")) {
			role.setName("ROLE_" + name);
		}
    	if (roleService.getRole(role) != null) {
			return RespBean.error("已存在相同角色");
		}
        if (roleService.addRole(role) == 1) {
            return RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败");
    }

	/**
	 * 修改角色的菜单，每次修改菜单都删除同一个角色的所有menu_role记录，再以最新的存储
	 * @param rid 角色id
	 * @param mid 菜单id数组
	 * @return
	 */
	@PutMapping
	public RespBean updateRole(Integer rid, Integer[] mid) {
		if (roleService.updateRole(rid, mid)) {
			return RespBean.ok("更新成功");
		}
		return RespBean.error("更新失败");
	}

	/**
	 * 删除角色表记录的同时还要删除菜单角色表记录
	 * @param id 角色记录id
	 * @return
	 */
	@DeleteMapping("/del/mid/{id}")
    public RespBean deleteRoleById(@PathVariable Integer id) {
        if (roleService.deleteRoleById(id)) {
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }
}
