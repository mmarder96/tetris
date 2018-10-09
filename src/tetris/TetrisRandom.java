package tetris;

import java.util.ArrayList;

/**
 * Creates a Random Piece
 *
 * @author Max
 */
/**
 * Creates a random Tetris piece
 * 
 */
public class TetrisRandom extends TetrisPiece {

    TetrisSquare[] squareArray = new TetrisSquare[4];

    public TetrisRandom(TetrisBoard board, int XLoc, int YLoc) {
        ArrayList<TetrisPiece> pieceList = new ArrayList<TetrisPiece>();
        int i = (int) ((Math.random() * 6)+1);

        switch (i) {
            case 1:
                TetrisI IPiece = new TetrisI(board, XLoc, YLoc);
                squareArray = IPiece.getSquares();
                break;
            case 2:
                TetrisJ JPiece = new TetrisJ(board, XLoc, YLoc);
                squareArray = JPiece.getSquares();
                break;
            case 3:
                TetrisL LPiece = new TetrisL(board, XLoc, YLoc);
                squareArray = LPiece.getSquares();
                break;
            case 4:
                TetrisO OPiece = new TetrisO(board, XLoc, YLoc);
                squareArray = OPiece.getSquares();
                break;
            case 5:
                TetrisS SPiece = new TetrisS(board, XLoc, YLoc);
                squareArray = SPiece.getSquares();
                break;
            case 6:
                TetrisT TPiece = new TetrisT(board, XLoc, YLoc);
                squareArray = TPiece.getSquares();
                break;
            case 7:
                TetrisZ ZPiece = new TetrisZ(board, XLoc, YLoc);
                squareArray = ZPiece.getSquares();
                break;
            default:
                System.out.println("Something Happened!");

        }
    }

    @Override
    public TetrisSquare[] getSquares() {
        return squareArray;
    }
}

