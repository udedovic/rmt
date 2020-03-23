package ludoClient;

import javax.management.timer.Timer;

public class Game {
	
	private int room;
	private int round;
	private int numberOfPlayers;
	private int whichPlayerIsOnTurn;
	private boolean isEnd;
	private Timer timer;
	
	private int player1 = 1;
	private int player2 = 2;
	private int player3 = 3;
	private int player4 = 4;
	
	static Game game;
	
	public static void start(){
		Game g = new Game(Integer.parseInt(LudoStart.textRoom.getText()));
		game = g;
	}
	
	
	public Game(int room) {
		super();
		this.room = room;
	}

	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
	}

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}

	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}

	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
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

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}

}
