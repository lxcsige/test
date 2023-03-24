package design.pattern.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuxucheng
 * @since 2022/12/29
 */
public class ChessBoard {

    private final Map<Integer, ChessPiece> chessPieces = new HashMap<>();

    public ChessBoard() {
        init();
    }

    private void init() {
        // 按照位置摆放摆放棋子
        chessPieces.put(1, new ChessPiece( ChessPieceUnit.getChessPieceUnit(1), 0,0));
        chessPieces.put(2, new ChessPiece( ChessPieceUnit.getChessPieceUnit(2), 1,0));
    }

    public void move(int chessPieceId, int toPositionX, int toPositionY) {
        //...省略...
    }
}
