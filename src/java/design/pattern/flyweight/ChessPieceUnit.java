package design.pattern.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 棋子享元类，所有棋盘共享
 *
 * @author liuxucheng
 * @since 2022/12/29
 */
public class ChessPieceUnit {

    private final int id;

    private final String name;

    private final ColorEnum color;

    public ChessPieceUnit(int id, String name, ColorEnum color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ColorEnum getColor() {
        return color;
    }

    public enum ColorEnum {
        RED,
        BLACK;
    }

    public static ChessPieceUnit getChessPieceUnit(int id) {
        return ChessPieceUnitCache.CACHE_MAP.get(id);
    }

    public static class ChessPieceUnitCache {

        private static final Map<Integer, ChessPieceUnit> CACHE_MAP = new HashMap<>();

        static {
            CACHE_MAP.put(1, new ChessPieceUnit(1, "車", ChessPieceUnit.ColorEnum.RED));
            CACHE_MAP.put(2, new ChessPieceUnit(2,"馬", ChessPieceUnit.ColorEnum.BLACK));
        }
    }
}
