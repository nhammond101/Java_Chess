package com.logicnow.hiring.board;

import com.logicnow.hiring.InvalidPositionException;
import com.logicnow.hiring.pieces.ChessPiece;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChessBoard
{
    final Logger log = LoggerFactory.getLogger( ChessBoard.class );
    public static int MAX_BOARD_WIDTH = 7;
    public static int MAX_BOARD_HEIGHT = 7;

    private ChessPiece[][] pieces;

    public ChessBoard()
    {
        pieces = new ChessPiece[MAX_BOARD_WIDTH][MAX_BOARD_HEIGHT];

    }

    /**
     * Adds a chess piece to the chess board
     *
     * @param chessPiece  ChessPiece to add
     * @param xCoordinate Integer x coordinate to set the chess piece to
     * @param yCoordinate Integer x coordinate to set the chess piece to
     * @throws InvalidPositionException if the x,y coordinates are invalid or already occupied
     */
    public void add( ChessPiece chessPiece, int xCoordinate, int yCoordinate ) throws InvalidPositionException
    {
        if ( !isLegalBoardPosition( xCoordinate, yCoordinate ) )
        {
            throw new InvalidPositionException( "Position: " + xCoordinate + "," + yCoordinate + " outwith board limits", this, xCoordinate, yCoordinate);
        }
        chessPiece.setXCoordinate( xCoordinate );
        chessPiece.setYCoordinate( yCoordinate );
        chessPiece.setChessBoard( this );
        this.pieces[xCoordinate][yCoordinate] = chessPiece;
    }

    /**
     * Determines if the coordinates provided are valid.  Currently coordinate out of bounds of the board, or those
     * already occupied will be deemed invalid
     *
     * @param xCoordinate Integer for checking the ChessBoard's X coordinate against
     * @param yCoordinate Integer for checking the ChessBoard's Y coordinate against
     * @return Boolean if the x,y coordinates are valid
     * @throws InvalidPositionException
     */
    public boolean isLegalBoardPosition( int xCoordinate, int yCoordinate ) throws InvalidPositionException
    {
        if ( xCoordinate < 0 || xCoordinate >= MAX_BOARD_WIDTH || yCoordinate < 0 || yCoordinate >= MAX_BOARD_HEIGHT )
        {
            log.warn( "Coordinate: {},{} is outwith this board's limits", xCoordinate, yCoordinate );
            return false;
        }

        if ( null != getPieceAtCoordinate( xCoordinate, yCoordinate ) )
        {
            log.warn( "Coordinate: {},{} is already populated", xCoordinate, yCoordinate );
            return false;
        }

        return true;
    }

    /**
     * Returns the ChessPiece at the requested coordinate
     *
     * @param xCoordinate Integer x coordinate to check for Chess Pieces
     * @param yCoordinate Integer y coordinate to check for Chess Pieces
     * @return ChessPiece if one found or null
     */
    public ChessPiece getPieceAtCoordinate( int xCoordinate, int yCoordinate )
    {
        return this.pieces[xCoordinate][yCoordinate];
    }
}
