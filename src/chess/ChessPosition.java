package chess;

import boardgame.Position;

public class ChessPosition {
    private int row;
    private char column;

    public ChessPosition(int row, char column) {
        this.row = row;
        this.column = column;
    }

    public Position toPosition() {
        return new Position(row, column);
    }

//    public static ChessPosition fromPosition(Position position) {
//        char column = Integer.
//        return new ChessPosition(position.getRow(), position.getColumn())
//    }
}
