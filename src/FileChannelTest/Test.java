package FileChannelTest;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * Created by liuxucheng on 2018/3/20.
 */
public class Test {

    public static void main(String[] args) throws Exception {
        RandomAccessFile randomAccessFile = new RandomAccessFile("file.txt", "rw");
        randomAccessFile.getChannel().map(FileChannel.MapMode.READ_WRITE, 0, 1024);
    }
}
