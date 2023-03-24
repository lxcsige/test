package design.pattern.visitor;

/**
 * @author liuxucheng
 * @since 2023/1/18
 */
public interface Visitor {

    /**
     * PPT类型文件的访问方法
     *
     * @param pptFile
     */
    void visit(PptFile pptFile);

    /**
     * PDF类型文件的访问方法
     *
     * @param pdfFile
     */
    void visit(PdfFile pdfFile);

    /**
     * Word类型文件的访问方法
     *
     * @param wordFile
     */
    void visit(WordFile wordFile);
}
