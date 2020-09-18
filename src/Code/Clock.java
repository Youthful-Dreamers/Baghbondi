package code;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.Timer;
import java.util.TimerTask;

public class Clock {

    private int playerIndicator;
    private int languageOption;

    private int timer;
    private Task task;
    private Timer clockTimer;
    private TimerTask timerTask;

    private Translator translator;
    private DrawClock drawClock;
    private Text clockText;


    public Clock(Timer clockTimer, int languageOption, int playerIndicator) {
        this.clockTimer = clockTimer;
        this.languageOption = languageOption;
        this.playerIndicator = playerIndicator;
        translator = new Translator();
    }

    protected void drawClock(double layoutX, double layoutY, Color clockColor){
        drawClock = new DrawClock(languageOption, playerIndicator, layoutX, layoutY, clockColor);
        this.clockText = drawClock.getClockText();
    }

    public void setClockTime(int time, int languageOption) {
        String clockTime;
        if(languageOption == 1){
            clockTime = translator.getStringInBengali(String.valueOf(time));
            if(playerIndicator == 1) clockTime = "বাঘঃ"+clockTime+"সেকেন্ড";
            else clockTime = "ছাগলঃ"+clockTime+"সেকেন্ড";
        }else{
            clockTime = String.valueOf(time);
            if(playerIndicator == 1) clockTime = "Tiger:"+clockTime+"seconds";
            else clockTime = "Goat:"+clockTime+"seconds";
        }
        clockText.setText(clockTime);
    }

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

    public void cancelTimer() {
        if(timerTask!=null) timerTask.cancel();
        clockTimer.cancel();
        clockTimer.purge();
    }

    public Group getClockGroup() {
        return drawClock.getClockGroup();
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

    public interface Task {
        void performWhenClockRuns();
    }
}
