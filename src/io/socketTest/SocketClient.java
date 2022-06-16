package io.socketTest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

/**
 * @author xucheng.liu
 * @since 2021/12/24
 */
public class SocketClient {

    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("localhost", 8888);
             InputStream socketInputStream = socket.getInputStream();
             OutputStream socketOutputStream = socket.getOutputStream()) {
            String head = "hello ";
            String body = "world";
            socketOutputStream.write(head.getBytes());
            socketOutputStream.write(body.getBytes());
            socket.shutdownOutput();

            // sleep
            try {
                TimeUnit.HOURS.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
//
//            byte[] data = new byte[32];
//            int len;
//            while ((len = socketInputStream.read(data)) != -1) {
//                String line = new String(data, 0, len, StandardCharsets.UTF_8);
//                System.out.println("response from server: " + line);
//            }
        }
    }
}
