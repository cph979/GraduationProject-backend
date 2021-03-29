package org.cph.vhr.config;

import org.cph.vhr.annotations.Decrypt;
import org.cph.vhr.utils.DESUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;

/**
 * 接收前端参数之前解密
 *
 * @author cph
 * @date 2021/02/13
 */
@EnableConfigurationProperties(EncryptProperties.class)
@ControllerAdvice
public class DecryRequest extends RequestBodyAdviceAdapter {
	private static final Logger LOGGER = LoggerFactory.getLogger(DecryRequest.class);

	@Resource
	EncryptProperties encryptProperties;

	@Override
	public boolean supports(MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
		return methodParameter.hasMethodAnnotation(Decrypt.class) || methodParameter.hasParameterAnnotation(Decrypt.class);
	}

	@Override
	public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) throws IOException {
		byte[] body = new byte[inputMessage.getBody().available()];
		inputMessage.getBody().read(body);
		try {
			LOGGER.info("RequestBodyAdvice:\n接口接收到加密参数之前>>>" + new String(body));
			byte[] decrypt = DESUtils.decrypt(body, encryptProperties.getKey().getBytes());
			LOGGER.info("RequestBodyAdvice:\n参数DES解密之后>>>" + new String(decrypt));
			final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(decrypt);
			return new HttpInputMessage() {
				@Override
				public InputStream getBody() {
					return byteArrayInputStream;
				}

				@Override
				public HttpHeaders getHeaders() {
					return inputMessage.getHeaders();
				}
			};
		} catch (Exception e) {
			e.printStackTrace();
		}
		return super.beforeBodyRead(inputMessage, parameter, targetType, converterType);
	}
}
