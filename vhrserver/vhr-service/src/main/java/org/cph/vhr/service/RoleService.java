package org.cph.vhr.service;

import org.cph.vhr.mapper.MenuRoleMapper;
import org.cph.vhr.mapper.RoleMapper;
import org.cph.vhr.model.Role;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleService {
    @Resource
    RoleMapper roleMapper;
    @Resource
    MenuRoleMapper menuRoleMapper;

    public List<Role> getAllRoles() {
        return roleMapper.getAllRoles();
    }

    /**
     * 更新menu_role，先删除，后更新
     * @param rid 角色id
     * @param mid 菜单id数组
     * @return
     */
    @Transactional
    public boolean updateRole(Integer rid, Integer[] mid) {
        menuRoleMapper.deleteMenuRoleByRid(rid);
        if (mid == null || mid.length == 0) {
            return true;
        }
        Integer result = menuRoleMapper.insertRecord(rid, mid);
        return result == mid.length;
    }

    public Integer addRole(Role role) {
        return roleMapper.insertSelective(role);
    }

    public Role getRole(Role role) {
        return roleMapper.getRole(role);
    }

    @Transactional
    public boolean deleteRoleById(Integer id) {
        roleMapper.deleteByPrimaryKey(id);
        menuRoleMapper.deleteMenuRoleByRid(id);
        return true;
    }
}
