package NewBaghbondi;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class TurnManager {

    int maximumTime = 100;

    private GoatTurn goatTurn;
    private TigerTurn tigerTurn;
    private Clock goatClock;
    private Clock tigerClock;
    private int languageOption;
    Turn turn;


    PlayerType playerType;

    TurnManager(PlayerType firstTurn, Pane rootPane, Position[][] board, int languageOption) {
        this.languageOption = languageOption;
        playerType = firstTurn;
        createTurn(firstTurn);
        manageTigerClock(board);
        manageGoatClock(board);
        rootPane.getChildren().add(goatClock.getClockGroup());
        rootPane.getChildren().add(tigerClock.getClockGroup());
        startTimer();
    }

    private void manageTigerClock(Position[][] board) {
        tigerClock = new Clock( 115, 45, languageOption, 1);
        tigerClock.setTimer(50);
        tigerClock.setColor(Color.WHITE);
        tigerClock.drawClock();
    }

    private void manageGoatClock(Position[][] board) {
        goatClock = new Clock(365, 45, languageOption, 2);
        goatClock.setTimer(80);
        goatClock.setColor(Color.YELLOW);
        goatClock.drawClock();

    }

    public Clock getGoatClock() {
        return goatClock;
    }

    public Clock getTigerClock() {
        return tigerClock;
    }

    void createTurn(PlayerType type) {
        goatTurn = new GoatTurn(maximumTime);
        tigerTurn = new TigerTurn(maximumTime);
        turn = (type == PlayerType.GOAT) ?
                goatTurn : tigerTurn;
    }

    void changeTurn() {
        turn = (turn.getType() == PlayerType.TIGER) ?
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
    public void stopTimer(){
        goatClock.cancel();
        tigerClock.cancel();
    }


    public PlayerType getPlayerType() {
        return turn.getType();
    }

    public boolean timerUp() {
        //  System.out.println("Timerup for " +type+" but happened to be -> "+getTurnType());
        return turn.timeUp();

    }
}

interface Turn {
    PlayerType getType();

    boolean timeUp();

}

class GoatTurn implements Turn {
    PlayerType type = PlayerType.GOAT;

    int time;

    GoatTurn(int time) {

        this.time = time;
    }

    @Override
    public boolean timeUp() {
        return (time <= 0);
    }

    @Override
    public PlayerType getType() {
        return type;
    }




}

class TigerTurn implements Turn {
    int time;

    PlayerType type = PlayerType.TIGER;

    TigerTurn(int time) {

        this.time = time;
    }

    @Override
    public boolean timeUp() {
        return (time <= 0);
    }

    @Override
    public PlayerType getType() {
        return type;
    }

}




