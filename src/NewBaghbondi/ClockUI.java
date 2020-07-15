package NewBaghbondi;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ClockUI {
    private Position[][] board;
    private Pane rootPane;

    Clock goatClock;
    Clock tigerClock;


    public void setTigerClockTime(int time) {
        tigerClock.setClockTime(time);
    }

    public void setGoatClockTime(int time) {
        goatClock.setClockTime(time);
    }


    public ClockUI(Pane drawingPane, Position[][] board) {
        this.rootPane = drawingPane;
        this.board = board;
    }


    public void drawClock() {
        tigerClock = new Clock();
        tigerClock.setLayoutX(((board[1][3].getLayoutX() + board[0][4].getLayoutX()) / 2));
        tigerClock.setLayoutY(board[2][2].getLayoutY());
        tigerClock.setColor(Color.RED);
        rootPane.getChildren().add(tigerClock.getClockGroup());
        goatClock = new Clock();
        goatClock.setLayoutX(board[3][3].getLayoutX());
        goatClock.setLayoutY((board[2][2].getLayoutY()));
        goatClock.setColor(Color.BLUE);
        tigerClock.drawClock();
        goatClock.drawClock();
        rootPane.getChildren().add(goatClock.getClockGroup());

    }

}


