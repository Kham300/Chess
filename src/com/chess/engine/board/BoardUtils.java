package com.chess.engine.board;

public class BoardUtils {

    public static final boolean[] FIRST_COLUMN = initColumn(0); //инициалтзировать первую колнку true
    public static final boolean[] SECOND_COLUMN = initColumn(1);
    public static final boolean[] SEVENTH_COLUMN = initColumn(6) ;
    public static final boolean[] EIGHTH_COLUMN = initColumn(7) ;

    public static final boolean[] EIGHTH_RANK = initRow(0);
    public static final boolean[] SEVENTH_RANK = initRow(8);
    public static final boolean[] SIXTH_RANK = initRow(16);
    public static final boolean[] FIFTH_RANK = initRow(24);
    public static final boolean[] FOURTH_RANK = initRow(32);
    public static final boolean[] THIRD_RANK = initRow(40);
    public static final boolean[] SECOND_RANK = initRow(48);
    public static final boolean[] FIRST_RANK = initRow(56);

    public static final int NUM_TILES = 64;
    public static final int NUM_PER_ROWS = 8;

    private static boolean[] initRow(int rowNumber) {
        final boolean [] row = new boolean[NUM_TILES];
        do{
           row[rowNumber] = true;
           rowNumber++;
        } while (rowNumber % NUM_PER_ROWS != 0);
        return row;
    }

    private static boolean[] initColumn(int columnNumber) {
        final boolean[] column = new boolean[NUM_TILES];
        do{
            column[columnNumber] = true;
            columnNumber += NUM_PER_ROWS;
        } while(columnNumber < NUM_TILES);
        return column;
    }


    private BoardUtils(){
        throw new RuntimeException("You cant instaniate me!");
    }

    public static boolean isValidCoordinate(int coordinate) {
        return coordinate >=0 && coordinate<64;
    }
}
