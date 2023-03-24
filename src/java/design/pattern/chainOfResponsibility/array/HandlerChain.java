package design.pattern.chainOfResponsibility.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuxucheng
 * @since 2023/1/9
 */
public class HandlerChain {

    private List<Handler> handlers = new ArrayList<>();

    public void addHandler(Handler handler) {
        handlers.add(handler);
    }

    public void handle() {
        for (Handler handler : handlers) {
            handler.handle();
        }
    }
}
