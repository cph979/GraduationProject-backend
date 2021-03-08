package org.cph.vhr.service;

import org.cph.vhr.mapper.HrMapper;
import org.cph.vhr.mapper.HrRoleMapper;
import org.cph.vhr.model.Hr;
import org.cph.vhr.model.HrRole;
import org.cph.vhr.utils.HrUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HrService implements UserDetailsService {
    @Resource
    HrMapper hrMapper;
	@Resource
	HrRoleMapper hrRoleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Hr hr = hrMapper.loadUserByUsername(username);
        if (hr == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        hr.setRoles(hrMapper.getHrRolesById(hr.getId()));
        return hr;
    }

    public List<Hr> getAllHr(String name) {
        return hrMapper.getAllHr(HrUtils.getHr().getId(), name);
    }

	public Integer updateHr(Hr hr) {
        return hrMapper.updateByPrimaryKeySelective(hr);
	}

	@Transactional
	public boolean deleteHr(Integer id) {
    	hrRoleMapper.deleteByHrid(id);
		return hrMapper.deleteByPrimaryKey(id) == 1;
	}

	public boolean updateHrPwd(Integer id, String pass) {
		Integer result = hrMapper.updateHrPwd(id, new BCryptPasswordEncoder().encode(pass));
		if (result == 1) {
			return true;
		}
		return false;
	}

	public Hr getHrById(Integer id) {
		return hrMapper.selectByPrimaryKey(id);
	}

	public Integer updateAvatarUrl(String url, Integer id) {
    	return hrMapper.updateAvatarUrl(url, id);
	}

	public Hr getHrWithRoleById(Integer id) {
		return hrMapper.getHrWithRoleById(id);
	}
}
