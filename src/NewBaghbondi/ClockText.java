package NewBaghbondi;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class ClockText {
    private Position[][] board;
    private Pane rootPane;

    private Text tigerClock;
    private Text goatClock;
    private Group clockGroup;

    public Group getClockGroup() {
        return clockGroup;
    }

    public void setTigerClockTime(String time) {
        tigerClock.setText(time);
    }

    public void setGoatClockTime(String time) {
        goatClock.setText(time);
    }


    public ClockText(Pane drawingPane, Position[][] board) {
        this.rootPane = drawingPane;
        this.board = board;
    }

    public void drawClock() {
        clockGroup = new Group();
        drawTigerClock();
        drawGoatClock();
    }

    private void drawTigerClock() {
        tigerClock = new Text();
        tigerClock.setLayoutX(
                (board[1][3].getLayoutX() + board[0][4].getLayoutX()) / 2
        ); //offset 50px bit left
        tigerClock.setLayoutY((board[2][2].getLayoutY())); //offset 10px up
        tigerClock.setText("INFINITY");
        clockGroup.getChildren().add(tigerClock);


    }

    private void drawGoatClock() {
        goatClock = new Text();
        goatClock.setLayoutX(board[3][3].getLayoutX()); //offset 30px left
        goatClock.setLayoutY((board[2][2].getLayoutY()));  //offset 10px up
        goatClock.setText("INFINITY GOAT");
        clockGroup.getChildren().add(goatClock);

    }
}
