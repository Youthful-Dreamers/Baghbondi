package NewBaghbondi;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.function.ToDoubleBiFunction;


public class ClockInterface {
    private Position[][] board;
    private Pane rootPane;

    GoatClock goatClock;
    TigerClock tigerClock;


    public void setTigerClockTime(int time) {
        tigerClock.setClockTime(time);
    }

    public void setGoatClockTime(int time) {
        goatClock.setClockTime(time);
    }


    public ClockInterface(Pane drawingPane, Position[][] board) {
        this.rootPane = drawingPane;
        this.board = board;
    }


    public void drawClock() {
        tigerClock = new TigerClock(rootPane);
        goatClock = new GoatClock(rootPane);
        tigerClock.drawClock(board);
        goatClock.drawClock(board);

    }


}

class GoatClock {

    private Pane drawingPane;

    Text clockText = new Text();

    public void setClockTime(int time) {
        clockText.setText(time + " s");
    }

    public GoatClock(Pane drawingPane) {
        this.drawingPane = drawingPane;
    }

    private void configClockInterface() {
        clockText.setFont(new Font("Agency FB", 32));
        clockText.setFill(Color.BLUE);
    }

    protected void drawClock(Position[][] board) {
        configClockInterface();
        clockText.setLayoutX(board[3][3].getLayoutX()); //offset 30px left
        clockText.setLayoutY((board[2][2].getLayoutY()));  //offset 10px up
        clockText.setText("INFINITY GOAT");
        drawingPane.getChildren().add(clockText);

    }

}

class TigerClock {
    Text clockText = new Text();
    Pane drawingPane;

    public void setClockTime(int time) {
        clockText.setText(time + " s");
    }


    TigerClock(Pane drawingPane) {
        this.drawingPane = drawingPane;
    }

    private void configClockInterface() {
        clockText.setFont(new Font("Agency FB", 32));
        clockText.setFill(Color.RED);
    }

    protected void drawClock(Position[][] board) {
        configClockInterface();
        clockText.setLayoutX(
                (board[1][3].getLayoutX() + board[0][4].getLayoutX()) / 2); //offset 50px bit left
        clockText.setLayoutY((board[2][2].getLayoutY())); //offset 10px up
        clockText.setText("INFINITY");
        drawingPane.getChildren().add(clockText);

    }

}