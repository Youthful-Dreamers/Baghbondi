package NewBaghbondi;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.Timer;
import java.util.TimerTask;

public class Clock {
    private double layoutX = 0;
    private double layoutY = 0;
    private int timer = 0;
    private Color color = Color.BLACK;
    Task task = null;

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

    private Timer clockTimer = new Timer();
    private TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            timer--;
            setClockTime(timer);
            task.performWhenClockRuns();
        }
    };

    public void setTask(Task task) {
        this.task = task;
    }


    public void resumeTimer() {
        clockTimer.schedule(timerTask, 0, 1000);
    }

    public void pause() {
        clockTimer.cancel();
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

    public interface Task {
        void performWhenClockRuns();

    }
}
