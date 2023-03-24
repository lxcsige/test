package oop.solid.lsp;

/**
 * @author liuxucheng
 * @since 2022/11/22
 */
public class Main {

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.setLength(4);
        rectangle.setWidth(3);
        // 如果用Square替换掉父类则会出错
        System.out.println("area = " + rectangle.getLength() * rectangle.getWidth());
    }
}
