package com.logicnow.hiring.pieces;

import com.logicnow.hiring.InvalidMovementException;
import com.logicnow.hiring.MovementType;

/**
 * User: Nick Hammond
 * Date: 21/09/2015
 * Time: 16:11
 * <p/>
 * BrightSkyApps
 * www.brightskyapps.com
 */
public interface IChessPiece
{
    /**
     * Controls the movement of a chess piece
     *
     * @param movementType MovementType of the Chess Piece's movement
     * @param newXCoordinate         Integer new x coordinate
     * @param newYCoordinate         Integer new y coordinate
     * @throws InvalidMovementException
     */
    void move( MovementType movementType, int newXCoordinate, int newYCoordinate ) throws InvalidMovementException;

    /**
     * Method for determining if the Chess Piece's proposed move is a valid one
     *
     * @param xCoordinate   Integer representing the 'new' x coordinate on the board
     * @param yCoordinate   Integer representing the 'new' y coordinate on the board
     * @return  Boolean true if the move would be legal, false if not
     */
    boolean isValidMoveForChessPiece( int xCoordinate, int yCoordinate );

    /**
     *  Method for determining if the Chess Piece's proposed capture action is a valid one
     *
     * @param xCoordinate  Integer representing the 'new' x coordinate on the board
     * @param yCoordinate  Integer representing the 'new' y coordinate on the board
     * @return Boolean true if the move would be legal, false if not
     */
    boolean isValidCaptureForChessPiece( int xCoordinate, int yCoordinate );

}
