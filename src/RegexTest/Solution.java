package RegexTest;

import java.util.regex.Pattern;

/**
 * @author xucheng.liu
 * @date 2018/10/23
 */
public class Solution {

    public static void main(String[] args) {
        boolean res = Pattern.matches("/api/v1/refund/accounts/(\\d+)", "/api/v1/refund/accounts/123/midas");
        System.out.println(res);
    }
}
