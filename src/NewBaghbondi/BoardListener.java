package NewBaghbondi;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class BoardListener {

    TurnManager turnManager;
    GameOverWorks gameOverWorks;
    MovementManager movementManager;
    GameBoard gameBoard;

    private Piece[] pieceArray;

    BoardListener(Stage boardStage, GameBoard gameBoard, Pane rootPane, int languageOption) {
        this.gameBoard = gameBoard;
        this.pieceArray = gameBoard.getPieceArray();
        addMouseEventToPiece();
        turnManager = new TurnManager(PlayerType.GOAT, rootPane, gameBoard.getPositions(), languageOption);
        gameOverWorks = new GameOverWorks(boardStage, gameBoard.getPositions(), turnManager, languageOption);
        movementManager = new MovementManager(gameBoard.getPositions(), gameBoard.getPieceGroup(), turnManager, gameOverWorks);
        boardStage.setOnCloseRequest(e -> turnManager.stopTimer());
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

