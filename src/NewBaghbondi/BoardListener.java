package NewBaghbondi;

import javafx.scene.Group;
import javafx.scene.layout.HBox;

public class BoardListener{
    int turn=0;
    Position[][] board;
    Group pieceGroup;

    BoardListener(Position[][] board, Group pieceGroup){
    this.board = board;
    this.pieceGroup = pieceGroup;
    }



    public void addMouseReleaseOptions(Piece piece) {
        piece.setOnMouseReleased(e -> {
                   if(new InGame(board,pieceGroup).makeMove(piece,turn))
                       turn=(turn+1)%2;
                }
        );
}

}

