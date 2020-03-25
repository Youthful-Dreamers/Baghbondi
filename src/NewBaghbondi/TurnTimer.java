package NewBaghbondi;


import javafx.stage.Stage;

import java.util.Timer;
import java.util.TimerTask;

public class TurnTimer {
    Turn turn;
    Stage boardStage;
    int maximumTime = 5;

    TurnTimer(Stage boardStage, Turn turn) {
        this.boardStage = boardStage;
        this.turn = turn;
        startTimer();
    }

    Timer timer = new Timer();
    TimerTask task = new TimerTask() {
        int goatTime = maximumTime;
        int tigerTime = maximumTime;

        @Override
        public void run() {
            if (turn.getTurn() == Turn.TurnType.GOAT_TURN) {
                goatTime--;

                System.out.println("Goat Timer says "+goatTime);
            }
            else if (turn.getTurn() == Turn.TurnType.TIGER_TURN) tigerTime--;
            if (goatTime == 1) {
            //    boardStage.setScene(new GameOverWorks(boardStage).gameOverScene(true));
               // task.cancel();
            } else if (tigerTime == 1) {
             //  boardStage.setScene(new GameOverWorks(boardStage).gameOverScene(false));
              //  task.cancel();
            }
        }
    };

    public void startTimer(){
        timer.schedule(task,0,1000);
    }
}



