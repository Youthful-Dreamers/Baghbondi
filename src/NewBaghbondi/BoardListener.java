package NewBaghbondi;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class BoardListener {

    TurnManager turnManager;
    GameOverWorks gameOverWorks;
    MovementManager movementManager;
    Group pieceGroup;

    BoardListener(Stage boardStage, Position[][] board, Group pieceGroup, Pane rootPane, int languageOption) {
        this.pieceGroup = pieceGroup;
        turnManager = new TurnManager(PlayerType.GOAT, rootPane, board, languageOption);
        gameOverWorks = new GameOverWorks(boardStage, board, turnManager, languageOption);
        movementManager = new MovementManager(board, pieceGroup, boardStage, turnManager, gameOverWorks);
    }

    public void addMouseReleaseOptions(Piece piece) {
        piece.setOnMouseReleased(e -> movementManager.makeMove(piece));
    }
}

