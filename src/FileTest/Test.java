package FileTest;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author xucheng.liu
 * @date 2019/4/4
 */
public class Test {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/User/lxcfour/test");
        BufferedWriter bufferedWriter = Files.newBufferedWriter(path);
        bufferedWriter.write("1");
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
