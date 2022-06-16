package io.nioTest;

import java.nio.ByteBuffer;

/**
 * @author xucheng.liu
 * @since 2022/3/18
 */
public class ByteBufferTest {

    public static void main(String[] args) {
        // 开始是写模式，limit = capacity
        ByteBuffer buffer = ByteBuffer.allocate(128);
        // pos=0 lim=128 cap=128
        System.out.println(buffer);

        String value = "test";
        buffer.put(value.getBytes());
        // pos=4 lim=128 cap=128
        System.out.println(buffer);

        // 切换到读模式
        buffer.flip();
        // pos=0 lim=4 cap=128
        System.out.println(buffer);

        byte[] v = new byte[buffer.remaining()];
        buffer.get(v);
        // pos=4 lim=4 cap=128
        System.out.println(buffer);
        System.out.println(new String(v));
    }
}
