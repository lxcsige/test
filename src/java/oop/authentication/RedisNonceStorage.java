package oop.authentication;

/**
 * @author liuxucheng
 * @since 2022/11/30
 */
public class RedisNonceStorage implements NonceStorage {

    @Override
    public boolean save(int nonce) {
        return true;
    }

    @Override
    public boolean checkNonceIfExist(int nonce) {
        return false;
    }
}
