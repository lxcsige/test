package design.pattern.visitor.strategy;

/**
 * @author liuxucheng
 * @since 2023/1/19
 */
public class PdfExtractor implements Extractor {

    @Override
    public void extract2Txt(ResourceFile resourceFile) {
        System.out.println("Extract PDF.");
    }
}
