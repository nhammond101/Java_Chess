package com.logicnow.hiring.pieces;

import com.logicnow.hiring.InvalidMovementException;
import com.logicnow.hiring.MovementType;

public class Pawn extends ChessPiece
{

    public Pawn( PieceColor pieceColor )
    {
        this.pieceColor = pieceColor;
    }

    public void move( MovementType movementType, int newX, int newY ) throws InvalidMovementException
    {
        switch ( movementType )
        {
            case MOVE:
                if ( !isValidMoveForChessPiece( newX, newY ) )
                {
                    throw new InvalidMovementException( "Invalid movement", this, newX, newY, movementType );
                }
                break;
            case CAPTURE:
                if ( !isValidCaptureForChessPiece( newX, newY ) )
                {
                    throw new InvalidMovementException( "Invalid movement", this, newX, newY, movementType );
                }
                break;
            default:
                throw new InvalidMovementException( "Unrecognised MovementType: " + movementType, this, newX, newY, movementType );
        }


        // does a piece already occupy the new spot?
        ChessPiece occupyingPiece = getChessBoard().getPieceAtCoordinate( newX, newY );

        // if valid position and a piece already exists that isn't on the same side, capture
        if ( occupyingPiece != null )
        {
            // same colour, same side
            if ( this.getPieceColor().equals( occupyingPiece.getPieceColor() ) )
            {
                throw new InvalidMovementException( "A Chess piece on the same side already exists at position " + newX + "," + newY, this, newX, newY, movementType );
            }

            this.capturePiece( occupyingPiece );
        }

        // now move the piece to the new position
        this.setXCoordinate( newX );
        this.setYCoordinate( newY );

    }

    public boolean isValidMoveForChessPiece( int x, int y )
    {
        // Pawns can only move one space forward
        if ( this.getInitYCoordinate() - 2 < 0 )
        {
            // this pawn started at the bottom the of board so y must be one greater than current y coordinate
            return ( y - this.getYCoordinate() == 1 );
        }
        else
        {
            // this pawn started at the top the of board so y must be one less than current y coordinate
            return ( y - this.getYCoordinate() ) == -1;

        }


    }

    public boolean isValidCaptureForChessPiece( int x, int y )
    {
        throw new UnsupportedOperationException( "Need to implement Pawn.isValidCaptureForChessPiece()" );
    }
}
