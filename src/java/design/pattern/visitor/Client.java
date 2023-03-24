package design.pattern.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuxucheng
 * @since 2023/1/18
 */
public class Client {

    public static void main(String[] args) {
        List<ResourceFile> resourceFiles = new ArrayList<>();
        resourceFiles.add(new PdfFile("a.pdf"));
        resourceFiles.add(new WordFile("b.word"));
        resourceFiles.add(new PptFile("c.ppt"));

        Extractor extractor = new Extractor();
        for (ResourceFile resourceFile : resourceFiles) {
            resourceFile.accept(extractor);
        }

        Compressor compressor = new Compressor();
        for(ResourceFile resourceFile : resourceFiles) {
            resourceFile.accept(compressor);
        }
    }
}
