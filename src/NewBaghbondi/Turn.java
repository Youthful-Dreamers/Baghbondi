package NewBaghbondi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Turn{

  enum TurnType {
      PLAYER1,PLAYER2
  }
  TurnType turn;
  Turn(TurnType turn){
      this.turn = turn;
  }
  void changeTurn(){
      turn = (turn == TurnType.PLAYER1)?
              TurnType.PLAYER2 : TurnType.PLAYER1;
  }

    public TurnType getTurn() {
        return turn;
    }
}
class TurnTest{

    @Test
    void testChangeTurn(){
        Turn turn = new Turn(Turn.TurnType.PLAYER1);
        Assertions.assertEquals(Turn.TurnType.PLAYER1,turn.getTurn());
        turn.changeTurn();
        Assertions.assertEquals(Turn.TurnType.PLAYER2,turn.getTurn());
    }

}