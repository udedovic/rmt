package ludo;

import java.util.ArrayList;
import java.util.List;

public class Room {
	
	public static List<Room> rooms = new ArrayList<Room>();
	
	private int roomID;
	private int numberOfPlayers;
	
	public int getRoomID() {
		return roomID;
	}

	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}

	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}

	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}
	
	Room r1 = new Room(1, 3); // obrisi ovo
	
	public Room(int roomID, int numberOfPlayers) {
		super();
		this.roomID = roomID;
		this.numberOfPlayers = numberOfPlayers;
		Room.rooms.add(this);
	}

}
