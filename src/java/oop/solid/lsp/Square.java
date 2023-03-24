package oop.solid.lsp;

/**
 * @author liuxucheng
 * @since 2022/11/22
 */
public class Square extends Rectangle {

    public void setLength(int length) {
        super.setLength(length);
        super.setWidth(length);
    }

    public void setWidth(int width) {
        super.setLength(width);
        super.setWidth(width);
    }
}
