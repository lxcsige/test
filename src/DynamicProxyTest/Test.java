package DynamicProxyTest;

/**
 * Created by lxcfour on 2016/12/9.
 */
public class Test {

    public static void main(String[] args) {
        BookFacade proxy = (BookFacade) (new BookProxy().bind(new BookImpl()));
        proxy.addBook();
    }
}
