package io.nioTest;

import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author xucheng.liu
 * @since 2022/3/21
 */
public class FileChannelTest {

    private static final String CONTENT = "Zero copy implemented by FileChannel";
    private static final String SOURCE_FILE = "source.txt";
    private static final String TARGET_FILE = "target.txt";
    private static final String CHARSET = "UTF-8";

    public static void main(String[] args) throws Exception {
        FileChannelTest test = new FileChannelTest();
        test.transferTo();
        test.transferFrom();
    }

    public void transferTo() throws Exception {
        try (FileChannel fromChannel = FileChannel.open(getPath(SOURCE_FILE),
                StandardOpenOption.READ, StandardOpenOption.WRITE);
             FileChannel toChannel = FileChannel.open(getPath(TARGET_FILE),
                     StandardOpenOption.READ, StandardOpenOption.WRITE);) {
            long position = 0L;
            long offset = fromChannel.size();
            fromChannel.transferTo(position, offset, toChannel);
        }
    }

    public void transferFrom() throws Exception {
        try (FileChannel fromChannel = FileChannel.open(getPath(SOURCE_FILE),
                StandardOpenOption.READ, StandardOpenOption.WRITE);
             FileChannel toChannel = FileChannel.open(getPath(TARGET_FILE),
                     StandardOpenOption.READ, StandardOpenOption.WRITE);) {
            long position = toChannel.size();
            long offset = fromChannel.size();
            toChannel.transferFrom(fromChannel, position, offset);
        }
    }

    private Path getPath(String fileName) {
        return Paths.get(getClass().getResource(fileName).getPath());
    }
}
