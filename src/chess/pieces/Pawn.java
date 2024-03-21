package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {
    public Pawn(Board board, Color color) {
        super(board, color);
    }

    private boolean canMove(Position position) {
        if (getBoard().thereIsAPiece(position)) {
           return isThereOpponentPiece(position);
        }
        return true;
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

        if (getColor() == Color.WHITE) {
            p.setValues(position.getRow() - 1, position.getColumn());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(position.getRow() - 2, position.getColumn());
            Position p2 = new Position(position.getRow() - 1, position.getColumn());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(position.getRow() - 1, position.getColumn() - 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(position.getRow() - 1, position.getColumn() + 1);
        }
        else {
            p.setValues(position.getRow() + 1, position.getColumn());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(position.getRow() + 2, position.getColumn());
            Position p2 = new Position(position.getRow() - 1, position.getColumn());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(position.getRow() + 1, position.getColumn() - 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(position.getRow() + 1, position.getColumn() + 1);
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }
        return mat;
///////////////////////////// PREVIOUS CODE (start movement is faulty) ///////////////////////
//        var mat = new boolean[getBoard().getColumns()][getBoard().getRows()];
//
//        var p = new Position(0, 0);
//
//        // forward
//        int range = (getMoveCount() == 0) ? 2 : 1;
//        int direction = (getColor() == Color.WHITE) ? -1 : 1;
//
//        for (int i = 1; i <= range; i++) {
//            p.setValues(position.getRow() + direction * i, position.getColumn());
//            if (i == 2) {
//                Position p2 = new Position (p.getRow() - direction, p.getColumn());
//
//                if (getBoard().positionExists(p2) && getBoard().thereIsAPiece(p2)) {
//                    mat[p.getRow()][p.getColumn()] = false;
//                }
//            } else if (getBoard().positionExists(p) && canMove(p)) {
////                if (getBoard().positionExists(p) && canMove(p)) {
//                mat[p.getRow()][p.getColumn()] = true;
//            }
//        }
//
//        // right diagonal capturing
//        p.setValues(position.getRow() + direction, position.getColumn() + 1);
//        if (getBoard().positionExists(p) && isThereOpponentPiece(p))
//            mat[p.getRow()][p.getColumn()] = true;
//
//        // left diagonal capturing
//        p.setValues(position.getRow() + direction, position.getColumn() - 1);
//        if (getBoard().positionExists(p) && isThereOpponentPiece(p))
//            mat[p.getRow()][p.getColumn()] = true;
//
//        return mat;
    }

    @Override
    public String toString() {
        return "P";
    }
}
