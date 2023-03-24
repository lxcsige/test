package oop.authentication;

/**
 * @author liuxucheng
 * @since 2022/11/29
 */
public class ApiRequest {

    private String baseUrl;

    private String secretId;

    private String token;

    private Long timestamp;

    private Integer nonce;

    public ApiRequest(String baseUrl, String secretId, String token, Long timestamp, Integer nonce) {
        this.baseUrl = baseUrl;
        this.secretId = secretId;
        this.token = token;
        this.timestamp = timestamp;
        this.nonce = nonce;
    }

    /**
     * 解析
     */
    public static ApiRequest parse(String url) {
        // todo 解析url
        return new ApiRequest("", "", "", 0L, 0);
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getSecretId() {
        return secretId;
    }

    public String getToken() {
        return token;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public Integer getNonce() {
        return nonce;
    }
}
