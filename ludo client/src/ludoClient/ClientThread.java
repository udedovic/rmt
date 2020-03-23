package ludoClient;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class ClientThread extends Thread {
	
	private final int RECIVED_BAD = 0;
	private final int RECIVED_GOOD = 1;
	
	
	private static String address = "localhost";
	private int port = 9000;
	private Socket socket;
	private static DataOutputStream dataOut;
	private static DataInputStream dataIn;
	private static PrintStream textOut;
	private static BufferedReader textIn;
	private static String nameOfPlayer;
	private static String colorOfPlayer;
	
	
	public static String getAddress() {
		return address;
	}

	public static void setAddress(String address) {
		ClientThread.address = address;
	}

	public static String getNameOfPlayer() {
		return nameOfPlayer;
	}

	public static void setNameOfPlayer(String nameOfPlayer) {
		ClientThread.nameOfPlayer = nameOfPlayer;
	}

	public static String getColorOfPlayer() {
		return colorOfPlayer;
	}

	public static void setColorOfPlayer(String colorOfPlayer) {
		ClientThread.colorOfPlayer = colorOfPlayer;
	}
	
	

	private static int sendingCode = 10; //everything OK
	private int recivedCode = 1; // everything OK
	private static int numberOnDice;

	public static int getSendingCode() {
		return sendingCode;
	}

	public static void setSendingCode(int sendingCode) {
		ClientThread.sendingCode = sendingCode;
	}
	
	public ClientThread() throws UnknownHostException, IOException {
		socket = new Socket(address, port);
	}

	public void clientExecutes() throws IOException {
		
		switch(sendingCode) {
		case 0:
			/*
			 * 	ovde apdejtujemo podatke
			 */
			dataOut.writeInt(sendingCode);
			break;
		case Command.THROW_DICE:
			throwDice();
			sendingCode = Command.THROW_DICE; // obrisi ovo
			break;
		case Command.PLAYER_IS_READY:
			playerIsReady();
			break;
		case Command.GO_START:
			goStart();
			sendingCode = Command.THROW_DICE; // obrisi ovo obavezno
			break;
		default:
			sendingCode = 0;
			dataOut.writeInt(sendingCode);
			break;
		}
	}
	
	private void goStart() throws IOException {
		
		dataOut.writeInt(Command.GO_START);
		dataOut.writeInt(Game.game.getRoom());
		
		while(dataIn.available() == 0) {}
		recivedCode = dataIn.readInt();
		
		if(recivedCode == RECIVED_BAD) {
			/*
			 * pop up
			 */
			System.out.println("GRESKA!");
		} else {
			
			LudoMain mainMenu = new LudoMain();
			Client.firstPage.setVisible(false);
			mainMenu.setVisible(true);
		}
		
		endOfCommand();
	}

	private void playerIsReady() throws IOException {
		dataOut.writeInt(Command.PLAYER_IS_READY);
		textOut.println(nameOfPlayer);
		textOut.println(colorOfPlayer);
		endOfCommand();
	}

	private void throwDice() throws IOException {
		dataOut.writeInt(Command.THROW_DICE);
		
		while(dataIn.available() == 0) {}

		numberOnDice = dataIn.readInt();
		endOfCommand();
	}
	
	public void endOfCommand() throws IOException {
		while(dataIn.available() == 0) {
		}
		recivedCode = dataIn.readInt();
		recivedCode = RECIVED_GOOD;
		sendingCode = 0;
	}

	@Override
	public void run() {
		try {
			dataIn = new DataInputStream(socket.getInputStream());
			dataOut = new DataOutputStream(socket.getOutputStream());
			textIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			textOut = new PrintStream(socket.getOutputStream());
			
			System.out.println("proba");
			clientExecutes();
			System.out.println(numberOnDice);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
