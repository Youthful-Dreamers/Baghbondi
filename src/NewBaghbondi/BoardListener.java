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

//    BoardListener(){};

//    private int pixelToBoard(double pixel) {
//        //System.out.println("Layout Pixel is:"+pixel);
//        return (int) pixel / (BoardStage.positionSize * 2);
//    }

    public void addMouseReleaseOptions(Piece piece) {
        piece.setOnMouseReleased(e -> {
                   if(new InGame(board,pieceGroup).makeMove(piece,turn))
                       turn=(turn+1)%2;
                }
        );
}

//    private void makeMove(Piece piece) {
//        System.out.println("-----Called makePiece() on mouse-----");
//        int newHorizontal = pixelToBoard(piece.getLayoutX());
//        int oldHorizontal = pixelToBoard(piece.getOldHorizontal());
//        int newVertical = pixelToBoard(piece.getLayoutY());
//        int oldVertical = pixelToBoard(piece.getOldVertical());
//        MoveResult result = tryMove(piece, newHorizontal, newVertical);
//        if(turn == 0){
//            if (piece.getPieceType()== PieceTypeEnum.TIGER){piece.abortMove(); return;}
//        }
//        else if(turn==1) {
//            if(!(piece.getPieceType()==PieceTypeEnum.TIGER)){piece.abortMove(); return;}
//        }
//
//
//        switch (result.getType()) {
//            case NONE:
//                piece.abortMove();
//                break;
//            case NORMAL:
//                piece.move(newHorizontal, newVertical);
//                System.out.println("Normal move from:: " + oldHorizontal + ", " + oldVertical);
//                board[oldHorizontal][oldVertical].setPiece(null);
//                board[newHorizontal][newVertical].setPiece(piece);
//                turn = (turn+1)%2;
//                break;
//            case KILL:
//                piece.move(newHorizontal, newVertical);
//                board[oldHorizontal][oldVertical].setPiece(null);
//                board[newHorizontal][newVertical].setPiece(piece);
//                Piece killedPiece = result.getPiece();
//                board[pixelToBoard(killedPiece.getOldHorizontal())][pixelToBoard(killedPiece.getOldVertical())].setPiece(null);
//                pieceGroup.getChildren().remove(killedPiece);
//                turn = (turn+1)%2;
//                break;
//
//        }
//    }


