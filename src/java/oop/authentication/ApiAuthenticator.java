package oop.authentication;

/**
 * @author liuxucheng
 * @since 2022/11/30
 */
public interface ApiAuthenticator {

    boolean auth(String url);

    boolean auth(ApiRequest apiRequest);
}
