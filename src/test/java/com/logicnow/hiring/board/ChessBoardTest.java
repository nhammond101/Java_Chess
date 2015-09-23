package com.logicnow.hiring.board;

import com.logicnow.hiring.InvalidPositionException;
import com.logicnow.hiring.pieces.ChessPiece;
import com.logicnow.hiring.pieces.Pawn;
import com.logicnow.hiring.pieces.PieceColor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChessBoardTest
{

    private ChessBoard testSubject;

    @Before
    public void setUp() throws Exception
    {
        testSubject = new ChessBoard();
    }

    @Test
    public void testHas_MaxBoardWidth_of_7()
    {
        assertEquals( 7, ChessBoard.MAX_BOARD_HEIGHT );
    }

    @Test
    public void testHas_MaxBoardHeight_of_7()
    {
        assertEquals( 7, ChessBoard.MAX_BOARD_HEIGHT );
    }

    @Test
    public void testIsLegalBoardPosition_True_X_equals_0_Y_equals_0() throws Exception
    {
        boolean isValidPosition = testSubject.isLegalBoardPosition( 0, 0 );
        assertTrue( isValidPosition );
    }

    @Test
    public void testIsLegalBoardPosition_True_X_equals_5_Y_equals_5() throws Exception
    {
        boolean isValidPosition = testSubject.isLegalBoardPosition( 5, 5 );
        assertTrue( isValidPosition );
    }

    @Test
    public void testIsLegalBoardPosition_False_X_equals_11_Y_equals_5() throws Exception
    {
        boolean isValidPosition = testSubject.isLegalBoardPosition( 11, 5 );
        assertFalse( isValidPosition );
    }

    @Test
    public void testIsLegalBoardPosition_False_X_equals_0_Y_equals_9() throws Exception
    {
        boolean isValidPosition = testSubject.isLegalBoardPosition( 0, 9 );
        assertFalse( isValidPosition );
    }

    @Test
    public void testIsLegalBoardPosition_False_X_equals_11_Y_equals_0() throws Exception
    {
        boolean isValidPosition = testSubject.isLegalBoardPosition( 11, 0 );
        assertFalse( isValidPosition );
    }

    @Test
    public void testIsLegalBoardPosition_False_For_Negative_Y_Values() throws Exception
    {
        boolean isValidPosition = testSubject.isLegalBoardPosition( 5, -1 );
        Assert.assertFalse( isValidPosition );
    }

    @Test
    public void Avoids_Duplicate_Positioning() throws Exception
    {
        ChessPiece firstPawn = new Pawn( PieceColor.BLACK );
        ChessPiece secondPawn = new Pawn( PieceColor.BLACK );
        try
        {
            testSubject.add( firstPawn, 6, 3 );
            testSubject.add( secondPawn, 6, 3 );
        }
        catch (Exception e)
        {
            assertTrue( e instanceof InvalidPositionException );
            assertEquals( 6, ( (InvalidPositionException)e ).getxCoordinate() );
            assertEquals( 3, ( (InvalidPositionException)e ).getyCoordinate() );
            assertEquals( testSubject, ( (InvalidPositionException)e ).getChessBoard() );
        }
        assertEquals( 6, firstPawn.getXCoordinate() );
        assertEquals( 3, firstPawn.getYCoordinate() );
        assertEquals( -1, secondPawn.getYCoordinate() );
        assertEquals( -1, secondPawn.getYCoordinate() );
    }

    @Test
    public void testLimits_The_Number_Of_Pawns()
    {
        for ( int i = 0;
              i < 10;
              i++ )
        {
            ChessPiece pawn = new Pawn( PieceColor.BLACK );
            int row = i / ChessBoard.MAX_BOARD_WIDTH;
            try
            {
                testSubject.add( pawn, 6 + row, i % ChessBoard.MAX_BOARD_WIDTH );
            }
            catch (InvalidPositionException e)
            {
                if ( i < ChessBoard.MAX_BOARD_WIDTH )
                {
                    e.printStackTrace();
                    fail( e.getMessage() );
                }
            }
            if ( row < 1 )
            {
                assertEquals( 6 + row, pawn.getXCoordinate() );
                assertEquals( i % ChessBoard.MAX_BOARD_WIDTH, pawn.getYCoordinate() );
            }
            else
            {
                assertEquals( -1, pawn.getXCoordinate() );
                assertEquals( -1, pawn.getYCoordinate() );
            }
        }
    }
}