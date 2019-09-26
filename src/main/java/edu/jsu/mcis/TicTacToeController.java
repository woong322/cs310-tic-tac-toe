package edu.jsu.mcis;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class TicTacToeController implements ActionListener {

    private final TicTacToeModel model;
    private final TicTacToeView view;
    private int width;
    
    /* CONSTRUCTOR */

    public TicTacToeController(int width) {
        
        /* Initialize model, view, and width */
        this.width = width;    
        model = new TicTacToeModel(width);
        view = new TicTacToeView();
        
    }

    public String getMarkAsString(int row, int col) {        
        return (model.getMark(row, col).toString());        
    }
    
    public TicTacToeView getView() {        
        return view;        
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        // INSERT YOUR CODE HERE
        if(event.getSource() instanceof JButton) {
            JButton button = (JButton) event.getSource();
            String name = button.getName();
            int row = Integer.parseInt(name.substring(6,7));
            int col = Integer.parseInt(name.substring(7));

            if(model.makeMark(row, col)) {

                if(model.getResult() == model.Result.X) {
                    view.showResult("X");
                    view.disableSquares();
                }

                else if(model.getResult() == model.Result.O) {
                    view.showResult("O");
                    view.disableSquares();
                }
                else if(model.getResult() == model.Result.TIE) {
                    view.showResult("TIE");
                    view.disableSquares();
                }
                else{
                    view.clearResult();
                }
            }
        }
    }

    public int getWidth() {
        return width;
    }

}
