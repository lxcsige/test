package design.pattern.visitor;

/**
 * @author liuxucheng
 * @since 2023/1/18
 */
public class PdfFile extends ResourceFile {

    public PdfFile(String path) {
        super(path);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
