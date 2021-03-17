package org.cph.vhr.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * key的属性安全注入
 *
 * @author cph
 * @date 2021/03/15
 */
@ConfigurationProperties(prefix = "spring.encrypt")
public class EncryptProperties {
	private final static String DEFAULT_KEY = "cph97091";
	private String key = DEFAULT_KEY;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
