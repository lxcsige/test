package design.pattern.strategy;

/**
 * @author liuxucheng
 * @since 2023/1/9
 */
public interface ISortAlg {

    /**
     * 对文件内容进行排序
     *
     * @param filePath
     */
    void sort(String filePath);
}
