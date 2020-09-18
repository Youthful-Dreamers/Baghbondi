package code;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

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
    private Line goatLine;
    private Line tigerLine;
    private Pane paneOfGame;


    protected TurnManager(PlayerType firstTurn, Pane paneOfGame, Position[][] board, int languageOption) {
        this.languageOption = languageOption;
        this.playerType = firstTurn;
        this.paneOfGame = paneOfGame;
        createTurn(firstTurn);
        manageTigerClock(board);
        manageGoatClock(board);
        createLines();
        paneOfGame.getChildren().addAll(goatClock.getClockGroup());
        paneOfGame.getChildren().addAll(tigerClock.getClockGroup());
        startTimer();
    }

    private void manageTigerClock(Position[][] board) {
        tigerClock = new Clock(timer, languageOption, 1);
        tigerClock.drawClock(115,45, Color.RED);
        tigerClock.setTimer(50);
    }

    private void manageGoatClock(Position[][] board) {
        goatClock = new Clock(timer, languageOption, 2);
        goatClock.drawClock(365, 45, Color.BLUE);
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
        paneOfGame.getChildren().remove(tigerLine);
        paneOfGame.getChildren().add(goatLine);
        tigerClock.cancelTimer();
        goatClock.start();
        return goatTurn;
    }

    protected Turn runTigerTurn() {
        paneOfGame.getChildren().remove(goatLine);
        paneOfGame.getChildren().add(tigerLine);
        goatClock.cancelTimer();
        tigerClock.start();
        return tigerTurn;
    }

    protected void startTimer() {
        paneOfGame.getChildren().add(goatLine);
        goatClock.start();
    }

    public void stopTimer(){
        goatClock.cancelTimer();
        tigerClock.cancelTimer();
    }

    protected void createLines(){
        tigerLine = new Line(110, 65, 345, 65);
        tigerLine.setStroke(Color.YELLOW);
        tigerLine.setStrokeWidth(5);
        goatLine = new Line(360, 65, 605, 65);
        goatLine.setStroke(Color.YELLOW);
        goatLine.setStrokeWidth(5);
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







