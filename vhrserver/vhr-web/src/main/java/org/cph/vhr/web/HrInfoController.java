package org.cph.vhr.web;

import org.cph.vhr.config.FastDFSUtils;
import org.cph.vhr.model.Hr;
import org.cph.vhr.model.RespBean;
import org.cph.vhr.service.HrService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author cph
 * @date 2021/02/26
 */
@RestController
public class HrInfoController {
	@Resource
	HrService hrService;

	@Value("${fastDFS.nginx.host}")
	String fastDFSNginxHost;

	/**
	 * 获取用户信息
	 *
	 * @return
	 */
	@GetMapping("/hr/info")
	public Hr getHr(Authentication authentication) {
		Hr hr = (Hr) authentication.getPrincipal();
		return hrService.getHrWithRoleById(hr.getId());
	}

	/**
	 * 更新用户信息
	 *
	 * @param hr 用户对象
	 * @return
	 */
	@PutMapping("/hr/info")
	public RespBean updateHr(@RequestBody Hr hr, Authentication authentication) {
		if (hrService.updateHr(hr) == 1) {
			SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(hr,
					authentication.getCredentials(),
					authentication.getAuthorities()));
			// 更新security中的用户信息，目的是为了重新构建Authentication实例
			// 保证上面获取用户对象的正确性
			return RespBean.ok("更新成功");
		}
		return RespBean.error("更新失败");
	}

	/**
	 * 修改密码
	 *
	 * @param info 前端参数
	 * @return
	 */
	@PutMapping("/hr/pass")
	public RespBean updateHrPwd(@RequestBody Map<String, Object> info) {
		String oldPass = (String) info.get("oldPass");
		Integer id =  (Integer)info.get("id");
		String pass = (String) info.get("pass");

		Hr hr = hrService.getHrById(id);
		String password = hr.getPassword();
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		if (!encoder.matches(oldPass, password)) {
			return RespBean.error("旧密码填写错误");
		}
		if (hrService.updateHrPwd(id, pass)) {
			return RespBean.ok("密码修改成功");
		}
		return RespBean.error("密码修改失败");
	}

	/**
	 * 头像上传并保存并更新用户头像地址
	 *
	 * @param file
	 * @param id
	 * @return
	 */
	@PostMapping("/hr/avatar")
	public RespBean uploadAvatar(MultipartFile file, Integer id, Authentication authentication) {
		String field = FastDFSUtils.upload(file);
		String url = fastDFSNginxHost + field;
		if (hrService.updateAvatarUrl(url, id) == 1) {
			Hr hr = (Hr) authentication.getPrincipal();
			hr.setUserface(url);
			SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(hr,
					authentication.getCredentials(),
					authentication.getAuthorities()));
			return RespBean.ok("更新成功", url);
		}
		return RespBean.error("更新失败");
	}
}
