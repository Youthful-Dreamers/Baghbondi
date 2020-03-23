package NewBaghbondi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Turn{

  enum TurnType {
      TIGER_TURN,GOAT_TURN
  }
  TurnType turn;
  Turn(TurnType firstTurn){
      turn = firstTurn;
  }
  void changeTurn(){
      turn = (turn == TurnType.TIGER_TURN)?
              TurnType.GOAT_TURN : TurnType.TIGER_TURN;
  }

    public TurnType getTurn() {
        return turn;
    }
}
class TurnTest{

    @Test
    void testChangeTurn(){
        Turn turn = new Turn(Turn.TurnType.TIGER_TURN);
        Assertions.assertEquals(Turn.TurnType.TIGER_TURN,turn.getTurn());
        turn.changeTurn();
        Assertions.assertEquals(Turn.TurnType.GOAT_TURN,turn.getTurn());
    }

}