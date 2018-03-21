package MmapTest;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * User: lxcfour
 * Date: 2018/3/19
 * Time: 下午8:54
 */
public class Test {

    private static int count = 1024 * 1024 * 10;

    public static void main(String[] args) throws Exception {
        RandomAccessFile memoryMappedFile = new RandomAccessFile("largeFile.txt", "rw");

        MappedByteBuffer out = memoryMappedFile.getChannel().map(FileChannel.MapMode.READ_WRITE, 0, count);
        byte[] bytes = "国".getBytes("UTF-8");

        for (int i = 0; i < Math.ceil(count / bytes.length); i++) {
            for (byte b : bytes)
            out.put(b);
        }
        System.out.println("Writing to Memory Mapped File is completed");

//        for (int i = 0; i < 10; i++) {
//            System.out.print((char) out.get(i));
//        }
//        System.out.println("Reading from Memory Mapped File is completed");

        memoryMappedFile.close();
    }
}
