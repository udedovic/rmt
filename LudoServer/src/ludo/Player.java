package ludo;

public class Player {

	private String name;
	private Color color;
	private boolean isOnTurn;
	private int playerId;
	
	
	
	public Player(String name, Color color) {
		super();
		this.name = name;
		this.color = color;
	}

	public Player(String name, Color color, boolean isOnTurn, int playerId) {
		super();
		this.name = name;
		this.color = color;
		this.isOnTurn = isOnTurn;
		this.playerId = playerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public boolean isOnTurn() {
		return isOnTurn;
	}

	public void setOnTurn(boolean isOnTurn) {
		this.isOnTurn = isOnTurn;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	
	
	
}
