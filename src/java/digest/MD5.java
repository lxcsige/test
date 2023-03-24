package digest;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author liuxucheng
 * @since 2022/11/30
 */
public class MD5 {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String input = "jsjfhiwjfnfhskhdffncbfdywiskahcjhfurkcnc";
        byte[] inputBytes = input.getBytes(StandardCharsets.UTF_8);
        byte[] inputBytes_16 = input.getBytes(StandardCharsets.UTF_16);
        System.out.println(new String(inputBytes));
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] output = md.digest(inputBytes);
    }
}
