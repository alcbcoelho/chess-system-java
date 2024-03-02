package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public class ChessPiece extends Piece {
    private final Color color;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

//    public ChessPosition getChessPosition() {
//        return new ChessPosition(position.getRow(), position.getColumn());
//    }
//
//    protected boolean isThereOpponentPiece(Position position) {
//
//    }
//
//    protected void increaseMoveCount() {
//        moveCount++;
//    }
//
//    protected void decreaseMoveCount() {
//        moveCount--;
//    }
}
