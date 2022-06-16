package io.nioTest;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/**
 * @author xucheng.liu
 * @since 2022/3/20
 */
public class DirectByteBufferTest {

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(128);
        byteBuffer.put("test".getBytes(StandardCharsets.UTF_8));
        System.out.println(byteBuffer);
        System.out.println(byteBuffer.get());
    }
}
