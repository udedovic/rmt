package ludo;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ServerThreadForClientImpl extends Thread implements ServerThreadForClient{

	private Socket socket;
	private DataOutputStream dataOut;
	private DataInputStream dataIn;
	private static PrintStream textOut;
	private static BufferedReader textIn;
	private byte[] buffer = new byte[4096];
	private int counter = 0;
	private int round = 1;
	private Player player;
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	private int receivedCode = 0;
	private int sendingCode = 1; // 1 OK 
	
	public ServerThreadForClientImpl(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void throwDice() throws IOException {
		int numberOnDice = (int)(Math.random()*6 + 1);
		dataOut.writeInt(numberOnDice);
		
		endOfComand();
	}

	@Override
	public void getOutOfHouse(Pawn pawn) {
		
		
		
	}

	@Override
	public void movePawn(Pawn pawn, int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eatPawn(Pawn pawn) {
		// TODO Auto-generated method stub
		
	}
	
	public void serverExecutes() throws IOException {
		while(dataIn.available() == 0) {
			
		}
		receivedCode = dataIn.readInt();
		
		switch(receivedCode) {
		case 0:
			return;
		case Command.THROW_DICE:
			throwDice();
			break;
		case Command.PLAYER_IS_READY:
			playerIsReady();
			break;
		default:
			receivedCode = 0;
			break;
		}
	}


	private void playerIsReady() throws IOException {
		String name = textIn.readLine();
		String stringColor = textIn.readLine();
		Color color;
		
		if(stringColor.equalsIgnoreCase("red"))
			color = Color.RED;
		else if(stringColor.equalsIgnoreCase("blue"))
			color = Color.BLUE;
		else if(stringColor.equalsIgnoreCase("green"))
			color = Color.GREEN;
		else color = Color.YELLOW;
		
		player = new Player(name, color, false, Server.getGame().getNumberOfPlayers());
		
		if(player.getPlayerId() == 1) {
			player.setOnTurn(true);
		}
		
		endOfComand();
	}
	
	public void endOfComand() throws IOException {
		dataOut.writeInt(sendingCode);
		receivedCode = 0;
	}

	@Override
	public void run() {
		try {
			dataOut = new DataOutputStream(socket.getOutputStream());
			dataIn = new DataInputStream(socket.getInputStream());
			textIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			textOut = new PrintStream(socket.getOutputStream());
			
			serverExecutes();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
