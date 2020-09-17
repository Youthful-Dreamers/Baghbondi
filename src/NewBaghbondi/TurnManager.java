package NewBaghbondi;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.Timer;

public class TurnManager {

    int maximumTime = 100;

    private GoatTurn goatTurn;
    private TigerTurn tigerTurn;
    private Clock goatClock;
    private Clock tigerClock;
    private int languageOption;
    private Turn turn;
    protected PlayerType playerType;
    protected Timer timer = new Timer();

    protected TurnManager(PlayerType firstTurn, Pane rootPane, Position[][] board, int languageOption) {
        this.languageOption = languageOption;
        this.playerType = firstTurn;
        createTurn(firstTurn);
        manageTigerClock(board);
        manageGoatClock(board);
        rootPane.getChildren().add(goatClock.getClockGroup());
        rootPane.getChildren().add(tigerClock.getClockGroup());
        startTimer();
    }

    private void manageTigerClock(Position[][] board) {
        tigerClock = new Clock(timer, languageOption, 1);
        tigerClock.drawClock(115,45, Color.WHITE);
        tigerClock.setTimer(50);
    }

    private void manageGoatClock(Position[][] board) {
        goatClock = new Clock(timer, languageOption, 2);
        goatClock.drawClock(365, 45, Color.YELLOW);
        goatClock.setTimer(80);
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

    protected Turn runGoatTurn() {
        tigerClock.cancelTimer();
        goatClock.start();
        return goatTurn;
    }

    protected Turn runTigerTurn() {
        goatClock.cancelTimer();
        tigerClock.start();
        return tigerTurn;
    }

    protected void startTimer() {
        goatClock.start();
    }

    public void stopTimer(){
        goatClock.cancelTimer();
        tigerClock.cancelTimer();
    }

    public PlayerType getPlayerType() {
        return turn.getType();
    }
    public boolean timerUp() {
        return turn.timeUp();
    }

    public Clock getGoatClock() {
        return goatClock;
    }
    public Clock getTigerClock() {
        return tigerClock;
    }
}







