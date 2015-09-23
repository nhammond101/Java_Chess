package com.logicnow.hiring.pieces;

import com.logicnow.hiring.InvalidMovementException;
import com.logicnow.hiring.MovementType;
import com.logicnow.hiring.board.ChessBoard;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QueenTest
{

    private ChessBoard chessBoard;
    private Queen testSubject;

    @Before
    public void setUp() throws Exception
    {
        this.chessBoard = new ChessBoard();
        this.testSubject = new Queen( PieceColor.BLACK );
    }

    @After
    public void tearDown() throws Exception
    {
        this.chessBoard = null;
        this.testSubject = null;

    }

    @Test
    public void testPawn_Initial_Position()
    {
        assertEquals( this.testSubject.getXCoordinate(), -1 );
        assertEquals( this.testSubject.getYCoordinate(), -1 );
    }

    @Test
    public void testChessBoard_Add_Sets_XCoordinate() throws Exception
    {

        this.chessBoard.add( testSubject, 6, 3 );
        assertEquals( 6, testSubject.getXCoordinate() );

    }

    @Test
    public void testChessBoard_Add_Sets_YCoordinate() throws Exception
    {

        this.chessBoard.add( testSubject, 6, 3 );
        assertEquals( 3, testSubject.getYCoordinate() );


    }


    @Test( expected = InvalidMovementException.class )
    public void testPawn_Move_IllegalCoordinates_Right_DoesNotMove() throws Exception
    {

        chessBoard.add( testSubject, 6, 3 );
        testSubject.move( MovementType.MOVE, 7, 3 );
        assertEquals( 6, testSubject.getXCoordinate() );
        assertEquals( 3, testSubject.getYCoordinate() );

    }

    @Test( expected = InvalidMovementException.class )
    public void testPawn_Move_IllegalCoordinates_Left_DoesNotMove() throws Exception
    {

        chessBoard.add( testSubject, 6, 3 );
        testSubject.move( MovementType.MOVE, 4, 3 );
        assertEquals( 6, testSubject.getXCoordinate() );
        assertEquals( 3, testSubject.getYCoordinate() );

    }

    @Test( expected = InvalidMovementException.class )
    public void testPawn_Move_LegalCoordinates_Forward_UpdatesCoordinates() throws Exception
    {

        chessBoard.add( testSubject, 6, 3 );
        testSubject.move( MovementType.MOVE, 6, 2 );
    }

    @Test( expected = InvalidMovementException.class )
    public void testPawn_Move_LegalCoordinates_Forward_UpdatesCoordinates_Captures_Piece() throws Exception
    {

        chessBoard.add( testSubject, 6, 3 );
        ChessPiece oppositionPawn1 = new Pawn( PieceColor.WHITE );
        chessBoard.add( oppositionPawn1, 6, 2 );
        testSubject.move( MovementType.MOVE, 6, 2 );
        assertEquals( 6, testSubject.getXCoordinate() );
        assertEquals( 2, testSubject.getYCoordinate() );
        assertEquals( oppositionPawn1.getCapturedBy(), testSubject );
        assertEquals( -1, oppositionPawn1.getXCoordinate() );
        assertEquals( -1, oppositionPawn1.getYCoordinate() );
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testPawn_IsValidMoveForChessPiece_Is_Invalid() throws Exception
    {
        chessBoard.add( testSubject, 6, 3 );
        boolean result = testSubject.isValidMoveForChessPiece( 6, 6 );
        assertFalse( result );
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testPawn_IsValidMoveForChessPiece_Is_Valid() throws Exception
    {
        chessBoard.add( testSubject, 6, 3 );
        boolean result = testSubject.isValidMoveForChessPiece( 6, 4 );
        assertTrue( result );
    }

}