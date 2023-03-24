package design.pattern.visitor;

/**
 * 文件内容抽取器
 *
 * @author liuxucheng
 * @since 2023/1/18
 */
public class Extractor implements Visitor {

    @Override
    public void visit(PptFile pptFile) {
        System.out.println("Extract PPT.");
    }

    @Override
    public void visit(PdfFile pdfFile) {
        System.out.println("Extract PDF.");
    }

    @Override
    public void visit(WordFile wordFile) {
        System.out.println("Extract Word.");
    }
}
