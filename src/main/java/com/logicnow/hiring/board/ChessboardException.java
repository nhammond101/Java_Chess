package com.logicnow.hiring.board;

import com.logicnow.hiring.board.ChessBoard;

/**
 * User: Nick Hammond
 * Date: 19/09/2015
 * Time: 21:46
 * <p/>
 * BrightSkyApps
 * www.brightskyapps.com
 */
public class ChessboardException extends Exception
{
    protected ChessBoard chessBoard;

    public ChessboardException( String message, ChessBoard chessBoard )
    {
        super( message );
        this.chessBoard = chessBoard;
    }

    public ChessboardException( String message, ChessBoard chessBoard, Throwable cause )
    {
        super( message, cause );
        this.chessBoard = chessBoard;
    }

    public ChessBoard getChessBoard()
    {
        return this.chessBoard;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "ChessboardException{" );
        sb.append( "chessBoard=" ).append( chessBoard );
        sb.append( '}' );
        return sb.toString();
    }
}
