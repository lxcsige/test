package design.pattern.proxy.staticProxy;

/**
 * @author liuxucheng
 * @since 2022/12/23
 */
public interface IUserController {

    UserVO login(String telephone, String password);

    UserVO register(String telephone, String password);
}
