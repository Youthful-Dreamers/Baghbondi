package code;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class BoardListener {

    TurnManager turnManager;
    GameOverWorks gameOverWorks;
    MovementManager movementManager;
    GameBoard gameBoard;

    private Piece[] pieceArray;

    BoardListener(Stage boardStage, GameBoard gameBoard, Pane rootPane, int languageOption, GameOptionScene gameOptionScene, ChatClient chatClient, ChatServer chatServer) {
        this.gameBoard = gameBoard;
        this.pieceArray = gameBoard.getPieceArray();
        addMouseEventToPiece();
        turnManager = new TurnManager(PlayerType.GOAT, rootPane, gameBoard.getPositions(), languageOption);
        gameOverWorks = new GameOverWorks(boardStage, gameBoard.getPositions(), turnManager, languageOption, gameOptionScene, chatClient, chatServer);
        movementManager = new MovementManager(gameBoard.getPositions(), gameBoard.getPieceGroup(), turnManager, gameOverWorks);
        boardStage.setOnCloseRequest(e -> {
            turnManager.stopTimer();
            closeChatClientAndServer(chatClient, chatServer);
        });
    }

    private void closeChatClientAndServer(ChatClient chatClient, ChatServer chatServer){
        if(chatClient!= null) {
            try {
                chatClient.closeChatClient();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        if(chatServer!=null) {
            try {
                chatServer.closeServer();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
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

