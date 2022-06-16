package io.socketTest;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Set;

/**
 * @author xucheng.liu
 * @since 2022/3/19
 */
public class SubReactor implements Runnable {

    private final Selector selector;

    public SubReactor() throws IOException {
        this.selector = Selector.open();
    }

    public void registerChannel(SocketChannel socketChannel) throws IOException {
        new Handler(socketChannel, selector);
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                selector.select();
                // 拿到本次select获取的就绪事件
                Set<SelectionKey> selected = selector.selectedKeys();
                for (SelectionKey selectionKey : selected) {
                    // 任务分发
                    dispatch(selectionKey);
                }
                selected.clear();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 事件分发，读/写
     *
     * @param k
     */
    private void dispatch(SelectionKey k) {
        Runnable r = (Runnable) (k.attachment());
        // 调用之前注册的callback对象
        if (r != null) {
            r.run();
        }
    }
}
