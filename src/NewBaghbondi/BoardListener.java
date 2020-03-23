package NewBaghbondi;

import javafx.scene.Group;
import javafx.stage.Stage;

public class BoardListener{

    Position[][] board;
    Group pieceGroup;
    InGameMove inGameMove;

    BoardListener(Stage boardStage, Position[][] board, Group pieceGroup){
    this.board = board;
    this.pieceGroup = pieceGroup;

    inGameMove = new InGameMove(this.board,this.pieceGroup,boardStage);

    }



    public void addMouseReleaseOptions(Piece piece) {
        piece.setOnMouseReleased(e -> {
                  inGameMove.makeMove(piece);

                }
        );
}

}

