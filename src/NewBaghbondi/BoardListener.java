package NewBaghbondi;

import javafx.scene.Group;
import javafx.stage.Stage;

public class BoardListener{

    Position[][] board;
    Group pieceGroup;
    InGameMove inGameMove;
    TurnTimer turnTimer ;
    BoardListener(Stage boardStage, Position[][] board, Group pieceGroup)
    {
        this.board = board;
        this.pieceGroup = pieceGroup;

        inGameMove = new InGameMove(this.board,this.pieceGroup,boardStage);
        turnTimer = new TurnTimer(boardStage,inGameMove.turn);
    }


    public void addMouseReleaseOptions(Piece piece) {
        piece.setOnMouseReleased(e -> {
                  inGameMove.makeMove(piece);
                }
        );
    }

}

