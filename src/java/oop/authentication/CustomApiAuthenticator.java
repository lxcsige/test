package oop.authentication;

/**
 * @author liuxucheng
 * @since 2022/11/30
 */
public class CustomApiAuthenticator implements ApiAuthenticator {

    private CredentialStorage credentialStorage;

    private NonceStorage nonceStorage;

    public CustomApiAuthenticator() {
        this.credentialStorage = new MySqlCredentialStorage();
        this.nonceStorage = new RedisNonceStorage();
    }

    @Override
    public boolean auth(String url) {
        // 解析url
        ApiRequest request = ApiRequest.parse(url);
        return auth(request);
    }

    @Override
    public boolean auth(ApiRequest apiRequest) {
        String baseUrl = apiRequest.getBaseUrl();
        String secretId = apiRequest.getSecretId();
        String token = apiRequest.getToken();
        Long timestamp = apiRequest.getTimestamp();
        Integer nonce = apiRequest.getNonce();
        // 请求校验
        boolean isValid = baseUrl != null && secretId != null && token != null && timestamp != null;
        if (!isValid) {
            return false;
        }
        AuthToken clientToken = new AuthToken(token, timestamp);
        // 验证token是否过期
        if (clientToken.isExpired()) {
            return false;
        }
        // 验证nonce是否存在
        if (nonce != null && nonceStorage.checkNonceIfExist(nonce)) {
            return false;
        }
        // 查询secretKey
        String secretKey = credentialStorage.getKeyBySecretId(secretId);
        if (secretKey == null) {
            return false;
        }
        // 生成服务端token
        AuthToken serverToken = AuthToken.create(baseUrl, secretId, secretKey, timestamp, nonce);
        // 验证token是否相同
        if (!serverToken.match(clientToken)) {
            return false;
        }
        // 保存nonce
        if (nonce != null) {
            nonceStorage.save(nonce);
        }
        return true;
    }
}
