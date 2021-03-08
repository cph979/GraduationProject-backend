package org.cph.vhr.service;

import org.cph.vhr.mapper.HrRoleMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author cph
 * @date 2021/01/17
 */
@Service
public class HrRoleService {
	@Resource
	HrRoleMapper hrRoleMapper;

	@Transactional
	public boolean updateHrRole(Integer hrid, Integer[] rids) {
		hrRoleMapper.deleteByHrid(hrid);
		if (rids == null ||  rids.length == 0) {
			return true;
		}
		return rids.length == hrRoleMapper.insertHrRole(hrid, rids);
	}
}
