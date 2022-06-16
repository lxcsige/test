package io.socketTest;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Set;

/**
 * 单Reactor单线程模型
 *
 * @author xucheng.liu
 * @since 2022/3/18
 */
public class Reactor implements Runnable{

    private Selector selector;

    private ServerSocketChannel serverSocketChannel;

    public Reactor(int port) throws IOException {
        selector = Selector.open();
        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(port));
        serverSocketChannel.configureBlocking(false);
        SelectionKey sk = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        // attach callback object，处理连接就绪事件
        sk.attach(new Acceptor(selector, serverSocketChannel));
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted() && !selector.isOpen()) {
                selector.select(); // 就绪事件到达之前，阻塞
                // 拿到本次select获取的就绪事件
                Set<SelectionKey> selected = selector.selectedKeys();
                for (SelectionKey selectionKey : selected) {
                    // 任务分发
                    dispatch(selectionKey);
                }
                selected.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 事件分发，读/写/连接
     *
     * @param k
     */
    private void dispatch(SelectionKey k) {
        // 拿到每次selectKey里面附带的处理对象，然后调用其run，这个对象在具体的Handler里会进行创建，初始化的附带对象为Acceptor
        Runnable r = (Runnable) (k.attachment());
        // 调用之前注册的callback对象
        if (r != null) {
            r.run();
        }
    }
}
