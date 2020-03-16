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

public class ClientThread extends Thread {

	private String address = "localhost";
	private int port = 9000;
	private Socket socket;
	private static DataOutputStream dataOut;
	private static DataInputStream dataIn;
	private static PrintStream textOut;
	private static BufferedReader textIn;
	private static String nameOfPlayer;
	private static String colorOfPlayer;
	
	
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
	
	

	private int sendingCode = 0; //everything OK
	private static int numberOnDice;
	
	public ClientThread() throws UnknownHostException, IOException {
		socket = new Socket(address, port);
	}

	public void clientExecutes() throws IOException {
		switch(sendingCode) {
		case 10:
			throwDice();
			sendingCode = 0;
			break;
		case 11:
			playerIsReady();
			sendingCode = 0;
			break;
			
		}
	}
	
	private void playerIsReady() {
		textOut.println(nameOfPlayer);
		textOut.println(colorOfPlayer);
	}

	private void throwDice() throws IOException {
		dataOut.writeInt(10);
		numberOnDice = dataIn.readInt();
//		System.out.println(numberOnDice);
	}

	@Override
	public void run() {
		try {
			dataIn = new DataInputStream(socket.getInputStream());
			dataOut = new DataOutputStream(socket.getOutputStream());
			textIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			textOut = new PrintStream(socket.getOutputStream());
			dataOut.writeInt(69);
			clientExecutes();
			throwDice();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
