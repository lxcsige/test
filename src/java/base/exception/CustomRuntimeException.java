package base.exception;

/**
 * @author liuxucheng
 * @since 2022/12/8
 */
public class CustomRuntimeException extends RuntimeException {

    public CustomRuntimeException() {
        super();
    }

    public CustomRuntimeException(String message) {
        super(message);
    }

    /**
     * 是否开启栈快照
     *
     * @param message
     * @param cause
     * @param writableStackTrace
     */
    public CustomRuntimeException(String message, Throwable cause, boolean writableStackTrace) {
        super(message, cause, true, writableStackTrace);
    }
}
