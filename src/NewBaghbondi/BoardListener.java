package NewBaghbondi;

import javafx.scene.Group;
import javafx.stage.Stage;

public class BoardListener {

    Position[][] board;
    Stage boardStage;
    Group pieceGroup;

    TurnManager turnManager;
    GameOverWorks gameOverWorks;
    MovementManager movementManager;

    BoardListener(Stage boardStage, Position[][] board, Group pieceGroup) {
        this.board = board;
        this.pieceGroup = pieceGroup;
        this.boardStage = boardStage;

        turnManager = new TurnManager(TurnType.GOAT_TURN);
        gameOverWorks = new GameOverWorks(boardStage, board, turnManager);
        movementManager = new MovementManager(board, pieceGroup, boardStage, turnManager, gameOverWorks);

    }


    public void addMouseReleaseOptions(Piece piece) {
        piece.setOnMouseReleased(e -> {
            movementManager.makeMove(piece);
                }
        );
    }

}

