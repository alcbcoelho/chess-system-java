package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

    private ChessMatch chessMatch;

    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    private boolean checkRookCastling(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
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

        // # special move castling
        if (getMoveCount() == 0 && !chessMatch.getCheck()) {
            // # special move castling kingside rook
            var posR1 = new Position(position.getRow(), position.getColumn() + 3);
            if (checkRookCastling(posR1)) {
                var p1 = new Position(position.getRow(), position.getColumn() + 1);
                var p2 = new Position(position.getRow(), position.getColumn() + 2);

                if (!getBoard().thereIsAPiece(p1) && !getBoard().thereIsAPiece(p2)) {
                    mat[position.getRow()][position.getColumn() + 2] = true;
                }
            }
            // # special move castling queenside rook
            var posR2 = new Position(position.getRow(), position.getColumn() - 4);
            if (checkRookCastling(posR2)) {
                var p1 = new Position(position.getRow(), position.getColumn() - 1);
                var p2 = new Position(position.getRow(), position.getColumn() - 2);
                var p3 = new Position(position.getRow(), position.getColumn() - 3);

                if (!getBoard().thereIsAPiece(p1) && !getBoard().thereIsAPiece(p2) && !getBoard().thereIsAPiece(p3)) {
                        mat[position.getRow()][position.getColumn() - 2] = true;
                }
            }
        }

        return mat;
    }
}
