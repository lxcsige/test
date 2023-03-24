package design.pattern.visitor.strategy;

/**
 * @author liuxucheng
 * @since 2023/1/19
 */
public class WordFile extends ResourceFile {

    public WordFile(String filePath) {
        super(filePath);
    }

    @Override
    public ResourceFileType getType() {
        return ResourceFileType.WORD;
    }
}