//    private MoveResult tryMove(Piece piece, int newHorizontal, int newVertical)
//    {
//
//        if (newVertical > 4 || newHorizontal > 4){
//            System.out.println("Out of board selection");
//            return new MoveResult((MoveType.NONE));}
//        if ((board[newHorizontal][newVertical] == null)) {
//            System.out.println("null Board for"+newHorizontal+", "+newVertical);
//            return new MoveResult(MoveType.NONE);
//        }
//        if (board[newHorizontal][newVertical].hasPiece()) {
//            System.out.println(endTigerGame(piece));
//            System.out.println("HAS PIECE, NO MOVE"+ newHorizontal + ", " + newVertical);
//            return new MoveResult(MoveType.NONE);
//        }
//        int oldHorizontal = pixelToBoard(piece.getOldHorizontal());
//        int oldVertical = pixelToBoard(piece.getOldVertical());
//        System.out.println("Try move to(" + newHorizontal + ", " + newVertical+") from ("+oldHorizontal+","+oldVertical+")");
//        System.out.println("New Hz - Old Hz = "+ (newHorizontal-oldHorizontal) +"\nNew Vr - Old Vr = "+ (newVertical-oldVertical));
//
//        double line = Math.sqrt((newVertical - oldVertical) * (newVertical- oldVertical) + (newHorizontal - oldHorizontal) * (newHorizontal - oldHorizontal));
//        double value = Math.sqrt(2);
//        double killValue = 2*Math.sqrt(2);
//
//        if (oldVertical == 0 || oldVertical == 4) {
//            if (oldHorizontal == 0 || oldHorizontal == 4) {
//                if (line == 2.0 || line == value) {
//                    System.out.println(endTigerGame(piece));
//                    return new MoveResult(MoveType.NORMAL);
//                }
//            }
//            else if (oldHorizontal == 2) {
//                if ((Math.abs(newHorizontal - oldHorizontal) == 2.0) || line == 1.0) {
//                    System.out.println(endTigerGame(piece));
//                    return new MoveResult(MoveType.NORMAL);
//                }
//            }
//        } else {
//            if (line == 1.0) {
//                System.out.println(endTigerGame(piece));
//                return new MoveResult(MoveType.NORMAL);
//            }
//            else if(line == value){
//                if((oldVertical==2) && (oldHorizontal==2)) {
//                    System.out.println(endTigerGame(piece));
//                    return new MoveResult(MoveType.NORMAL);
//                }
//                else if((oldVertical==1) || (oldVertical==3)) {
//                    if((oldHorizontal==1) || (oldHorizontal==3)) {
//                        if((newHorizontal==2) && (newVertical==2)) {
//                            System.out.println(endTigerGame(piece));
//                            return new MoveResult(MoveType.NORMAL);
//                        }
//                        else if(newHorizontal==0 || newHorizontal==4) {
//                            System.out.println(endTigerGame(piece));
//                            return new MoveResult(MoveType.NORMAL);
//                        }
//                    }
//                }
//            }
//        }
//
//            ///System.out.println(piece.getPieceTypeEnum());
//            if(piece.getPieceTypeEnum()== PieceTypeEnum.TIGER)
//            {
//                if(oldVertical==0||oldVertical==4)
//                {
//                    if(line==4)
//                    {
//                        int killedX = oldHorizontal + (newHorizontal - oldHorizontal) / 2;
//                        int killedY = oldVertical + (newVertical - oldVertical)/ 2;
//                        ///System.out.println("Killed");
//
//                        if (board[killedX][killedY].hasPiece())
//                        {
//                            return new MoveResult(MoveType.KILL, board[killedX][killedY].getPiece());
//                        }
//                    }
//                }
//                if (line == 2 || line == killValue)
//                {
//                    int killedX = oldHorizontal + (newHorizontal - oldHorizontal) / 2;
//                    int killedY = oldVertical + (newVertical - oldVertical)/ 2;
//                    ///System.out.println("Killed");
//
//                    if (board[killedX][killedY].hasPiece())
//                    {
//                        return new MoveResult(MoveType.KILL, board[killedX][killedY].getPiece());
//                    }
//                }
//                else { System.out.println("Goat can't kill" ); }
//            }
//        return new MoveResult(MoveType.NONE);
//    }

