package oop.authentication;

import java.security.NoSuchAlgorithmException;

/**
 * @author liuxucheng
 * @since 2022/11/30
 */
public class EncodeUtil {

    public static String encode(String s, String method) throws NoSuchAlgorithmException {
//        Mac mac = Mac.getInstance(method);
//        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(CHARSET), mac.getAlgorithm());
//        mac.init(secretKeySpec);
//        byte[] hash = mac.doFinal(s.getBytes(CHARSET));
//        return DatatypeConverter.printBase64Binary(hash);
        return "";
    }
}
