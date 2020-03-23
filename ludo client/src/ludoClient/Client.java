package ludoClient;

import java.io.IOException;

public class Client extends Thread {
	
	private static boolean startClientThread = false;
	
	public static void setStartClientThread(boolean startClientThread) {
		Client.startClientThread = startClientThread;
	}

	static LudoStart firstPage = new LudoStart();
	
	public static void main(String[] args) {
		
		firstPage.setVisible(true);

		try {
			while(true) {
				Thread.sleep(500);
				if(startClientThread == true) {
					Game.start();
					while(true) {
						Thread.sleep(350);
						ClientThread clientThread = new ClientThread();
						clientThread.start();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


