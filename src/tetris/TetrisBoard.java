/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import javafx.scene.layout.Pane;

/**
 * A Pane in which tetris squares can be displayed.
 * 
 * @author pipWolfe
 */
public class TetrisBoard extends Pane{
    // The size of the side of a tetris square
    public static final int SQUARE_SIZE = 20;
    // The number of squares that fit on the screen in the x and y dimensions
    public static final int X_DIM_SQUARES = 20;
    public static final int Y_DIM_SQUARES = 30;
    private TetrisSquare[][] boardSquares = new TetrisSquare[Y_DIM_SQUARES][X_DIM_SQUARES];

    /**
     * Sizes the board to hold the specified number of squares in the x and y
     * dimensions.
     */
    public TetrisBoard() {
        this.setPrefHeight(Y_DIM_SQUARES*SQUARE_SIZE);
        this.setPrefWidth(X_DIM_SQUARES*SQUARE_SIZE);
    }
    
    public TetrisSquare[][] getBoardSquares(){
        return boardSquares;
    }
     
    
}
