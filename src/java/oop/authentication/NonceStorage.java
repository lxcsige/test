package oop.authentication;

/**
 * @author liuxucheng
 * @since 2022/11/30
 */
public interface NonceStorage {

    boolean save(int nonce);

    boolean checkNonceIfExist(int nonce);
}
