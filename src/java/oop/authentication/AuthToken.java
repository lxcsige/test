package oop.authentication;

import java.util.Date;
import java.util.Map;

/**
 * @author liuxucheng
 * @since 2022/11/29
 */
public class AuthToken {

    private String token;

    private long createTime;

    private static final long DEFAULT_EXPIRE_INTERVAL_MILLIS = 60 * 1000;

    public AuthToken(String token, long createTime) {
        this.token = token;
        this.createTime = createTime;
    }

    /**
     * 生成token
     */
    public static AuthToken create(Map<String, String> params) {
        // TODO 根据参数拼接字符串
        // TODO SHA1 + BASE64
        return new AuthToken("", 0L);
    }

    public static AuthToken create(String url, String secretId, String secretKey, Long timestamp, Integer nonce) {
        // TODO 根据参数拼接字符串
        // TODO SHA1 + BASE64
        return new AuthToken("", 0L);
    }

    /**
     * 判断是否过期
     */
    public boolean isExpired() {
        return new Date().getTime() > createTime + DEFAULT_EXPIRE_INTERVAL_MILLIS;
    }

    /**
     * 验证token是否相等
     *
     * @param token
     * @return
     */
    public boolean match(AuthToken token) {
        return this.token.equals(token.getToken());
    }

    public String getToken() {
        return token;
    }

    public long getCreateTime() {
        return createTime;
    }
}
