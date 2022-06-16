package io.socketTest;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * BIO
 *
 * @author xucheng.liu
 * @since 2021/12/24
 */
public class SocketServer {

    /**
     * 服务端线程池，用于处理socket
     */
    private static final ExecutorService executorService = Executors.newFixedThreadPool(100);

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);

        while (!Thread.currentThread().isInterrupted()) {
            // 接受客户端链接
            Socket socket = serverSocket.accept();
            // 放入线程池处理
            executorService.submit(new ConnectionHandler(socket));
        }
    }

    static class ConnectionHandler implements Runnable {

        private Socket socket;

        public ConnectionHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted() && !socket.isClosed()) {
                // 处理socket
            }
        }
    }
}