//    boolean endTigerGame(Piece piece)
//    {
//        int i, j, horizontal = -99, vertical = -99, vertical0, horizontal0;
//        boolean k = true, k1 = true;
//        horizontal = (int) piece.getOldHorizontal()/100;
//        vertical = (int) piece.getOldVertical()/100;
//
//        System.out.println(horizontal+" ,hi "+vertical);
//
//        if(piece.getPieceTypeEnum()==PieceTypeEnum.TIGER)
//        {
//            //System.out.println("label1");
//
//            //k=board[0][4].hasPiece() && board[4][0].hasPiece();
//            //System.out.println(k);
//
//            if ((horizontal == 2) && ( vertical == 2))
//            {
//                //System.out.println("label2");
//
//                for (i = 0, j = 0; i < 3; i++, j += 2) {
//
//                    //System.out.println("label3");
//
//                    k =(board[1 + i][1].hasPiece() && board[1 + i][3].hasPiece()) && (board[j][0].hasPiece() && board[j][4].hasPiece());
//                    if (!k) return k;
//                }
//                return k;
//            }
//            else if(horizontal==2 && (vertical==0 || vertical==4))
//            {
//                k = board[0][vertical].hasPiece() && board[4][vertical].hasPiece();
//
//                if(vertical == 0) k = k && board[2][1].hasPiece();
//                else k = k && board[2][3].hasPiece();
//
//                return k;
//
//            }
//
//            else if (horizontal == 2 && (vertical == 1 || vertical == 3))
//            {
//                if(board[horizontal][vertical - 1].hasPiece()) System.out.println("Yes");
//                k = (board[horizontal][vertical - 1].hasPiece() && board[horizontal][vertical + 1].hasPiece()) && (board[horizontal- 1][vertical].hasPiece() && board[horizontal + 1][vertical].hasPiece());
//
//                //System.out.println("label3 hghghg");
//
//                if (k) {
//
//                   // System.out.println("label4");
//
//                    if (vertical == 1) k = k && board[horizontal][vertical + 2].hasPiece();
//                    else k = k && board[horizontal][vertical - 2].hasPiece();
//
//                    return k;
//                } else {
//                   // System.out.println("label2");
//                    return false;
//                }
//            }
//
//            else if ((horizontal == 0 || horizontal == 4) && (vertical == 0 || vertical == 4))
//            {
//              ///  System.out.println("label2");
//
//                if(horizontal == 4) {horizontal0=3;}
//                else {horizontal0=1;}
//                if(vertical == 4){ vertical0=3;}
//                else {vertical0=1;}
//
//
//               /// System.out.println(board[horizontal0][vertical0].hasPiece());
//
//                k = (board[horizontal0][vertical0].hasPiece() && board[2][vertical].hasPiece()) && board[2][2].hasPiece() ;
//
//              System.out.println(k);
//
//                if(horizontal == 4) horizontal0=0;
//                else horizontal0=0;
//
//                k = k && board[horizontal0][vertical].hasPiece();
//
//               System.out.println("label5"+k);
//
//                return k;
//            }
//
//            else if((horizontal == 1 ||horizontal == 3) && (vertical==1 ||vertical== 3))
//            {
//                if(horizontal == 1) horizontal0 = 0;
//                else horizontal0=4;
//                if(vertical==1) vertical0=0;
//                else vertical0=4;
//
//                k =(board[horizontal0][vertical0].hasPiece() && board[2][vertical].hasPiece()) && board[2][2].hasPiece();
//
//                if(horizontal == 3) horizontal0 = horizontal-2;
//                else horizontal0 = horizontal + 2;
//                if(vertical == 3) vertical0 = vertical-2;
//                else vertical0 = vertical + 2;
//
//                k = k && board[horizontal0][vertical].hasPiece() && board[horizontal0][vertical0].hasPiece();
//
//                return k;
//            }
//        }
//        return false;
//    }
}

class InGame{
   // int turn=0;
    Position[][] board;
    Group pieceGroup;

