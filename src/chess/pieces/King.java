package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {
    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "K";
    }

    private boolean canMove(Position position) {
        return !getBoard().thereIsAPiece(position) || isThereOpponentPiece(position);
    }

    @Override
    public boolean[][] possibleMoves() {
        // this is temporary
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

        // top
        p.setValues(position.getRow() - 1, position.getColumn());
        if (getBoard().positionExists(p) && canMove(p))
            mat[p.getRow()][p.getColumn()] = true;

        // bottom
        p.setValues(position.getRow() + 1, position.getColumn());
        if (getBoard().positionExists(p) && canMove(p))
            mat[p.getRow()][p.getColumn()] = true;

        // left
        p.setValues(position.getRow(), position.getColumn() - 1);
        if (getBoard().positionExists(p) && canMove(p))
            mat[p.getRow()][p.getColumn()] = true;

        // right
        p.setValues(position.getRow(), position.getColumn() + 1);
        if (getBoard().positionExists(p) && canMove(p))
            mat[p.getRow()][p.getColumn()] = true;

        // top left
        p.setValues(position.getRow() - 1, position.getColumn() - 1);
        if (getBoard().positionExists(p) && canMove(p))
            mat[p.getRow()][p.getColumn()] = true;

        // top right
        p.setValues(position.getRow() - 1, position.getColumn() + 1);
        if (getBoard().positionExists(p) && canMove(p))
            mat[p.getRow()][p.getColumn()] = true;

        // bottom left
        p.setValues(position.getRow() + 1, position.getColumn() - 1);
        if (getBoard().positionExists(p) && canMove(p))
            mat[p.getRow()][p.getColumn()] = true;

        // bottom right
        p.setValues(position.getRow() + 1, position.getColumn() + 1);
        if (getBoard().positionExists(p) && canMove(p))
            mat[p.getRow()][p.getColumn()] = true;

        return mat;
    }
}
