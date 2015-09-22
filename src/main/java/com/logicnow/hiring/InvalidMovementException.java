package com.logicnow.hiring;

import com.logicnow.hiring.pieces.ChessPiece;
import com.logicnow.hiring.pieces.ChessPieceException;

/**
 * User: Nick Hammond
 * Date: 19/09/2015
 * Time: 21:47
 * <p/>
 * BrightSkyApps
 * www.brightskyapps.com
 */
public class InvalidMovementException extends ChessPieceException
{
    protected int xCoordinate;
    protected int yCoordinate;
    protected MovementType movementType;

    public InvalidMovementException( String message, ChessPiece chessPiece, int xCoordinate, int yCoordinate, MovementType movementType )
    {
        super( message, chessPiece );
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.movementType = movementType;
    }

    public InvalidMovementException( String message, ChessPiece chessPiece, int xCoordinate, int yCoordinate, MovementType movementType, Throwable cause )
    {
        super( message, chessPiece, cause );
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.movementType = movementType;
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
