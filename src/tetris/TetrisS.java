package tetris;

import javafx.scene.paint.Color;

/**
 * Creates an S piece
 *
 * @author mmarder
 */
public class TetrisS extends TetrisPiece{
    
    TetrisSquare[] squareArray = new TetrisSquare[4];

    public TetrisS(TetrisBoard board,int XLoc,int YLoc){
       TetrisSquare square1 = new TetrisSquare(board);
        squareArray[0] = square1;
        TetrisSquare square2 = new TetrisSquare(board);
        squareArray[1] = square2;
        TetrisSquare square3 = new TetrisSquare(board);
        squareArray[2] = square3;
        TetrisSquare square4 = new TetrisSquare(board);
        squareArray[3] = square4;
        square1.moveToTetrisLocation(XLoc, YLoc);
        square2.moveToTetrisLocation(square1.getX()+0, square1.getY()-1);
        square3.moveToTetrisLocation(square1.getX()+1, square1.getY()-1);
        square4.moveToTetrisLocation(square1.getX()-1, square1.getY()+0);
        square1.setColor(Color.GREEN);
        square2.setColor(Color.GREEN);
        square3.setColor(Color.GREEN);
        square4.setColor(Color.GREEN);
    }
    @Override
    public TetrisSquare[] getSquares(){
        return squareArray;
    }

}