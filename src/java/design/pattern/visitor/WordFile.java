package design.pattern.visitor;

/**
 * @author liuxucheng
 * @since 2023/1/18
 */
public class WordFile extends ResourceFile {

    public WordFile(String path) {
        super(path);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}