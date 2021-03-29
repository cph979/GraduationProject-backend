package org.cph.vhr.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.cph.vhr.annotations.Encrypt;
import org.cph.vhr.model.RespBean;
import org.cph.vhr.utils.DESUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;


import javax.annotation.Resource;

/**
 * 响应给前端前加密
 *
 * @author cph
 * @date 2021/02/13
 */
@EnableConfigurationProperties(EncryptProperties.class)
@ControllerAdvice
public class EncryptResponse implements ResponseBodyAdvice<RespBean> {
	private static final Logger LOGGER = LoggerFactory.getLogger(EncryptResponse.class);

	@Resource
	EncryptProperties encryptProperties;

	private ObjectMapper om = new ObjectMapper();

	/**
	 * 这个方法用来判断什么样的接口需要加密
	 * 参数 returnType 表示返回类型，我们这里的判断逻辑就是方法是否含有 @Encrypt 注解
	 * 如果有，表示该接口需要加密处理，如果没有，表示该接口不需要加密处理。
	 *
	 * @param methodParameter
	 * @param aClass
	 * @return
	 */
	@Override
	public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
		return methodParameter.hasMethodAnnotation(Encrypt.class);
	}

	/**
	 * 这个方法会在数据响应之前执行，也就是我们先对响应数据进行二次处理，处理完成后，才会转成 json 返回。
	 * 我们这里的处理方式很简单，RespBean中的status是状态码就不用加密了，另外两个字段重新加密后重新设置值即可。
	 *
	 * @param body
	 * @param methodParameter
	 * @param mediaType
	 * @param aClass
	 * @param serverHttpRequest
	 * @param serverHttpResponse
	 * @return
	 */
	@Override
	public RespBean beforeBodyWrite(RespBean body, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
		byte[] keyBytes = encryptProperties.getKey().getBytes();
		try {
			Object obj = body.getObj();
			if (obj != null) {
				LOGGER.info("ResponseBodyAdvice:\n响应给前端未加密之前>>>" + om.writeValueAsString(obj));
				body.setObj(DESUtils.encrypt(om.writeValueAsBytes(obj), keyBytes));
				LOGGER.info("ResponseBodyAdvice:\n加密之后>>>" + body.getObj());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return body;
	}
}
