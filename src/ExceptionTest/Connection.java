package ExceptionTest;

/**
 * @author xucheng.liu
 * @date 2020/4/2
 */
public class Connection implements AutoCloseable {

    @Override
    public void close() throws Exception {
        throw new Exception("close");
    }

    public void sendData() throws Exception {
        throw new MyException("send data");
    }
}