public interface Turn {
    PlayerType getType();
    boolean timeUp();
}

class GoatTurn implements Turn {
    int time;
    PlayerType type = PlayerType.GOAT;

    GoatTurn(int time) { this.time = time; }
    public boolean timeUp() {
        return (time <= 0);
    }
    public PlayerType getType() {
        return type;
    }
}

class TigerTurn implements Turn {
    int time;
    PlayerType type = PlayerType.TIGER;

    TigerTurn(int time) { this.time = time; }
    public boolean timeUp() {
        return (time <= 0);
    }
    public PlayerType getType() {
        return type;
    }
}