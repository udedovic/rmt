package ludoClient;

import java.io.IOException;

public class Client extends Thread {
	public static void main(String[] args) {

		try {
			while(true) {
				Thread.sleep(350);
				ClientThread clientThread = new ClientThread();
				clientThread.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
