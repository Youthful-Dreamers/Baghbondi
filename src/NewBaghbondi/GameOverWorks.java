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

    Stage boardStage;
    Position[][] board;

    int minimumNumberOfGoats = 1;

    private int numberOfGoat = 7;
    private TurnManager turnManager;
    int languaOption;

    GameOverWorks(Stage boardStage, Position[][] board, TurnManager turnManager, int languageOption) {
        this.boardStage = boardStage;
        this.board = board;
        this.turnManager = turnManager;
        this.languaOption= languageOption;
        onTimeUp();
    }

    private void onTimeUp() {
        Clock goatClock = turnManager.getGoatClock();
        goatClock.setTask(() -> {
            if (goatClock.getRemainingTime() <= 0) {
                setGameOverSceneAndMakeTheTigerWin(true);
            }

        });
        Clock tigerClock = turnManager.getTigerClock();
        tigerClock.setTask(() -> {
            if (tigerClock.getRemainingTime() <= 0) {
                setGameOverSceneAndMakeTheTigerWin(false);

            }
        });
    }

    private void setGameOverSceneAndMakeTheTigerWin(boolean b) {
        Platform.runLater(() -> boardStage.setScene(makeGameOverScene(b, languaOption)));
    }

    private boolean goatWinCase(Piece piece) {
        if (endTigerGame(piece)) {
            boardStage.setScene(makeGameOverScene(false, languaOption));
            return true;
        }
        return false;
    }

    public void killGoat() {
        numberOfGoat--;
    }

    private boolean tigerWinCase() {
        if (numberOfGoat < minimumNumberOfGoats) {
            boardStage.setScene(makeGameOverScene(true, languaOption));
            return true;
        }
        return false;
    }

    private boolean endTigerGame(Piece piece) {
        int i, j, horizontal, vertical, vertical0, horizontal0;
        boolean k = true, k1 = true;
        horizontal = (int) piece.getOldHorizontal() / 100;
        vertical = (int) piece.getOldVertical() / 100;

        //System.out.println(horizontal + " ,hi " + vertical);

        if (piece.getPieceTypeEnum() == PlayerType.TIGER) {
            //System.out.println("label1");

            //k=board[0][4].hasPiece() && board[4][0].hasPiece();
            //System.out.println(k);

            if ((horizontal == 2) && (vertical == 2)) {
                //System.out.println("label2");
                for (i = 0, j = 0; i < 3; i++, j += 2) {
                    //System.out.println("label3");
                    k = (board[1 + i][1].hasPiece() && board[1 + i][3].hasPiece()) && (board[j][0].hasPiece() && board[j][4].hasPiece());
                    if (!k) return k;
                }
                return k;
            }
            else if (horizontal == 2 && (vertical == 0 || vertical == 4)) {
                //System.out.println("label3");
                k = (board[0][vertical].hasPiece() && board[4][vertical].hasPiece())&& board[2][2].hasPiece();
                if (vertical == 0) k = k && board[2][1].hasPiece();
                else k = k && board[2][3].hasPiece();
                //System.out.println("label3");
                return k;
            }
            else if (horizontal == 2 && (vertical == 1 || vertical == 3)) {
                if (board[horizontal][vertical - 1].hasPiece()) System.out.println("Yes");
                k = (board[horizontal][vertical - 1].hasPiece() && board[horizontal][vertical + 1].hasPiece()) && (board[horizontal - 1][vertical].hasPiece() && board[horizontal + 1][vertical].hasPiece());
                //System.out.println("label3 hghghg");
                if (k) {
                    // System.out.println("label4");
                    if (vertical == 1) k = board[horizontal][vertical + 2].hasPiece();
                    else k = board[horizontal][vertical - 2].hasPiece();
                    return k;
                } else {// System.out.println("label2");
                    return false;
                }
            }
            else if ((horizontal == 0 || horizontal == 4) && (vertical == 0 || vertical == 4)) {
                ///  System.out.println("label2");
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

                System.out.println(k);

                if (horizontal == 4) horizontal0 = 0;
                else horizontal0 = 0;

                k = k && board[horizontal0][vertical].hasPiece();

                System.out.println("label5" + k);

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
            if (turnManager.getPlayerType() == NewBaghbondi.PlayerType.TIGER) boardStage.setScene(makeGameOverScene(false, languaOption));
            if (turnManager.getPlayerType() == NewBaghbondi.PlayerType.GOAT) boardStage.setScene(makeGameOverScene(true, languaOption));
        }
        return false;
    }

    public Scene makeGameOverScene(boolean tigerWin, int languageOption) {
        String labelOneString;
        String labelTwoString;

        labelOneString = determineLabelOneString(languageOption);
        labelTwoString = determineLabelTwoString(tigerWin, languageOption);

        Label labelOne = new Label(labelOneString);
        labelOne.setFont(new Font("Arial", 25));
        labelOne.setTextFill(Color.web("#228b22", 1.0));

        Label labelTwo = new Label(labelTwoString);
        labelTwo.setFont(new Font("Arial", 30));
        labelTwo.setTextFill(Color.web("#ff4500", 1.0));

        VBox vBox = new VBox(5);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(labelOne, labelTwo);

        return new Scene(vBox, 500, 500);
    }

    private String determineLabelOneString(int languageOption){
        String labelOneString;
        if(languageOption == 1) labelOneString = "খেলা সমাপ্ত!";
        else labelOneString = "Game Over!";
        return  labelOneString;
    }

    private String determineLabelTwoString(boolean tigerWin, int languageOption){
        String type;
        String labelTwoString;
        if (tigerWin) {
            if(languageOption == 1) type = "বাঘ";
            else type = "Tiger";
        } else {
            if(languageOption == 1) type = "ছাগল";
            else type = "Goat";
        }

        if(languageOption == 1) labelTwoString = type+" জিতেছে!!";
        else labelTwoString = type+" has own the game!!";

        return labelTwoString;
    }
}
