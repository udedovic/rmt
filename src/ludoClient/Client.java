package ludoClient;

import java.io.IOException;

public class Client {
	public static void main(String[] args) {
		try {
			ClientThread clientThread = new ClientThread();
			clientThread.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
