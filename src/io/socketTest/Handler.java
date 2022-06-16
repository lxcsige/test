package io.socketTest;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/**
 * @author xucheng.liu
 * @since 2022/3/18
 */
public class Handler implements Runnable {

    private final SelectionKey selectionKey;
    private final SocketChannel socketChannel;

    private ByteBuffer readBuffer = ByteBuffer.allocate(1024);
    private ByteBuffer sendBuffer = ByteBuffer.allocate(2048);

    private final static int READ = 0;
    private final static int SEND = 1;

    private int status = READ;

    Handler(SocketChannel socketChannel, Selector selector) throws IOException {
        this.socketChannel = socketChannel;
        // 置为非阻塞模式
        this.socketChannel.configureBlocking(false);
        // 将该客户端注册到selector，得到一个SelectionKey，以后select到的就绪动作全都是由该对象进行封装
        selectionKey = socketChannel.register(selector, 0);
        // 附加Handler处理对象，run是对象处理业务的方法
        selectionKey.attach(this);
        // 首先需要读取请求
        selectionKey.interestOps(SelectionKey.OP_READ);
        // 唤起select阻塞
        selector.wakeup();
    }

    boolean inputIsComplete() {
        return false;
    }

    boolean outputIsComplete() {
        return false;
    }

    /**
     * 业务逻辑
     */
    void process() {

    }

    @Override
    public void run() {
        try {
            switch (status) {
                case READ:
                    read();
                    break;
                case SEND:
                    send();
                    break;
                default:
            }
        } catch (IOException e) {
            // 常出的异常就是server端还有未读/写完的客户端消息，客户端就主动断开连接
            // 这种情况下是不会触发返回-1的，这样下面read和write方法里的cancel和close就都无法触发，会导致死循环异常
            // read/write处理失败，事件又未被cancel，因此会不断的被select到，不断的报异常
            System.err.println("read或send时发生异常！异常信息：" + e.getMessage());
            selectionKey.cancel();
            try {
                socketChannel.close();
            } catch (IOException e2) {
                System.err.println("关闭通道时发生异常！异常信息：" + e2.getMessage());
                e2.printStackTrace();
            }
        }
    }

    private void read() throws IOException {
        if (selectionKey.isValid()) {
            readBuffer.clear();
            // 这种写法限制了一次最多只能读1M
            // read方法结束，意味着本次"读就绪"变为"读完毕"，标记着一次就绪事件的结束
            int count = socketChannel.read(readBuffer);
            if (count > 0) {
                System.out.printf("收到来自 %s 的消息: %s%n",
                        socketChannel.getRemoteAddress(), new String(readBuffer.array()));
                // 改变状态
                status = SEND;
                // 注册监听写事件
                selectionKey.interestOps(SelectionKey.OP_WRITE);
            } else {
                selectionKey.cancel();
                socketChannel.close();
                System.out.println("read时-------连接关闭");
            }
        }
    }

    void send() throws IOException {
        if (selectionKey.isValid()) {
            sendBuffer.clear();
            sendBuffer.put(String.format("我收到来自%s的信息辣：%s,  200ok;", socketChannel.getRemoteAddress(),
                    new String(readBuffer.array())).getBytes());
            sendBuffer.flip();

            // write方法结束，意味着本次写就绪变为写完毕，标记着一次事件的结束
            int count = socketChannel.write(sendBuffer);
            if (count < 0) {
                // 同上，write场景下，取到-1，也意味着客户端断开连接
                selectionKey.cancel();
                socketChannel.close();
                System.out.println("send时-------连接关闭");
            }

            // 没断开连接，则再次切换到读
            status = READ;
            selectionKey.interestOps(SelectionKey.OP_READ);
        }
    }
}
