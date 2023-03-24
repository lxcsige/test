package oop.authentication;

/**
 * @author liuxucheng
 * @since 2022/11/30
 */
public interface CredentialStorage {

    /**
     * 根据secretId查询secretKey
     *
     * @param secretId
     * @return
     */
    String getKeyBySecretId(String secretId);
}
