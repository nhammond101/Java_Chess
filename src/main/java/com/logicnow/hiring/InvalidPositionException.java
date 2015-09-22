package com.logicnow.hiring;

import com.logicnow.hiring.board.ChessBoard;
import com.logicnow.hiring.board.ChessboardException;

/**
 * User: Nick Hammond
 * Date: 19/09/2015
 * Time: 21:47
 * <p/>
 * BrightSkyApps
 * www.brightskyapps.com
 */
public class InvalidPositionException extends ChessboardException
{
    protected int xCoordinate;
    protected int yCoordinate;

    public InvalidPositionException( String message, ChessBoard chessBoard, int xCoordinate, int yCoordinate )
    {
        super( message, chessBoard );
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public InvalidPositionException( String message, ChessBoard chessBoard, int xCoordinate, int yCoordinate, Throwable cause )
    {
        super( message, chessBoard, cause );
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public int getxCoordinate()
    {
        return xCoordinate;
    }

    public int getyCoordinate()
    {
        return yCoordinate;
    }
}
