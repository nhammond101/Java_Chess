package com.logicnow.hiring.pieces;

import com.logicnow.hiring.InvalidMovementException;
import com.logicnow.hiring.MovementType;
import com.logicnow.hiring.board.ChessBoard;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PawnTest
{

    private ChessBoard chessBoard;
    private Pawn testSubject;

    @Before
    public void setUp() throws Exception
    {
        this.chessBoard = new ChessBoard();
        this.testSubject = new Pawn( PieceColor.BLACK );
    }

    @After
    public void tearDown() throws Exception
    {
        this.chessBoard = null;
        this.testSubject = null;

    }

    @Test
    public void testPawn_ToString()
    {
        assertEquals( "Current X: -1"+System.lineSeparator()+"Current Y: -1"+System.lineSeparator()+"Piece Color: BLACK", this.testSubject.toString() );
    }

    @Test
    public void testPawn_Initial_Position()
    {
        assertEquals( this.testSubject.getXCoordinate(), -1 );
        assertEquals( this.testSubject.getYCoordinate(), -1 );
        assertEquals( this.testSubject.getInitXCoordinate(), -1 );
        assertEquals( this.testSubject.getInitYCoordinate(), -1 );
    }

    @Test
    public void testChessBoard_Add_Sets_XCoordinate() throws Exception
    {

        this.chessBoard.add( testSubject, 0, 0 );
        assertEquals( 0, testSubject.getXCoordinate() );

    }

    @Test
    public void testChessBoard_Add_Sets_YCoordinate() throws Exception
    {

        this.chessBoard.add( testSubject, 0, 0 );
        assertEquals( 0, testSubject.getYCoordinate() );
        assertEquals( 0, testSubject.getInitYCoordinate() );
    }


    @Test( expected = InvalidMovementException.class )
    public void testPawn_Move_IllegalCoordinates_Right_DoesNotMove() throws Exception
    {

        chessBoard.add( testSubject, 0, 0 );
        testSubject.move( MovementType.MOVE, 1, 0 );
        assertEquals( 0, testSubject.getXCoordinate() );
        assertEquals( 0, testSubject.getYCoordinate() );

    }

    @Test( expected = InvalidMovementException.class )
    public void testPawn_Move_IllegalCoordinates_Left_DoesNotMove() throws Exception
    {

        chessBoard.add( testSubject, 1, 0 );
        testSubject.move( MovementType.MOVE, 0, 0 );
        assertEquals( 1, testSubject.getXCoordinate() );
        assertEquals( 0, testSubject.getYCoordinate() );

    }

    @Test
    public void testPawn_Move_IllegalCoordinates_Back_DoesNotMove() throws Exception
    {

        chessBoard.add( testSubject, 0, 0 );
        testSubject.move( MovementType.MOVE, 0, 1 );

        // use try/catch to test the coordinates are set in the exception properly
        try
        {
            testSubject.move( MovementType.MOVE, 0, 0 );
        }
        catch (InvalidMovementException e)
        {
            assertEquals( 0, e.getxCoordinate() );
            assertEquals( 0, e.getyCoordinate() );
        }
        assertEquals( 0, testSubject.getXCoordinate() );
        assertEquals( 1, testSubject.getYCoordinate() );

    }

    @Test( expected = InvalidMovementException.class )
    public void testPawn_Move_IllegalCoordinates_OccupiedBySameSide_DoesNotMove() throws Exception
    {
        ChessPiece occupiedPiece = new Pawn( testSubject.getPieceColor() );
        chessBoard.add( testSubject, 0, 0 );
        chessBoard.add( occupiedPiece, 0, 1 );
        testSubject.move( MovementType.MOVE, 0, 1 );
        assertEquals( 0, testSubject.getXCoordinate() );
        assertEquals( 1, testSubject.getYCoordinate() );
    }

    @Test
    public void testPawn_Move_LegalCoordinates_Forward_UpdatesCoordinates() throws Exception
    {

        chessBoard.add( testSubject, 0, 0 );
        testSubject.move( MovementType.MOVE, 0, 1 );
        assertEquals( 0, testSubject.getXCoordinate() );
        assertEquals( 1, testSubject.getYCoordinate() );
    }

    @Test
    public void testPawn_Move_LegalCoordinates_TopOfBoard_Forward_UpdatesCoordinates() throws Exception
    {
        // top of the board
        chessBoard.add( testSubject, 6, 6 );
        testSubject.move( MovementType.MOVE, 6, 5 );
        assertEquals( 6, testSubject.getXCoordinate() );
        assertEquals( 5, testSubject.getYCoordinate() );
    }

    @Test
    public void testPawn_Move_LegalCoordinates_Forward_UpdatesCoordinates_Captures_Piece() throws Exception
    {

        chessBoard.add( testSubject, 0, 0 );
        ChessPiece oppositionPawn1 = new Pawn( PieceColor.WHITE );
        chessBoard.add( oppositionPawn1, 0, 1 );
        testSubject.move( MovementType.MOVE, 0, 1 );
        assertEquals( 0, testSubject.getXCoordinate() );
        assertEquals( 1, testSubject.getYCoordinate() );
        assertEquals( oppositionPawn1.getCapturedBy(), testSubject );
        assertEquals( -1, oppositionPawn1.getXCoordinate() );
        assertEquals( -1, oppositionPawn1.getYCoordinate() );
    }

    @Test
    public void testPawn_IsValidMoveForChessPiece_Is_Invalid() throws Exception
    {
        chessBoard.add( testSubject, 0, 0 );
        boolean result = testSubject.isValidMoveForChessPiece( 6, 6 );
        assertFalse( result );
    }

    @Test
    public void testPawn_IsValidMoveForChessPiece_Is_Valid() throws Exception
    {
        chessBoard.add( testSubject, 0, 0 );
        boolean result = testSubject.isValidMoveForChessPiece( 0, 1 );
        assertTrue( result );
    }

    @Test( expected = UnsupportedOperationException.class )
    public void testPawn_IsValidCaptureForChessPiece_Is_Invalid() throws Exception
    {
        ChessPiece capturePiece = new Pawn( PieceColor.WHITE );

        chessBoard.add( testSubject, 0, 0 );
        chessBoard.add( capturePiece, 3, 2 );

        boolean result = testSubject.isValidCaptureForChessPiece( 3, 2 );
        assertFalse( result );
    }

    @Test( expected = UnsupportedOperationException.class )
    public void testPawn_IsValidCaptureForChessPiece_Is_Valid() throws Exception
    {
        ChessPiece capturePiece = new Pawn( PieceColor.WHITE );

        chessBoard.add( testSubject, 0, 0 );
        chessBoard.add( capturePiece, 0, 1 );

        boolean result = testSubject.isValidCaptureForChessPiece( 0, 1 );
        assertTrue( result );
    }

}