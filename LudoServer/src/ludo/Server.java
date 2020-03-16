package ludo;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private static Game game;
	
	public static Game getGame() {
		return game;
	}



	public static void setGame(Game game) {
		Server.game = game;
	}



	public static void main(String[] args) {
		int port = 9000;
		try (ServerSocket serverSocket = new ServerSocket(port)){
			int numberOfThreads = 0;
			while(numberOfThreads < 600) {
				Socket socket = serverSocket.accept();
				ServerThreadForClientImpl thread = new ServerThreadForClientImpl(socket);
				thread.start();
				if(game == null)
					game = new Game(1, 1, 1, false);
				else game.setNumberOfPlayers(game.getNumberOfPlayers() + 1);
				numberOfThreads++;
			}
		}catch(Exception e){
			
		}	
	}
}
