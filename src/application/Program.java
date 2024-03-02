package application;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;

public class Program {
    public static void main(String[] args) {
        var chessMatch = new ChessMatch();
        UI.printBoard(chessMatch.getPieces());
    }
}
