package NewBaghbondi;

import javafx.scene.Group;
import javafx.stage.Stage;


public class MovementManager {

    TurnManager turnManager;
    Position[][] board;
    Group pieceGroup;
    Stage boardStage;
    GameOverWorks gameOverWorks;


    MovementManager(Position[][] board,
                    Group pieceGroup,
                    Stage boardStage,
                    TurnManager turnManager,
                    GameOverWorks gameOverWorks) {
        this.board = board;
        this.pieceGroup = pieceGroup;
        this.boardStage = boardStage;
        this.gameOverWorks = gameOverWorks;
        this.turnManager = turnManager;
    }

    public boolean makeMove(Piece piece) {
        System.out.println("-----Called makePiece() on mouse-----");
        int newHorizontal = pixelToBoard(piece.getLayoutX());
        int oldHorizontal = pixelToBoard(piece.getOldHorizontal());
        int newVertical = pixelToBoard(piece.getLayoutY());
        int oldVertical = pixelToBoard(piece.getOldVertical());
        System.out.println("Turn of :: " + turnManager.getPlayerType());
        MoveResult result = tryMove(piece, newHorizontal, newVertical);

        if(turnManager.getPlayerType() != piece.getPieceType()){
            piece.abortMove();
            System.out.println(1);
            return false;
        }


        boolean movementMade = false;

        switch (result.getType()) {
            case NONE:
                System.out.println("MoveResult : None ");
                piece.abortMove();
                break;

            case NORMAL:
                System.out.println("MoveResult : Normal ");
                piece.move(newHorizontal, newVertical);
                System.out.println("Normal move from:: " + oldHorizontal + ", " + oldVertical);
                board[oldHorizontal][oldVertical].setPiece(null);
                board[newHorizontal][newVertical].setPiece(piece);
                System.out.println("Normal move: preturn " + turnManager.getPlayerType());
                turnManager.changeTurn();

                System.out.println("Normal move: turn " + turnManager.getPlayerType());
                movementMade = true;

                break;
            case KILL:
                System.out.println("MoveResult : Kill ");
                piece.move(newHorizontal, newVertical);
                board[oldHorizontal][oldVertical].setPiece(null);
                board[newHorizontal][newVertical].setPiece(piece);
                Piece killedPiece = result.getPiece();
                board[pixelToBoard(killedPiece.getOldHorizontal())][pixelToBoard(killedPiece.getOldVertical())].setPiece(null);
                pieceGroup.getChildren().remove(killedPiece);
                turnManager.changeTurn();
                gameOverWorks.killGoat();
                movementMade = true;
                break;

        }

        if (gameOverWorks.gameOver(piece)) return false;
        return movementMade;
    }

    private int pixelToBoard(double pixel) {
        return (int) pixel / (StageCreator.positionSize * 2);
    }

    private MoveResult tryMove(Piece piece, int newHorizontal, int newVertical) {

        if (newVertical > 4 || newHorizontal > 4) {
            System.out.println("Out of board selection");
            return new MoveResult((MoveType.NONE));
        }
        if ((board[newHorizontal][newVertical] == null)) {
            System.out.println("null Board for" + newHorizontal + ", " + newVertical);
            return new MoveResult(MoveType.NONE);
        }
        if (board[newHorizontal][newVertical].hasPiece()) {
            // System.out.println(endTigerGame(piece));

            System.out.println("HAS PIECE, NO MOVE" + newHorizontal + ", " + newVertical);
            return new MoveResult(MoveType.NONE);
        }
        int oldHorizontal = pixelToBoard(piece.getOldHorizontal());
        int oldVertical = pixelToBoard(piece.getOldVertical());
        System.out.println("Try move to(" + newHorizontal + ", " + newVertical + ") from (" + oldHorizontal + "," + oldVertical + ")");
        System.out.println("New Hz - Old Hz = " + (newHorizontal - oldHorizontal) + "\nNew Vr - Old Vr = " + (newVertical - oldVertical));

        double line = Math.sqrt((newVertical - oldVertical) * (newVertical - oldVertical) + (newHorizontal - oldHorizontal) * (newHorizontal - oldHorizontal));
        double value = Math.sqrt(2);
        double killValue = 2 * Math.sqrt(2);

        if (oldVertical == 0 || oldVertical == 4) {
            if (oldHorizontal == 0 || oldHorizontal == 4) {
                if (line == 2.0 || line == value) {
                    return new MoveResult(MoveType.NORMAL);
                }
            } else if (oldHorizontal == 2) {
                if ((Math.abs(newHorizontal - oldHorizontal) == 2.0) || line == 1.0) {
                    return new MoveResult(MoveType.NORMAL);
                }
            }
        } else {
            if (line == 1.0) {
                return new MoveResult(MoveType.NORMAL);
            } else if (line == value) {
                if ((oldVertical == 2) && (oldHorizontal == 2)) {
                    return new MoveResult(MoveType.NORMAL);
                } else if ((oldVertical == 1) || (oldVertical == 3)) {
                    if ((oldHorizontal == 1) || (oldHorizontal == 3)) {
                        if ((newHorizontal == 2) && (newVertical == 2)) {
                            return new MoveResult(MoveType.NORMAL);
                        } else if (newHorizontal == 0 || newHorizontal == 4) {
                            return new MoveResult(MoveType.NORMAL);
                        }
                    }
                }
            }
        }

        if (piece.getPieceTypeEnum() == PlayerType.TIGER) {
            if (oldVertical == 0 || oldVertical == 4) {
                if (line == 4) {
                    int killedX = oldHorizontal + (newHorizontal - oldHorizontal) / 2;
                    int killedY = oldVertical + (newVertical - oldVertical) / 2;

                    if (board[killedX][killedY].hasPiece()) {
                        return new MoveResult(MoveType.KILL, board[killedX][killedY].getPiece());
                    }
                }
            }
            if (line == 2 || line == killValue) {
                int killedX = oldHorizontal + (newHorizontal - oldHorizontal) / 2;
                int killedY = oldVertical + (newVertical - oldVertical) / 2;
                if (board[killedX][killedY].hasPiece()) {
                    return new MoveResult(MoveType.KILL, board[killedX][killedY].getPiece());
                }
            } else {
                System.out.println("Goat can't kill");
            }
        }
        return new MoveResult(MoveType.NONE);
    }


}

