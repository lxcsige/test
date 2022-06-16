package io.socketTest;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 多Reactor多线程模型
 *
 * @author xucheng.liu
 * @since 2022/3/18
 */
public class MainReactor implements Runnable {

    /**
     * subReactors集合
     */
    private final SubReactor[] subReactors = new SubReactor[Runtime.getRuntime().availableProcessors()];

    private final ServerSocketChannel serverSocket;

    private final Selector selector;

    int next = 0;

    private final ExecutorService executorService = Executors
            .newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    MainReactor(int port) throws IOException {
        selector = Selector.open();
        serverSocket = ServerSocketChannel.open();
        // bind & listen
        serverSocket.socket().bind(new InetSocketAddress(port));
        // 非阻塞
        serverSocket.configureBlocking(false);
        // 注册accept事件到主reactor
        SelectionKey sk = serverSocket.register(selector, SelectionKey.OP_ACCEPT);
        // attach callback object, Acceptor
        sk.attach(new Acceptor());

        // 启动subReactor线程
        for (int i = 0; i < subReactors.length; i++) {
            subReactors[i] = new SubReactor();
            executorService.submit(subReactors[i]);
        }
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                selector.select();
                Set<SelectionKey> selected = selector.selectedKeys();
                for (SelectionKey selectionKey : selected) {
                    dispatch(selectionKey);
                }
                selected.clear();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void dispatch(SelectionKey k) {
        Runnable r = (Runnable) (k.attachment());
        // 调用之前注册的callback对象
        if (r != null) {
            r.run();
        }
    }

    class Acceptor {
        public synchronized void run() throws IOException {
            SocketChannel socketChannel = serverSocket.accept();
            if (socketChannel != null) {
                // 选个subReactor去负责监听新连接的读写事件
                subReactors[next].registerChannel(socketChannel);
            }
            if (++next == subReactors.length) {
                next = 0;
            }
        }
    }
}
