import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * @author xucheng.liu
 * @since 2022/2/24
 */
public class Md5Test {

    public static void main(String[] args) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] res = messageDigest.digest("select * from visit where 1234566iyndnfbfhfjd".getBytes(StandardCharsets.UTF_8));
    }
}
