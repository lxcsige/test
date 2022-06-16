package io.socketTest;

import java.io.IOException;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * 负责处理连接事件，注册客户端socket到selector
 *
 * @author xucheng.liu
 * @since 2022/3/18
 */
public class Acceptor implements Runnable {

    private Selector selector;

    private ServerSocketChannel serverSocketChannel;

    public Acceptor(Selector selector, ServerSocketChannel serverSocketChannel) {
        this.selector = selector;
        this.serverSocketChannel = serverSocketChannel;
    }

    @Override
    public void run() {
        SocketChannel socketChannel;
        try {
            socketChannel = serverSocketChannel.accept();
            if (socketChannel != null) {
                System.out.printf("收到来自 %s 的连接%n", socketChannel.getRemoteAddress());
                // 把客户端通道传给Handler，Handler负责接下来的事件处理（除了连接事件以外的事件均可）
                new Handler(socketChannel, selector);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
