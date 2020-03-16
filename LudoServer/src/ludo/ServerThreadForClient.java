package ludo;

import java.io.IOException;

public interface ServerThreadForClient {

	public void throwDice() throws IOException;
	public void getOutOfHouse(Pawn pawn);
	public void movePawn(Pawn pawn, int index);
	public void eatPawn(Pawn pawn);
	
	
}
