package org.cph.vhr.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 * @author cph
 * @date 2021/03/13
 */
public class DESUtils {
	private static final String AES_ALGORITHM = "DES";

	/**
	 * 获取cipher
	 *
	 * @param key
	 * @param model
	 * @return
	 * @throws Exception
	 */
	private static Cipher getCipher(byte[] key, int model) throws Exception {
		SecretKeySpec secretKeySpec = new SecretKeySpec(key, "DES");
		Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
		cipher.init(model, secretKeySpec);
		return cipher;
	}

	/**
	 * DES加密
	 *
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String encrypt(byte[] data, byte[] key) throws Exception {
		Cipher cipher = getCipher(key, Cipher.ENCRYPT_MODE);
		return Base64.getEncoder().encodeToString(cipher.doFinal(data));
	}

	/**
	 * DES解密
	 *
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] decrypt(byte[] data, byte[] key) throws Exception {
		Cipher cipher = getCipher(key, Cipher.DECRYPT_MODE);
		return cipher.doFinal(Base64.getDecoder().decode(data));
	}
}
