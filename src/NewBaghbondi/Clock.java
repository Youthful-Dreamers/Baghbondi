package NewBaghbondi;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.Timer;
import java.util.TimerTask;

public class Clock {

    private Task task = null;
    private int languageOption;
    private int timer = 0;
    private double layoutX = 0;
    private double layoutY = 0;
    private Color color = Color.BLACK;
    private Text clockText = new Text();
    private Group clockGroup = new Group();
    private int playerIndicator;

    private EnglishToBengali englishToBengali;

    public void setClockTime(int time, int languageOption) {
        String clockTime;
        if(languageOption == 1){
            clockTime = englishToBengali.getStringInBengali(String.valueOf(time));
            if(playerIndicator == 1) clockTime = "বাঘঃ"+clockTime+"সেকেন্ড";
            else clockTime = "ছাগলঃ"+clockTime+"সেকেন্ড";
        }else{
            clockTime = String.valueOf(time);
            if(playerIndicator == 1) clockTime = "Tiger"+clockTime+"seconds";
            clockTime = "Goat"+clockTime+"seconds";
        }
        clockText.setText(clockTime);
    }

    private void configClockInterface() {
        clockText.setFont(Font.font("Agency FB", FontWeight.BOLD, 28));
        clockText.setFill(color);
    }

    public void drawClock() {
        configClockInterface();
        clockText.setLayoutX(getLayoutX());
        clockText.setLayoutY(getLayoutY());

        if (languageOption == 1){
            if(playerIndicator==1) clockText.setText("বাঘঃ"+"লিমিটেড");
            else clockText.setText("ছাগলঃ"+"লিমিটেড");
        }
        else {
            if(playerIndicator==1) clockText.setText("Tiger"+"Limited");
            else clockText.setText("Goat"+"Limited");
        }

        clockGroup.getChildren().addAll(clockText);
    }

    private Timer clockTimer = new Timer();
    private TimerTask timerTask;



    public void start() {

        clockTimer = new Timer();
        timerTask = new TimerTask() {
            @Override
            public void run() {
                timer--;
                setClockTime(timer, languageOption);
                if (task != null)
                    task.performWhenClockRuns();

            }
        };
        clockTimer.schedule(timerTask, 1000, 1000);

    }

    public void cancel() {
        if(timerTask!=null)
        timerTask.cancel();
        clockTimer.cancel();
    }

    public void setColor(Color color) {
        this.color = color;
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

    public void setTask(Task task) {
        this.task = task;
    }

    public int getRemainingTime() {
        return timer;
    }

    public Clock(double layoutX, double layoutY, int languageOption, int playerIndicator) {
        this.languageOption = languageOption;
        this.playerIndicator = playerIndicator;
        englishToBengali = new EnglishToBengali();
        setLayoutX(layoutX);
        setLayoutY(layoutY);
    }

    public interface Task {
        void performWhenClockRuns();
    }
}
