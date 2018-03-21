package DynamicProxyTest;

/**
 * Created by lxcfour on 2016/12/9.
 */
public class BookImpl implements BookFacade {

    @Override
    public void addBook() {
        System.out.println("addBook");
    }
}
