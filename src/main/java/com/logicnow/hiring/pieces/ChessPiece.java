package com.logicnow.hiring.pieces;

import com.logicnow.hiring.board.ChessBoard;

public abstract class ChessPiece implements IChessPiece
{

    private ChessBoard chessBoard;
    private int xCoordinate = -1;
    private int yCoordinate = -1;
    private int initXCoordinate = -1;
    private int initYCoordinate = -1;
    protected PieceColor pieceColor;
    private ChessPiece capturedBy;

    public ChessBoard getChessBoard()
    {
        return chessBoard;
    }

    public void setChessBoard( ChessBoard chessBoard )
    {
        this.chessBoard = chessBoard;
    }

    public int getXCoordinate()
    {
        return xCoordinate;
    }

    public void setXCoordinate( int value )
    {
        this.xCoordinate = value;
        if ( this.initXCoordinate == -1 && this.xCoordinate > -1 )
        {
            this.initXCoordinate = this.xCoordinate;
        }
    }

    public int getYCoordinate()
    {
        return yCoordinate;
    }

    public void setYCoordinate( int value )
    {
        this.yCoordinate = value;
        if ( this.initYCoordinate == -1 && this.yCoordinate > -1 )
        {
            this.initYCoordinate = this.yCoordinate;
        }
    }

    public int getInitXCoordinate()
    {
        return initXCoordinate;
    }

    public int getInitYCoordinate()
    {
        return initYCoordinate;
    }

    public PieceColor getPieceColor()
    {
        return this.pieceColor;
    }

    public ChessPiece getCapturedBy()
    {
        return capturedBy;
    }

    public void capturePiece( ChessPiece capturedPiece )
    {
        capturedPiece.capturedBy = this;
        capturedPiece.setXCoordinate( -1 );
        capturedPiece.setYCoordinate( -1 );
    }

    @Override
    public String toString()
    {
        return CurrentPositionAsString();
    }

    protected String CurrentPositionAsString()
    {
        String eol = System.lineSeparator();
        return String.format( "Current X: {1}{0}Current Y: {2}{0}Piece Color: {3}", eol, xCoordinate, yCoordinate, pieceColor );
    }

}
