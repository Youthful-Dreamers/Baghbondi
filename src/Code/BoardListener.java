package code;

import javafx.application.Platform;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class BoardListener {

    TurnManager turnManager;
    GameOverWorks gameOverWorks;
    MovementManager movementManager;
    GameBoard gameBoard;

    private Piece[] pieceArray;

    BoardListener(Stage boardStage, GameBoard gameBoard, Pane rootPane, int languageOption, GameOptionScene gameOptionScene, CreateConnection createConnection, boolean isServer, boolean lan) {
        this.gameBoard = gameBoard;
        this.pieceArray = gameBoard.getPieceArray();
        addMouseEventToPiece();
        turnManager = new TurnManager(PlayerType.GOAT, rootPane, gameBoard.getPositions(), languageOption);
        gameOverWorks = new GameOverWorks(boardStage, gameBoard.getPositions(), turnManager, languageOption, gameOptionScene, createConnection, isServer, lan);
        movementManager = new MovementManager(gameBoard.getPositions(), gameBoard.getPieceGroup(), turnManager, gameOverWorks);
        Platform.runLater(()->boardStage.setOnCloseRequest(e -> {
            turnManager.stopTimer();
            try {
                if (isServer) createConnection.getServerConnection().closeConnection();
                else createConnection.getClientConnection().closeConnection();
            }catch (Exception ex){
                System.out.println("Error in closing connection: "+e);
            }
        }));
    }

    private void addMouseEventToPiece(){
        for(int i=0; i<gameBoard.getPieceCount(); i++){
            addMouseReleaseOptions(pieceArray[i]);
        }
    }

    public void addMouseReleaseOptions(Piece piece) {
        piece.setOnMouseReleased(e -> movementManager.makeMove(piece));
    }
}

