package org.cph.vhr.utils;

import org.cph.vhr.model.Hr;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * 返回Security中登录用户信息
 *
 * @author cph
 * @date 2021/01/15
 */
public class HrUtils {
	public static Hr getHr() {
		return ((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
	}
}
