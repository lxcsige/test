package io.nioTest;

import sun.misc.Cleaner;

import java.lang.reflect.Method;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.AccessController;
import java.security.PrivilegedAction;

import static java.nio.channels.FileChannel.MapMode.READ_WRITE;

/**
 * @author xucheng.liu
 * @since 2022/3/21
 */
public class MappedByteBufferTest {

    private final static String CONTENT = "987654321";

    private final static String FILE_NAME = "largeFile.txt";

    private final static String CHARSET = "UTF-8";

    public static void main(String[] args) {
        MappedByteBufferTest mappedByteBufferTest = new MappedByteBufferTest();
        mappedByteBufferTest.writeToFileByMappedByteBuffer();
    }

    public void writeToFileByMappedByteBuffer() {
        Path path = Paths.get(getClass().getResource(FILE_NAME).getPath());
        byte[] bytes = CONTENT.getBytes(Charset.forName(CHARSET));
        try (FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.READ,
                StandardOpenOption.WRITE)) {
            MappedByteBuffer mappedByteBuffer = fileChannel.map(READ_WRITE, 10, 10);
            if (mappedByteBuffer != null) {
                mappedByteBuffer.put(bytes);
                mappedByteBuffer.force();

                clean(mappedByteBuffer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void clean(final Object buffer) {
        AccessController.doPrivileged((PrivilegedAction<Void>) () -> {
            try {
                Method getCleanerMethod = buffer.getClass().getMethod("cleaner");
                getCleanerMethod.setAccessible(true);
                Cleaner cleaner = (Cleaner) getCleanerMethod.invoke(buffer);
                cleaner.clean();
            } catch(Exception e) {
                e.printStackTrace();
            }
            return null;
        });
    }
}
