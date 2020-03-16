package ludo;

public class Game {

	private int numberOfPlayers;
	private int round;
	private int whichPlayerIsOnTurn;
	private boolean isEnd;
	
	public Game(int numberOfPlayers, int round, int whichPlayerIsOnTurn, boolean isEnd) {
		super();
		this.numberOfPlayers = numberOfPlayers;
		this.round = round;
		this.whichPlayerIsOnTurn = whichPlayerIsOnTurn;
		this.isEnd = isEnd;
	}

	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}

	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}

	public int getWhichPlayerIsOnTurn() {
		return whichPlayerIsOnTurn;
	}

	public void setWhichPlayerIsOnTurn(int whichPlayerIsOnTurn) {
		this.whichPlayerIsOnTurn = whichPlayerIsOnTurn;
	}

	public boolean isEnd() {
		return isEnd;
	}

	public void setEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}
	
	
	
	
}
