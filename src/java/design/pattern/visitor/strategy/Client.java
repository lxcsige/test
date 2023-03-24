package design.pattern.visitor.strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * 策略（不同的文件内容抽取策略）+简单工厂模式（创建不同的策略对象）
 * 仅适用于业务功能不多的场景
 *
 * @author liuxucheng
 * @since 2023/1/19
 */
public class Client {

    public static void main(String[] args) {
        List<ResourceFile> resourceFiles = new ArrayList<>();
        resourceFiles.add(new PdfFile("a.pdf"));
        resourceFiles.add(new WordFile("b.word"));
        resourceFiles.add(new PptFile("c.ppt"));

        for (ResourceFile resourceFile : resourceFiles) {
            Extractor extractor = ExtractorFactory.getExtractor(resourceFile.getType());
            extractor.extract2Txt(resourceFile);
        }
    }
}
