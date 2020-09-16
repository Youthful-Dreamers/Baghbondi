package NewBaghbondi;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GameOverWorks {

    private Stage boardStage;
    private Position[][] board;
    private int minimumNumberOfGoats = 1;
    private int numberOfGoat = 7;

    private TurnManager turnManager;
    private GameOverScene gameOverScene;

    GameOverWorks(Stage boardStage, Position[][] board, TurnManager turnManager, int languageOption) {
        this.boardStage = boardStage;
        this.board = board;
        this.turnManager = turnManager;
        gameOverScene = new GameOverScene(languageOption);
        onTimeUp();
    }

    private void onTimeUp() {
        Clock goatClock = turnManager.getGoatClock();
        goatClock.setTask(() -> {
            if (goatClock.getRemainingTime() <= 0) {
                turnManager.stopTimer();
                setGameOverSceneAndMakeTheTigerWin(true);
            }
        });

        Clock tigerClock = turnManager.getTigerClock();
        tigerClock.setTask(() -> {
            if (tigerClock.getRemainingTime() <= 0) {
                turnManager.stopTimer();
                setGameOverSceneAndMakeTheTigerWin(false);
            }
        });
    }

    private void setGameOverSceneAndMakeTheTigerWin(boolean b) {
        Platform.runLater(() -> boardStage.setScene(gameOverScene.createGameOverScene(b)));
    }

    private boolean goatWinCase(Piece piece) {
        if (endTigerGame(piece)) {
            turnManager.stopTimer();
            setGameOverSceneAndMakeTheTigerWin(false);
            return true;
        }
        return false;
    }

    public void killGoat() {
        numberOfGoat--;
    }

    private boolean tigerWinCase() {
        if (numberOfGoat < minimumNumberOfGoats) {
            turnManager.stopTimer();
            boardStage.setScene(gameOverScene.createGameOverScene(true));
            return true;
        }
        return false;
    }

    private boolean endTigerGame(Piece piece) {
        int i, j, horizontal, vertical, vertical0, horizontal0;
        boolean k = true;
        horizontal = (int) piece.getOldHorizontal() / 100;
        vertical = (int) piece.getOldVertical() / 100;


        if (piece.getPieceTypeEnum() == PlayerType.TIGER) {
            if ((horizontal == 2) && (vertical == 2)) {
                for (i = 0, j = 0; i < 3; i++, j += 2) {
                    k = (board[1 + i][1].hasPiece() && board[1 + i][3].hasPiece()) && (board[j][0].hasPiece() && board[j][4].hasPiece());
                    if (!k) return k;
                }
                return k;
            }
            else if (horizontal == 2 && (vertical == 0 || vertical == 4)) {
                k = (board[0][vertical].hasPiece() && board[4][vertical].hasPiece())&& board[2][2].hasPiece();
                if (vertical == 0) k = k && board[2][1].hasPiece();
                else k = k && board[2][3].hasPiece();
                return k;
            }
            else if (horizontal == 2 && (vertical == 1 || vertical == 3)) {
                if (board[horizontal][vertical - 1].hasPiece()) System.out.println("Yes");
                k = (board[horizontal][vertical - 1].hasPiece() && board[horizontal][vertical + 1].hasPiece()) && (board[horizontal - 1][vertical].hasPiece() && board[horizontal + 1][vertical].hasPiece());
                if (k) {
                    if (vertical == 1) k = board[horizontal][vertical + 2].hasPiece();
                    else k = board[horizontal][vertical - 2].hasPiece();
                    return k;
                } else {
                    return false;
                }
            }
            else if ((horizontal == 0 || horizontal == 4) && (vertical == 0 || vertical == 4)) {
                if (horizontal == 4) {
                    horizontal0 = 3;
                } else {
                    horizontal0 = 1;
                }
                if (vertical == 4) {
                    vertical0 = 3;
                } else {
                    vertical0 = 1;
                }

                k = (board[horizontal0][vertical0].hasPiece() && board[2][vertical].hasPiece()) && board[2][2].hasPiece();
                horizontal0 = 0;
                k = k && board[horizontal0][vertical].hasPiece();
                return k;
            }
            else if ((horizontal == 1 || horizontal == 3) && (vertical == 1 || vertical == 3)) {
                if (horizontal == 1) horizontal0 = 0;
                else horizontal0 = 4;
                if (vertical == 1) vertical0 = 0;
                else vertical0 = 4;

                k = (board[horizontal0][vertical0].hasPiece() && board[2][vertical].hasPiece()) && board[2][2].hasPiece();

                if (horizontal == 3) horizontal0 = horizontal - 2;
                else horizontal0 = horizontal + 2;
                if (vertical == 3) vertical0 = vertical - 2;
                else vertical0 = vertical + 2;

                k = k && board[horizontal0][vertical].hasPiece() && board[horizontal0][vertical0].hasPiece();
                return k;
            }
        }
        return false;
    }

    public boolean gameOver(Piece piece){
        if(goatWinCase(piece)) return true;
        if(tigerWinCase()) return true;
        if (turnManager.timerUp()) {
            if (turnManager.getPlayerType() == NewBaghbondi.PlayerType.TIGER) {
                turnManager.stopTimer();
                setGameOverSceneAndMakeTheTigerWin(false);
            }
            if (turnManager.getPlayerType() == NewBaghbondi.PlayerType.GOAT) {
                turnManager.stopTimer();
                setGameOverSceneAndMakeTheTigerWin(true);
            }
        }
        return false;
    }
}
