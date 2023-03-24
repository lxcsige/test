package design.pattern.visitor;

/**
 * 文件压缩器
 *
 * @author liuxucheng
 * @since 2023/1/18
 */
public class Compressor implements Visitor {

    @Override
    public void visit(PptFile pptFile) {
        System.out.println("Compress PPT.");
    }

    @Override
    public void visit(PdfFile pdfFile) {
        System.out.println("Compress PDF.");
    }

    @Override
    public void visit(WordFile wordFile) {
        System.out.println("Compress Word.");
    }
}
