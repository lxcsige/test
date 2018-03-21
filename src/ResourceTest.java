import java.net.URL;

/**
 * Created by lxcfour on 2017/7/10.
 */
public class ResourceTest {

    public static void main(String[] args) {
        ResourceTest resourceTest = new ResourceTest();
        resourceTest.test();
    }

    public void test() {
        URL root = this.getClass().getResource("/");
        URL current1 = this.getClass().getResource("");
        URL current2 = this.getClass().getResource(".");
        URL self1 = this.getClass().getResource("ResourceTest.class");
        URL self2 = this.getClass().getResource("./ResourceTest.class");

        System.out.println("root = "+root);
        System.out.println("current1 = "+current1);
        System.out.println("current2 = "+current2);
        System.out.println("self1 = "+self1);
        System.out.println("self2 = "+self2);
    }
}
