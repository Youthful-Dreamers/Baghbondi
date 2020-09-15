package NewBaghbondi;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class BoardListener {

    Position[][] board;
    Stage boardStage;
    Group pieceGroup;
    TurnManager turnManager;
    GameOverWorks gameOverWorks;
    MovementManager movementManager;

    BoardListener(Stage boardStage, Position[][] board, Group pieceGroup, Pane rootPane, int languageOption) {
        this.board = board;
        this.pieceGroup = pieceGroup;
        this.boardStage = boardStage;
        turnManager = new TurnManager(PlayerType.GOAT, rootPane, board, languageOption);
        gameOverWorks = new GameOverWorks(boardStage, board, turnManager, languageOption);
        movementManager = new MovementManager(board, pieceGroup, boardStage, turnManager, gameOverWorks);
    }

    public void addMouseReleaseOptions(Piece piece) {
        piece.setOnMouseReleased(e -> movementManager.makeMove(piece)
        );
    }

}

