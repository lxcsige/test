package design.pattern.visitor.strategy;

/**
 * @author liuxucheng
 * @since 2023/1/19
 */
public class PdfFile extends ResourceFile {

    public PdfFile(String filePath) {
        super(filePath);
    }

    @Override
    public ResourceFileType getType() {
        return ResourceFileType.PDF;
    }
}
