package ExceptionTest;

/**
 * User: lxcfour
 * Date: 2018/5/11
 * Time: 下午4:01
 */
public class MyException extends Exception {

    public MyException() {
        super();
    }

    public MyException(String message) {
        super(message);
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyException(Throwable cause) {
        super(cause);
    }
}
