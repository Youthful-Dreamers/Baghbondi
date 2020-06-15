package NewBaghbondi;

import javafx.scene.layout.Pane;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Timer;
import java.util.TimerTask;

public class TurnManager {


    int maximumTime = 100;

    private GoatTurn goatTurn;
    private TigerTurn tigerTurn;
    Turn turn;
    ClockInterface clock;


    TurnType turnType;

    TurnManager(TurnType firstTurn, Pane rootPane, Position[][] board) {
        turnType = firstTurn;
        createTurn(firstTurn);
        clock = new ClockInterface(rootPane, board);
        clock.drawClock();
        startTimer();
    }

    void createTurn(TurnType type) {
        goatTurn = new GoatTurn(maximumTime);
        tigerTurn = new TigerTurn(maximumTime);
        turn = (type == TurnType.GOAT_TURN)?
                goatTurn : tigerTurn;
    }

    void changeTurn() {

        turn = (turn.getType() == TurnType.TIGER_TURN) ?
                goatTurn : tigerTurn;
    }

    Timer timer = new Timer();
    TimerTask task = new TimerTask() {


        @Override
        public void run() {
            turn.decreaseTime();
          //  System.out.println("TigerTime: " + tigerTurn.time + "  || GoatTime: " + goatTurn.time);
            clock.setGoatClockTime(goatTurn.time);
            clock.setTigerClockTime(tigerTurn.time);
            if (turn.timeUp()) cancel();

        }

    };

    private void startTimer() {
        timer.schedule(task, 0, 1000);
    }

    public TurnType getTurnType() {
        return turn.getType();
    }

    public boolean timerUp() {
      //  System.out.println("Timerup for " +type+" but happened to be -> "+getTurnType());
        return turn.timeUp();

    }
}

interface Turn {
    TurnType getType();

    boolean timeUp();

    void decreaseTime();
}

class GoatTurn implements Turn {
    TurnType type = TurnType.GOAT_TURN;
    int time;

    GoatTurn(int time) {

        this.time = time;
    }

    @Override
    public boolean timeUp() {
        return (time <= 0);
    }

    @Override
    public TurnType getType() {
        return type;
    }

    @Override
    public void decreaseTime() {
        time--;

    }


}

class TigerTurn implements Turn {
    int time;

    TurnType type = TurnType.TIGER_TURN;

    TigerTurn(int time) {

        this.time = time;
    }

    @Override
    public boolean timeUp() {
        return (time <= 0);
    }

    @Override
    public TurnType getType() {
        return type;
    }
    @Override
    public void decreaseTime() {
        time--;

    }
}


enum TurnType {
    TIGER_TURN, GOAT_TURN
}


