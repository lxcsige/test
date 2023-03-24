package design.pattern.composite;

/**
 * @author liuxucheng
 * @since 2022/12/28
 */
public abstract class FsNode {

    /**
     * 路径名
     */
    protected String path;

    public FsNode(String path) {
        this.path = path;
    }

    /**
     * 计算文件总数，不包含目录
     *
     * @return
     */
    public abstract int countNumOfFiles();

    /**
     * 计算文件总大小，不包含目录
     *
     * @return
     */
    public abstract long countSizeOfFiles();

    public String getPath() {
        return path;
    }
}
