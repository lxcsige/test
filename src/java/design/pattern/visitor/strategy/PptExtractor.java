package design.pattern.visitor.strategy;

/**
 * @author liuxucheng
 * @since 2023/1/19
 */
public class PptExtractor implements Extractor {

    @Override
    public void extract2Txt(ResourceFile resourceFile) {
        System.out.println("Extract PPT.");
    }
}
