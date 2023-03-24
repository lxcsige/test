package design.pattern.visitor.strategy;

/**
 * @author liuxucheng
 * @since 2023/1/19
 */
public enum ResourceFileType {
    /**
     * PPT文件
     */
    PPT(1),
    /**
     * PDF文件
     */
    PDF(2),
    /**
     * word文件
     */
    WORD(3);

    int value;

    ResourceFileType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
