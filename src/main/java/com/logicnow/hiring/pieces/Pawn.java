package com.logicnow.hiring.pieces;

import com.logicnow.hiring.InvalidMovementException;
import com.logicnow.hiring.MovementType;

public class Pawn extends ChessPiece
{

    public Pawn( PieceColor pieceColor )
    {
        this.pieceColor = pieceColor;
    }

    public void move( MovementType movementType, int newXCoordinate, int newYCoordinate ) throws InvalidMovementException
    {
        switch ( movementType )
        {
            case MOVE:
                if ( !isValidMoveForChessPiece( newXCoordinate, newYCoordinate ) )
                {
                    throw new InvalidMovementException( "Invalid movement", this, newXCoordinate, newYCoordinate, movementType );
                }
                break;
            case CAPTURE:
                if ( !isValidCaptureForChessPiece( newXCoordinate, newYCoordinate ) )
                {
                    throw new InvalidMovementException( "Invalid movement", this, newXCoordinate, newYCoordinate, movementType );
                }
                break;
            default:
                throw new InvalidMovementException( "Unrecognised MovementType: " + movementType, this, newXCoordinate, newYCoordinate, movementType );
        }


        // does a piece already occupy the new spot?
        ChessPiece occupyingPiece = getChessBoard().getPieceAtCoordinate( newXCoordinate, newYCoordinate );

        // if valid position and a piece already exists that isn't on the same side, capture
        if ( occupyingPiece != null )
        {
            // same colour, same side
            if ( this.getPieceColor().equals( occupyingPiece.getPieceColor() ) )
            {
                throw new InvalidMovementException( "A Chess piece on the same side already exists at position " + newXCoordinate + "," + newYCoordinate, this, newXCoordinate, newYCoordinate, movementType );
            }

            this.capturePiece( occupyingPiece );
        }

        // now move the piece to the new position
        this.setXCoordinate( newXCoordinate );
        this.setYCoordinate( newYCoordinate );

    }

    public boolean isValidMoveForChessPiece( int xCoordinate, int yCoordinate )
    {
        // Pawns can only move one space forward
        if ( this.getInitYCoordinate() - 2 < 0 )
        {
            // this pawn started at the bottom the of board so y must be one greater than current y coordinate
            return ( yCoordinate - this.getYCoordinate() == 1 );
        }
        else
        {
            // this pawn started at the top the of board so y must be one less than current y coordinate
            return ( yCoordinate - this.getYCoordinate() ) == -1;

        }


    }

    public boolean isValidCaptureForChessPiece( int xCoordinate, int yCoordinate )
    {
        throw new UnsupportedOperationException( "Need to implement Pawn.isValidCaptureForChessPiece()" );
    }
}
