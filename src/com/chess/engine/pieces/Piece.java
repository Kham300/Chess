package com.chess.engine.pieces;

import com.chess.engine.Alliance;
import com.chess.engine.board.Board;
import com.chess.engine.board.Move;
import com.google.common.collect.ImmutableList;

import java.util.Collection;

public abstract class Piece {//класс шахматная фигура

    protected final int piecePosition;
    protected final Alliance pieceAlliance;

    Piece (final int piecePosition, final Alliance pieceAlliance){
        this.pieceAlliance = pieceAlliance;
        this.piecePosition = piecePosition;
    }

    public abstract Collection<Move> calculateLegalMoves(final Board board);

    public Alliance getPieceAlliance() {
        return this.pieceAlliance;
    }
}
