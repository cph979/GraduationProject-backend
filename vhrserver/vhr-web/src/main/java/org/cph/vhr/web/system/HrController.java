package org.cph.vhr.web.system;

import org.cph.vhr.model.Hr;
import org.cph.vhr.model.RespBean;
import org.cph.vhr.model.Role;
import org.cph.vhr.service.HrRoleService;
import org.cph.vhr.service.HrService;
import org.cph.vhr.service.RoleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author cph
 * @date 2021/01/15
 */
@RestController
@RequestMapping("system/hr")
public class HrController {
	@Resource
	private HrService hrService;
	@Resource
	private RoleService roleService;
	@Resource
	private HrRoleService hrRoleService;

	@GetMapping
	public List<Hr> getAllHr(String name) {
		return hrService.getAllHr(name);
	}

	/**
	 * 更新hr表enabled字段
	 * @param hr
	 * @return
	 */
	@PutMapping
	public RespBean updateHr(@RequestBody Hr hr) {
		if (hrService.updateHr(hr) == 1) {
			return RespBean.ok("更新成功");
		}
		return RespBean.error("更新失败");
	}

	/**
	 * 查询所有角色
	 * @return
	 */
	@GetMapping("/roles")
	public List<Role> getAllRoles() {
		return roleService.getAllRoles();
	}

	/**
	 * 更新hr_role表
	 * @param hrid hrid
	 * @param rids 角色ids
	 * @return
	 */
	@PutMapping("/roles")
	public RespBean updateHrRole(Integer hrid, Integer[] rids) {
		if (hrRoleService.updateHrRole(hrid, rids)) {
			return RespBean.ok("更新成功");
		}
		return RespBean.error("更新失败");
	}

	/**
	 * 删除hr用户，须同时删除hr_role用户角色关联表记录
	 * @param id 用户id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public RespBean deleteHr(@PathVariable Integer id) {
		if (hrService.deleteHr(id)) {
			return RespBean.ok("删除成功");
		}
		return RespBean.error("删除失败");
	}
}
