package NewBaghbondi;

import NewBaghbondi.Clock;
import NewBaghbondi.Position;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.Timer;
import java.util.TimerTask;

public class TurnManager {


    int maximumTime = 100;

    private GoatTurn goatTurn;
    private TigerTurn tigerTurn;
    private Clock goatClock;
    private Clock tigerClock;
    Turn turn;


    TurnType turnType;

    TurnManager(TurnType firstTurn, Pane rootPane, Position[][] board) {
        turnType = firstTurn;
        createTurn(firstTurn);
        manageTigerClock(board);
        manageGoatClock(board);
        rootPane.getChildren().add(goatClock.getClockGroup());
        rootPane.getChildren().add(tigerClock.getClockGroup());
        startTimer();
    }

    private void manageTigerClock(Position[][] board) {
        tigerClock = new Clock(((board[1][3].getLayoutX() + board[0][4].getLayoutX()) / 2), board[2][2].getLayoutY());
        tigerClock.setTimer(50);
        tigerClock.setColor(Color.RED);
        tigerClock.drawClock();
    }

    private void manageGoatClock(Position[][] board) {
        goatClock = new Clock(board[3][3].getLayoutX(), board[2][2].getLayoutY());
        goatClock.setTimer(80);
        goatClock.setColor(Color.BLUE);
        goatClock.drawClock();

    }

    public Clock getGoatClock() {
        return goatClock;
    }

    public Clock getTigerClock() {
        return tigerClock;
    }

    void createTurn(TurnType type) {
        goatTurn = new GoatTurn(maximumTime);
        tigerTurn = new TigerTurn(maximumTime);
        turn = (type == TurnType.GOAT_TURN) ?
                goatTurn : tigerTurn;
    }

    void changeTurn() {
        turn = (turn.getType() == TurnType.TIGER_TURN) ?
                runGoatTurn() : runTigerTurn();
    }

    Turn runGoatTurn() {
        tigerClock.cancel();
        goatClock.start();
        return goatTurn;
    }

    Turn runTigerTurn() {
        goatClock.cancel();
        tigerClock.start();
        return tigerTurn;
    }


    private void startTimer() {
        //timer.schedule(task, 0, 1000);
        goatClock.start();
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

}


enum TurnType {
    TIGER_TURN, GOAT_TURN
}


