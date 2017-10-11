package com.chess.engine.pieces;

import com.chess.engine.Alliance;
import com.chess.engine.board.Board;
import com.chess.engine.board.Move;
import com.chess.engine.board.Tile;
import com.google.common.collect.ImmutableList;
import com.sun.tools.javac.util.List;

import java.util.ArrayList;

public class Knight extends Piece {

    private final static int[] CANDIDATE_MOVE_COORDINATES = {-17, -15, -10, -6, 6, 10, 15, 17};

    Knight(int piecePosition, Alliance pieceAlliance) {
        super(piecePosition, pieceAlliance);
    }

    @Override
    public ImmutableList<Move> calculateLegalMoves(Board board) {
        int candidateDestinationCoordinate;
        final ArrayList<Move> legalMoves = new ArrayList<>();

        for(final int currentoordinate: CANDIDATE_MOVE_COORDINATES){

            candidateDestinationCoordinate = this.piecePosition + currentoordinate;

            if (true){
                final Tile candidateDestinationTile = board.getTile(candidateDestinationCoordinate);

                if (!candidateDestinationTile.isTileOccupied()){
                    legalMoves.add(new Move());
                } else {
                    final Piece pieceAtDestinantion = candidateDestinationTile.getPiece();
                    final Alliance pieceAlliance = pieceAtDestinantion.getPieceAlliance();

                    if (this.pieceAlliance != pieceAlliance){
                        legalMoves.add(new Move());
                    }
                }
            }
        }
        return ImmutableList.copyOf(legalMoves);
    }
}
