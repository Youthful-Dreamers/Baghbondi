package NewBaghbondi;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Timer;
import java.util.TimerTask;

public class TurnTimer {
    Turn turn;
    Stage boardStage;
    int maximumTime = 10;
    GameOverWorks gameOverWorks;

    TurnTimer(Stage boardStage, Turn turn,GameOverWorks gameOverWorks) {
        this.boardStage = boardStage;
        this.turn = turn;
        gameOverWorks.tigerTime = maximumTime;
        gameOverWorks.goatTime = maximumTime;
        this.gameOverWorks = gameOverWorks;

        startTimer();

    }

    Timer timer = new Timer();
    TimerTask task = new TimerTask() {


        @Override
        public void run() {
            if (turn.getTurn() == Turn.TurnType.GOAT_TURN) {
                gameOverWorks.goatTime--;
            }
            else if (turn.getTurn() == Turn.TurnType.TIGER_TURN) gameOverWorks.tigerTime--;

            System.out.println("TigerTime: "+gameOverWorks.tigerTime+"|| GoatTime: "+gameOverWorks.goatTime);
            if (gameOverWorks.goatTime == 0) {
               //boardStage.setScene(gameOverScene(true));
               cancel();
            } else if (gameOverWorks.tigerTime == 0) {
               cancel();
            }
        }
        private Scene gameOverScene(boolean tigerWin) {
            Label label = new Label("Game Over!");
            label.setFont(new Font("Arial", 25));
            label.setTextFill(Color.web("#228b22", 1.0));

            String type;

            if (tigerWin) {
                type = "Tiger";
            } else {
                type = "Goat";
            }

            Label label2 = new Label(type + " has won the game!!");
            label2.setFont(new Font("Arial", 30));
            label2.setTextFill(Color.web("#ff4500", 1.0));

            VBox vBox = new VBox(5);

            vBox.setAlignment(Pos.CENTER);

            vBox.getChildren().addAll(label, label2);

            Scene scene = new Scene(vBox, 500, 500);

            return scene;
        }
    };

    public void startTimer(){
        timer.schedule(task,0,1000);
    }
}



