package NewBaghbondi;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Clock {
    private double layoutX = 0;
    private double layoutY = 0;
    private int timer;
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

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public int getRemainingTime() {
        return timer;
    }
}
