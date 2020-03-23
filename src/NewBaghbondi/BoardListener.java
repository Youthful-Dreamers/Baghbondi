package NewBaghbondi;

import javafx.scene.Group;

public class BoardListener{

    Position[][] board;
    Group pieceGroup;
    InGameMove inGameMove;
    BoardListener(Position[][] board, Group pieceGroup){
    this.board = board;
    this.pieceGroup = pieceGroup;
    inGameMove = new InGameMove(this.board,this.pieceGroup);
    }



    public void addMouseReleaseOptions(Piece piece) {
        piece.setOnMouseReleased(e -> {
                  inGameMove.makeMove(piece);

                }
        );
}

}

