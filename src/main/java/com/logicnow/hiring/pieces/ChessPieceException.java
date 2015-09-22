package com.logicnow.hiring.pieces;

import com.logicnow.hiring.pieces.ChessPiece;

/**
 * User: Nick Hammond
 * Date: 21/09/2015
 * Time: 12:47
 * <p/>
 * BrightSkyApps
 * www.brightskyapps.com
 */
public class ChessPieceException extends Exception
{
    private ChessPiece chessPiece;

    public ChessPieceException( String message, ChessPiece chessPiece )
    {
        super( message );
        this.chessPiece = chessPiece;
    }

    public ChessPieceException( String message, ChessPiece chessPiece, Throwable cause )
    {
        super( message, cause );
        this.chessPiece = chessPiece;
    }
}
