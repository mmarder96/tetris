package tetris;

import javafx.scene.paint.Color;

/**
 * Creates a J piece
 *
 * @author mmarder
 */
public class TetrisJ extends TetrisPiece {

    TetrisSquare[] squareArray = new TetrisSquare[4];

    public TetrisJ(TetrisBoard board, int XLoc, int YLoc) {
       TetrisSquare square1 = new TetrisSquare(board);
        squareArray[0] = square1;
        TetrisSquare square2 = new TetrisSquare(board);
        squareArray[1] = square2;
        TetrisSquare square3 = new TetrisSquare(board);
        squareArray[2] = square3;
        TetrisSquare square4 = new TetrisSquare(board);
        squareArray[3] = square4;
        square1.moveToTetrisLocation(XLoc, YLoc);
        square2.moveToTetrisLocation(square1.getX() + 0, square1.getY() - 1);
        square3.moveToTetrisLocation(square1.getX() + 0, square1.getY() + 1);
        square4.moveToTetrisLocation(square1.getX() - 1, square1.getY() + 1);
        square1.setColor(Color.BLUEVIOLET);
        square2.setColor(Color.BLUEVIOLET);
        square3.setColor(Color.BLUEVIOLET);
        square4.setColor(Color.BLUEVIOLET);
    }

    @Override
    public TetrisSquare[] getSquares() {
        return squareArray;
    }

}
