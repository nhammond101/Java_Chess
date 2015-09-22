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

    public void move( MovementType movementType, int newX, int newY ) throws InvalidMovementException
    {
        throw new InvalidMovementException( "Unsupported Move", this, newX, newY, movementType, new UnsupportedOperationException( "Need to implement Queen.move()" ) );
    }

    public boolean isValidMoveForChessPiece( int x, int y )
    {
        throw new UnsupportedOperationException( "Need to implement Queen.isValidMoveForChessPiece()" );
    }

    public boolean isValidCaptureForChessPiece( int x, int y )
    {
        throw new UnsupportedOperationException( "Need to implement Queen.isValidCaptureForChessPiece()" );
    }
}
