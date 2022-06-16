package io.socketTest;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 单Reactor多线程模型，需要注意缓冲区和状态的线程安全问题
 *
 * @author xucheng.liu
 * @since 2022/3/18
 */
public class MultiThreadHandler implements Runnable {

    /**
     * 业务逻辑线程池
     */
    private static ExecutorService pool = Executors.newFixedThreadPool(100);

    private final SelectionKey selectionKey;
    private final SocketChannel socketChannel;

    private ByteBuffer readBuffer = ByteBuffer.allocate(1024);
    private ByteBuffer sendBuffer = ByteBuffer.allocate(2048);

    private static final int READ = 0;
    private static final int SEND = 1;
    private static final int PROCESSING = 2;

    private int status = READ;

    MultiThreadHandler(SocketChannel socketChannel, Selector selector) throws IOException {
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
                    write();
                    break;
                default:
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    synchronized void read() throws IOException {
        socketChannel.read(readBuffer);
        status = PROCESSING;
        pool.submit(new Processor());
    }

    synchronized void processAndHandOff() {
        process();
        status = SEND;
        selectionKey.interestOps(SelectionKey.OP_WRITE);
    }

    synchronized void write() throws IOException {
        socketChannel.write(sendBuffer);
        status = READ;
        selectionKey.interestOps(SelectionKey.OP_READ);
    }

    class Processor implements Runnable {
        @Override
        public void run() {
            processAndHandOff();
        }
    }
}
