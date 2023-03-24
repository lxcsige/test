package design.pattern.visitor;

/**
 * @author liuxucheng
 * @since 2023/1/18
 */
public abstract class ResourceFile {

    String path;

    public ResourceFile(String path) {
        this.path = path;
    }

    /**
     * 访问资源文件
     *
     * @param visitor
     */
    public abstract void accept(Visitor visitor);
}
