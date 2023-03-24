package design.pattern.visitor.strategy;

/**
 * @author liuxucheng
 * @since 2023/1/19
 */
public class PptFile extends ResourceFile {

    public PptFile(String filePath) {
        super(filePath);
    }

    @Override
    public ResourceFileType getType() {
        return ResourceFileType.PPT;
    }
}
