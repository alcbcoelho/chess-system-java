package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece {
    private final Color color;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public ChessPosition getChessPosition() {
        return ChessPosition.fromPosition(position);
    }

    protected boolean isThereOpponentPiece(Position position) {
        return (getBoard().thereIsAPiece(position)) && (((ChessPiece) getBoard().piece(position)).getColor() != color);
    }
//
//    protected void increaseMoveCount() {
//        moveCount++;
//    }
//
//    protected void decreaseMoveCount() {
//        moveCount--;
//    }
}
