/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

/**
 * This should be implemented to include your game control.
 *
 * @author pipWolfe
 */
public class TetrisGame {

    private TetrisPiece currPiece;
    private final Tetris tetrisApp;
    private final TetrisBoard board;
    private TetrisSquare[] pieceArr;
    private Point2D[] checkArray = new Point2D[4];
    private TetrisSquare[][] boardSquares;

    /**
     * Initialize the game. Remove the example code and replace with code that
     * creates a random piece.
     *
     * @param tetrisApp A reference to the application (use to set messages).
     * @param board A reference to the board on which Squares are drawn
     */
    public TetrisGame(Tetris tetrisApp, TetrisBoard board) {
        this.board = board;
//        currPiece = new TetrisRandom(board, 9, 0);
        currPiece = new TetrisI(board, 9, 0);
        pieceArr = currPiece.getSquares();
        this.tetrisApp = tetrisApp;
        // You can use this to show the score, etc.
        tetrisApp.setMessage("Game has started!");
        boardSquares = this.board.getBoardSquares();
    }

    /**
     * Animate the game, by moving the current tetris piece down.
     */
    void update() {
        System.out.println("updating");
        this.down();
        for (int i = 0; i < checkArray.length; i++) {
            if (checkArray[i].getY() >= TetrisBoard.Y_DIM_SQUARES || boardSquares[(int) checkArray[i].getY()][(int) checkArray[i].getX()] != null) {
                for (int k = 0; k < pieceArr.length; k++) {
                    boardSquares[pieceArr[k].getY()][pieceArr[k].getX()] = pieceArr[k];
                }
                

                
                board.getChildren().clear();
                for (int y = 0; y < boardSquares.length; y++) {
                    for (int x = 0; x < boardSquares[y].length; x++) {
                        if (boardSquares[y][x] != null) {
                            board.getChildren().add(boardSquares[y][x].getShape());
                        }

                    }

                }
//                currPiece = new TetrisRandom(board, 9, 0);
                currPiece = new TetrisI(board, 9, 0);
                pieceArr = currPiece.getSquares();
                break;
            }
        }

    }

    /**
     * Move the current tetris piece left.
     */
    void left() {
        System.out.println("left key was pressed!");
        for (int i = 0; i < currPiece.getSquares().length; i++) {
            checkArray[i] = pieceArr[i].getSquareLoc().add(-1, 0);
        }
        if (checkSquares(checkArray)) {
            commitNewLocation(currPiece);
        }
    }

    /**
     * Move the current tetris piece right.
     */
    void right() {
        System.out.println("right key was pressed!");
        for (int i = 0; i < currPiece.getSquares().length; i++) {
            checkArray[i] = pieceArr[i].getSquareLoc().add(1, 0);
        }
        if (checkSquares(checkArray)) {
            commitNewLocation(currPiece);
        }
    }

    /**
     * Move the current tetris piece down one square
     */
    void down() {
        for (int i = 0; i < currPiece.getSquares().length; i++) {
            checkArray[i] = pieceArr[i].getSquareLoc().add(0, 1);
        }
        if (checkSquares(checkArray)) {
            commitNewLocation(currPiece);
        }
    }

    /**
     * Drop the current tetris piece.
     */
    void drop() {
        System.out.println("drop key was pressed!");
        for (int i = 0; i < currPiece.getSquares().length; i++) {
            checkArray[i] = pieceArr[i].getSquareLoc().add(0, 2);
        }
        if (checkSquares(checkArray)) {
            commitNewLocation(currPiece);
        }
    }

    /**
     * Rotate the current piece counter-clockwise.
     */
    void rotateLeft() {
        System.out.println("rotate left key was pressed!");
        for (int i = 0; i < currPiece.getSquares().length; i++) {
            int oldRelativeX = pieceArr[0].getX() - pieceArr[i].getX();
            int oldRelativeY = pieceArr[0].getY() - pieceArr[i].getY();
            int newRelativeX = -oldRelativeY;
            int newRelativeY = oldRelativeX;
            checkArray[i] = pieceArr[0].getSquareLoc().add(newRelativeX, newRelativeY);
        }
        if (checkSquares(checkArray)) {
            commitNewLocation(currPiece);
        }

    }

    /**
     * Rotate the current piece clockwise.
     */
    void rotateRight() {
        System.out.println("rotate right key was pressed!");
        for (int i = 0; i < currPiece.getSquares().length; i++) {
            int oldRelativeX = pieceArr[0].getX() - pieceArr[i].getX();
            int oldRelativeY = pieceArr[0].getY() - pieceArr[i].getY();
            int newRelativeX = oldRelativeY;
            int newRelativeY = -oldRelativeX;
            checkArray[i] = pieceArr[0].getSquareLoc().add(newRelativeX, newRelativeY);
        }
        if (checkSquares(checkArray)) {
            commitNewLocation(currPiece);
        }

    }

    /**
     * Checks if squares will move outside of the boundaries or into space
     * occupied by other squares
     */
    boolean checkSquares(Point2D[] checkArray
    ) {
        for (int i = 0; i < checkArray.length; i++) {
            if (checkArray[i].getX() < 0 || checkArray[i].getX() >= TetrisBoard.X_DIM_SQUARES
                    || checkArray[i].getY() >= TetrisBoard.Y_DIM_SQUARES
                    || boardSquares[(int) checkArray[i].getY()][(int) checkArray[i].getX()] != null) {

                return false;
            }
        }
        return true;
    }

    /**
     * Commits squares to new locations
     */
    void commitNewLocation(TetrisPiece currPiece
    ) {
        for (int i = 0; i < currPiece.getSquares().length; i++) {
            pieceArr[i].moveToTetrisLocation((int) checkArray[i].getX(), (int) checkArray[i].getY());
        }
    }

}
