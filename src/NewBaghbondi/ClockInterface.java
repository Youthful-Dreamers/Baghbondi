package NewBaghbondi;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ClockInterface {
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


    public ClockInterface(Pane drawingPane, Position[][] board) {
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

class Clock {
    private double layoutX = 0;
    private double layoutY = 0;
    private Color color = Color.BLACK;

    private Group clockGroup = new Group();

    Text clockText = new Text();


    public void setClockTime(int time) {
        clockText.setText(time + " s");
    }



    private void configClockInterface() {
        clockText.setFont(new Font("Agency FB", 32));
        clockText.setFill(color);
    }

    protected void drawClock() {
        configClockInterface();

        clockText.setLayoutX(getLayoutX());
        clockText.setLayoutY(getLayoutY());

        clockText.setText("LIMITED");
        clockGroup.getChildren().add(clockText);

    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setLayoutX(double layoutX) {
        this.layoutX = layoutX;
    }

    public void setLayoutY(double layoutY) {
        this.layoutY = layoutY;
    }

    public double getLayoutX() {
        return layoutX;
    }

    public double getLayoutY() {
        return layoutY;
    }

    public Group getClockGroup() {
        return clockGroup;
    }
}


