package code;

public class MoveResult {

    private MoveType type;
    private Piece piece;

    public MoveResult(MoveType type, Piece piece) {
        this.type = type;
        this.piece=piece;
    }

    public MoveResult(MoveType type) {
        this.type = type;
        this.piece = null;
    }

    public MoveType getType() { return type; }
    public Piece getPiece() { return piece; }
}
