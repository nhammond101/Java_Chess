package com.logicnow.hiring.pieces;

import com.logicnow.hiring.InvalidMovementException;
import com.logicnow.hiring.MovementType;

/**
 * User: Nick Hammond
 * Date: 22/09/2015
 * Time: 11:55
 * <p/>
 * BrightSkyApps
 * www.brightskyapps.com
 */
public class Queen extends ChessPiece
{

    public Queen( PieceColor pieceColor )
    {
        this.pieceColor = pieceColor;
    }

    public void move( MovementType movementType, int newXCoordinate, int newYCoordinate ) throws InvalidMovementException
    {
        throw new InvalidMovementException( "Unsupported Move", this, newXCoordinate, newYCoordinate, movementType, new UnsupportedOperationException( "Need to implement Queen.move()" ) );
    }

    public boolean isValidMoveForChessPiece( int xCoordinate, int yCoordinate )
    {
        throw new UnsupportedOperationException( "Need to implement Queen.isValidMoveForChessPiece()" );
    }

    public boolean isValidCaptureForChessPiece( int xCoordinate, int yCoordinate )
    {
        throw new UnsupportedOperationException( "Need to implement Queen.isValidCaptureForChessPiece()" );
    }
}
