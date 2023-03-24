package design.pattern.flyweight;

/**
 * @author liuxucheng
 * @since 2022/12/29
 */
public class ChessPiece {

    private ChessPieceUnit unit;

    private int positionX;

    private int positionY;

    public ChessPiece(ChessPieceUnit unit, int positionX, int positionY) {
        this.unit = unit;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public ChessPieceUnit getUnit() {
        return unit;
    }

    public void setUnit(ChessPieceUnit unit) {
        this.unit = unit;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
}
