package design.pattern.visitor.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuxucheng
 * @since 2023/1/19
 */
public class ExtractorFactory {

    private static Map<ResourceFileType, Extractor> extractorMap = new HashMap<>();

    static {
        extractorMap.put(ResourceFileType.PPT, new PptExtractor());
        extractorMap.put(ResourceFileType.PDF, new PdfExtractor());
        extractorMap.put(ResourceFileType.WORD, new WordExtractor());
    }

    public static Extractor getExtractor(ResourceFileType resourceFileType) {
        return extractorMap.get(resourceFileType);
    }
}
