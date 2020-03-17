package ludo;

import javax.management.timer.*; 

public class Game {

	private int numberOfPlayers;
	private int round;
	private int whichPlayerIsOnTurn;
	private boolean isEnd;
	private Timer timer;
	
	public Game(int numberOfPlayers, int round, int whichPlayerIsOnTurn, boolean isEnd) {
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