    InGame(Position[][] board, Group pieceGroup){
        this.board = board;
        this.pieceGroup = pieceGroup;
    }
    public boolean makeMove(Piece piece, int turn) {
        System.out.println("-----Called makePiece() on mouse-----");
        int newHorizontal = pixelToBoard(piece.getLayoutX());
        int oldHorizontal = pixelToBoard(piece.getOldHorizontal());
        int newVertical = pixelToBoard(piece.getLayoutY());
        int oldVertical = pixelToBoard(piece.getOldVertical());
        System.out.println("Turn of :: "+turn);
        MoveResult result = tryMove(piece, newHorizontal, newVertical);
        if(turn == 0){
            if (piece.getPieceType()== PieceTypeEnum.TIGER){piece.abortMove(); return false;}
        }
        else if(turn==1) {
            if(!(piece.getPieceType()==PieceTypeEnum.TIGER)){piece.abortMove(); return false;}
        }


        switch (result.getType()) {
            case NONE:
                System.out.println("MoveResult : None ");
                piece.abortMove();
                return false;
                //break
            case NORMAL:
                System.out.println("MoveResult : Normal ");
                piece.move(newHorizontal, newVertical);
                System.out.println("Normal move from:: " + oldHorizontal + ", " + oldVertical);
                board[oldHorizontal][oldVertical].setPiece(null);
                board[newHorizontal][newVertical].setPiece(piece);
                System.out.println("Normal move: preturn "+turn);
                turn = (turn+1)%2;
                System.out.println("Normal move: turn "+turn);
                return true;
             //   break;
            case KILL:
                System.out.println("MoveResult : Kill ");
                piece.move(newHorizontal, newVertical);
                board[oldHorizontal][oldVertical].setPiece(null);
                board[newHorizontal][newVertical].setPiece(piece);
                Piece killedPiece = result.getPiece();
                board[pixelToBoard(killedPiece.getOldHorizontal())][pixelToBoard(killedPiece.getOldVertical())].setPiece(null);
                pieceGroup.getChildren().remove(killedPiece);
                turn = (turn+1)%2;
                return true;
                //break;

        }
        return false;
    }
    private int pixelToBoard(double pixel) {
        return (int) pixel / (BoardStage.positionSize * 2);
    }
    private MoveResult tryMove(Piece piece, int newHorizontal, int newVertical) {

        if (newVertical > 4 || newHorizontal > 4){
            System.out.println("Out of board selection");
            return new MoveResult((MoveType.NONE));}
        if ((board[newHorizontal][newVertical] == null)) {
            System.out.println("null Board for"+newHorizontal+", "+newVertical);
            return new MoveResult(MoveType.NONE);
        }
        if (board[newHorizontal][newVertical].hasPiece()) {
            System.out.println(endTigerGame(piece));
            System.out.println("HAS PIECE, NO MOVE"+ newHorizontal + ", " + newVertical);
            return new MoveResult(MoveType.NONE);
        }
        int oldHorizontal = pixelToBoard(piece.getOldHorizontal());
        int oldVertical = pixelToBoard(piece.getOldVertical());
        System.out.println("Try move to(" + newHorizontal + ", " + newVertical+") from ("+oldHorizontal+","+oldVertical+")");
        System.out.println("New Hz - Old Hz = "+ (newHorizontal-oldHorizontal) +"\nNew Vr - Old Vr = "+ (newVertical-oldVertical));

        double line = Math.sqrt((newVertical - oldVertical) * (newVertical- oldVertical) + (newHorizontal - oldHorizontal) * (newHorizontal - oldHorizontal));
        double value = Math.sqrt(2);
        double killValue = 2*Math.sqrt(2);

        if (oldVertical == 0 || oldVertical == 4) {
            if (oldHorizontal == 0 || oldHorizontal == 4) {
                if (line == 2.0 || line == value) {
                    System.out.println(endTigerGame(piece));
                    return new MoveResult(MoveType.NORMAL);
                }
            }
            else if (oldHorizontal == 2) {
                if ((Math.abs(newHorizontal - oldHorizontal) == 2.0) || line == 1.0) {
                    System.out.println(endTigerGame(piece));
                    return new MoveResult(MoveType.NORMAL);
                }
            }
        } else {
            if (line == 1.0) {
                System.out.println(endTigerGame(piece));
                return new MoveResult(MoveType.NORMAL);
            }
            else if(line == value){
                if((oldVertical==2) && (oldHorizontal==2)) {
                    System.out.println(endTigerGame(piece));
                    return new MoveResult(MoveType.NORMAL);
                }
                else if((oldVertical==1) || (oldVertical==3)) {
                    if((oldHorizontal==1) || (oldHorizontal==3)) {
                        if((newHorizontal==2) && (newVertical==2)) {
                            System.out.println(endTigerGame(piece));
                            return new MoveResult(MoveType.NORMAL);
                        }
                        else if(newHorizontal==0 || newHorizontal==4) {
                            System.out.println(endTigerGame(piece));
                            return new MoveResult(MoveType.NORMAL);
                        }
                    }
                }
            }
        }

        ///System.out.println(piece.getPieceTypeEnum());
        if(piece.getPieceTypeEnum()== PieceTypeEnum.TIGER)
        {
            if(oldVertical==0||oldVertical==4)
            {
                if(line==4)
                {
                    int killedX = oldHorizontal + (newHorizontal - oldHorizontal) / 2;
                    int killedY = oldVertical + (newVertical - oldVertical)/ 2;
                    ///System.out.println("Killed");

                    if (board[killedX][killedY].hasPiece())
                    {
                        return new MoveResult(MoveType.KILL, board[killedX][killedY].getPiece());
                    }
                }
            }
            if (line == 2 || line == killValue)
            {
                int killedX = oldHorizontal + (newHorizontal - oldHorizontal) / 2;
                int killedY = oldVertical + (newVertical - oldVertical)/ 2;
                ///System.out.println("Killed");

                if (board[killedX][killedY].hasPiece())
                {
                    return new MoveResult(MoveType.KILL, board[killedX][killedY].getPiece());
                }
            }
            else { System.out.println("Goat can't kill" ); }
        }
        return new MoveResult(MoveType.NONE);
    }
    boolean endTigerGame(Piece piece) {
        int i, j, horizontal = -99, vertical = -99, vertical0, horizontal0;
        boolean k = true, k1 = true;
        horizontal = (int) piece.getOldHorizontal()/100;
        vertical = (int) piece.getOldVertical()/100;

        System.out.println(horizontal+" ,hi "+vertical);

        if(piece.getPieceTypeEnum()==PieceTypeEnum.TIGER)
        {
            //System.out.println("label1");

            //k=board[0][4].hasPiece() && board[4][0].hasPiece();
            //System.out.println(k);

            if ((horizontal == 2) && ( vertical == 2))
            {
                //System.out.println("label2");

                for (i = 0, j = 0; i < 3; i++, j += 2) {

                    //System.out.println("label3");

                    k =(board[1 + i][1].hasPiece() && board[1 + i][3].hasPiece()) && (board[j][0].hasPiece() && board[j][4].hasPiece());
                    if (!k) return k;
                }
                return k;
            }
            else if(horizontal==2 && (vertical==0 || vertical==4))
            {
                k = board[0][vertical].hasPiece() && board[4][vertical].hasPiece();

                if(vertical == 0) k = k && board[2][1].hasPiece();
                else k = k && board[2][3].hasPiece();

                return k;

            }

            else if (horizontal == 2 && (vertical == 1 || vertical == 3))
            {
                if(board[horizontal][vertical - 1].hasPiece()) System.out.println("Yes");
                k = (board[horizontal][vertical - 1].hasPiece() && board[horizontal][vertical + 1].hasPiece()) && (board[horizontal- 1][vertical].hasPiece() && board[horizontal + 1][vertical].hasPiece());

                //System.out.println("label3 hghghg");

                if (k) {

                    // System.out.println("label4");

                    if (vertical == 1) k = k && board[horizontal][vertical + 2].hasPiece();
                    else k = k && board[horizontal][vertical - 2].hasPiece();

                    return k;
                } else {
                    // System.out.println("label2");
                    return false;
                }
            }

            else if ((horizontal == 0 || horizontal == 4) && (vertical == 0 || vertical == 4))
            {
                ///  System.out.println("label2");

                if(horizontal == 4) {horizontal0=3;}
                else {horizontal0=1;}
                if(vertical == 4){ vertical0=3;}
                else {vertical0=1;}


                /// System.out.println(board[horizontal0][vertical0].hasPiece());

                k = (board[horizontal0][vertical0].hasPiece() && board[2][vertical].hasPiece()) && board[2][2].hasPiece() ;

                System.out.println(k);

                if(horizontal == 4) horizontal0=0;
                else horizontal0=0;

                k = k && board[horizontal0][vertical].hasPiece();

                System.out.println("label5"+k);

                return k;
            }

            else if((horizontal == 1 ||horizontal == 3) && (vertical==1 ||vertical== 3))
            {
                if(horizontal == 1) horizontal0 = 0;
                else horizontal0=4;
                if(vertical==1) vertical0=0;
                else vertical0=4;

                k =(board[horizontal0][vertical0].hasPiece() && board[2][vertical].hasPiece()) && board[2][2].hasPiece();

                if(horizontal == 3) horizontal0 = horizontal-2;
                else horizontal0 = horizontal + 2;
                if(vertical == 3) vertical0 = vertical-2;
                else vertical0 = vertical + 2;

                k = k && board[horizontal0][vertical].hasPiece() && board[horizontal0][vertical0].hasPiece();

                return k;
            }
        }
        return false;
    }
}