package com.chess.engine.pieces;

import com.chess.engine.Alliance;
import com.chess.engine.board.Board;
import com.chess.engine.board.BoardUtils;
import com.chess.engine.board.Move;
import com.chess.engine.board.Move.AttackMove;
import com.chess.engine.board.Move.MajorMove;
import com.chess.engine.board.Tile;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;

public class Knight extends Piece {

    private final static int[] CANDIDATE_MOVE_COORDINATES = {-17, -15, -10, -6, 6, 10, 15, 17};

    public Knight(final Alliance pieceAlliance,
                  final int piecePosition) {
        super(piecePosition, pieceAlliance);
    }

    @Override
    public ImmutableList<Move> calculateLegalMoves(final Board board) {

        final ArrayList<Move> legalMoves = new ArrayList<>();//

        for(final int currentCoordinateOffset: CANDIDATE_MOVE_COORDINATES){

           final int candidateDestinationCoordinate = this.piecePosition + currentCoordinateOffset;

            if (BoardUtils.isValidCoordinate(candidateDestinationCoordinate)){//проверка на выход за пределы массива и вообще имеется ли такая ячейка
                if(isFirstColumnExclusion(this.piecePosition, currentCoordinateOffset) ||
                        isSecondColumnExclusion(this.piecePosition, currentCoordinateOffset)||
                        isSeventhColumnExclusion(this.piecePosition,currentCoordinateOffset)||
                        isEighthColumnExclusion(this.piecePosition, currentCoordinateOffset)){
                    continue;
                }
                final Tile candidateDestinationTile = board.getTile(candidateDestinationCoordinate);

                if (!candidateDestinationTile.isTileOccupied()){
                    legalMoves.add(new MajorMove(board, this, candidateDestinationCoordinate));
                } else {
                    final Piece pieceAtDestinantion = candidateDestinationTile.getPiece();//берем фигуру
                    final Alliance pieceAlliance = pieceAtDestinantion.getPieceAlliance();//выясняем чей альянс

                    if (this.pieceAlliance != pieceAlliance){//и если противник
                        legalMoves.add(new AttackMove(board, this, candidateDestinationCoordinate, pieceAtDestinantion));//то атакуем и съедаем фигуру
                    }
                }
            }
        }
        return ImmutableList.copyOf(legalMoves);
    }

    @Override
    public String toString() {
        return PieceType.KNIGHT.toString();
    }

    private static boolean isFirstColumnExclusion(final int currentPosition, final int candidateOffset){
        return BoardUtils.FIRST_COLUMN[currentPosition] && (candidateOffset == -17||candidateOffset == -10 ||
                candidateOffset == 6 || candidateOffset == 15);
    }

    private static boolean isSecondColumnExclusion(final int currentPosition, final int candidateOffset){
        return BoardUtils.SECOND_COLUMN[currentPosition]&& (candidateOffset==-10 || candidateOffset==6);
    }

    private static boolean isSeventhColumnExclusion(final int currentPosition, final int candidateOffset){
        return BoardUtils.SEVENTH_COLUMN[currentPosition] && (candidateOffset == -6 || candidateOffset == 10);
    }

    private static boolean isEighthColumnExclusion(final int currentPosition, final int candidateOffset){
        return BoardUtils.EIGHTH_COLUMN[currentPosition] && (candidateOffset == -15|| candidateOffset == -6 ||
                candidateOffset == 10||candidateOffset == 17);
    }

}
