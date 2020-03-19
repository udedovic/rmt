package ludoClient;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class LudoStart extends JFrame {

	private JPanel contentPane;
	private JLabel lblStartBackground;
	private JLabel lblServerName;
	private JLabel lblRoomName;
	private JLabel lblChangeSBack;
	private JLabel lblChangeS;
	private JLabel lblMakeRoomBack;
	private JLabel lblMakeRoom;
	private JLabel lblGO;
	private JLabel lblWelcome;
	private JLabel lblServerNameFild;
	private JTextField textRoom;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// LudoStart frame = new LudoStart();
	// frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Create the frame.
	 */
	public LudoStart() {
		setTitle("LUDO");
		setIconImage(Toolkit.getDefaultToolkit().getImage(LudoStart.class.getResource("/Resource/ludo1.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 562);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(2, 2, 2, 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblServerName());
		contentPane.add(getLblRoomName());
		contentPane.add(getLblServerNameFild());
		contentPane.add(getTextRoom());
		contentPane.add(getLblChangeS());
		contentPane.add(getLblMakeRoom());
		contentPane.add(getLblChangeSBack());
		contentPane.add(getLblMakeRoomBack());
		contentPane.add(getLblGO());
		contentPane.add(getLblWelcome());
		contentPane.add(getLblStartBackground());
	}

	private JLabel getLblStartBackground() {
		if (lblStartBackground == null) {
			lblStartBackground = new JLabel("");
			lblStartBackground.setIcon(new ImageIcon(LudoStart.class.getResource("/Resource/background.jpg")));
			lblStartBackground.setBounds(-26, -41, 543, 654);
		}
		return lblStartBackground;
	}

	private JLabel getLblServerName() {
		if (lblServerName == null) {
			lblServerName = new JLabel("");
			lblServerName.setIcon(new ImageIcon(LudoStart.class.getResource("/Resource/FirstPage/serverFP.png")));
			lblServerName.setBounds(42, 91, 131, 54);
		}
		return lblServerName;
	}

	private JLabel getLblRoomName() {
		if (lblRoomName == null) {
			lblRoomName = new JLabel("");
			lblRoomName.setIcon(new ImageIcon(LudoStart.class.getResource("/Resource/FirstPage/roomFP.png")));
			lblRoomName.setBounds(52, 147, 121, 55);
		}
		return lblRoomName;
	}

	private JLabel getLblChangeSBack() {
		if (lblChangeSBack == null) {
			lblChangeSBack = new JLabel("");
			lblChangeSBack.setIcon(new ImageIcon(LudoStart.class.getResource("/Resource/FirstPage/backFP.png")));
			lblChangeSBack.setBounds(111, 225, 265, 65);
		}
		return lblChangeSBack;
	}

	private JLabel getLblChangeS() {
		if (lblChangeS == null) {
			lblChangeS = new JLabel("");
			lblChangeS.setIcon(new ImageIcon(LudoStart.class.getResource("/Resource/FirstPage/changeServer.png")));
			lblChangeS.setBounds(124, 235, 250, 55);
		}
		return lblChangeS;
	}

	private JLabel getLblMakeRoomBack() {
		if (lblMakeRoomBack == null) {
			lblMakeRoomBack = new JLabel("");
			lblMakeRoomBack.setIcon(new ImageIcon(LudoStart.class.getResource("/Resource/FirstPage/backFP.png")));
			lblMakeRoomBack.setBounds(111, 303, 265, 65);
		}
		return lblMakeRoomBack;
	}

	private JLabel getLblMakeRoom() {
		if (lblMakeRoom == null) {
			lblMakeRoom = new JLabel("");
			lblMakeRoom.setIcon(new ImageIcon(LudoStart.class.getResource("/Resource/FirstPage/createRoom.png")));
			lblMakeRoom.setBounds(136, 314, 221, 54);
		}
		return lblMakeRoom;
	}

	private JLabel getLblGO() {
		if (lblGO == null) {
			lblGO = new JLabel("");
			lblGO.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {

					String text = textRoom.getText();
					if (text != null && !text.equals("")) {
						Client.setRoom(Integer.parseInt(text));
						ClientThreadImpl.setAddress("localhost");
						ClientThreadImpl.setSendingCode(ClientThread.GO_START);
						Client.setStartClientThread(true);
					} else {
						int value = JOptionPane.showConfirmDialog(LudoStart.this,
								"You didn't enter room name. \nDo you want to create new one?", "Warning",
								JOptionPane.YES_NO_OPTION);
						if (value == 0) {
							ClientThreadImpl.setSendingCode(ClientThread.CREATE_ROOM);
							Client.setStartClientThread(true);
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							JOptionPane.showMessageDialog(LudoStart.this,
									"You have successfully created room number: " + Client.getRoom(), "Room created",
									JOptionPane.INFORMATION_MESSAGE);
						}

					}

				}
			});
			lblGO.setIcon(new ImageIcon(LudoStart.class.getResource("/Resource/FirstPage/GOButtonF (2).png")));
			lblGO.setBounds(198, 381, 110, 115);
		}
		return lblGO;
	}

	private JLabel getLblWelcome() {
		if (lblWelcome == null) {
			lblWelcome = new JLabel("");
			lblWelcome.setIcon(new ImageIcon(LudoStart.class.getResource("/Resource/FirstPage/welcome.png")));
			lblWelcome.setBounds(128, 13, 204, 65);
		}
		return lblWelcome;
	}

	private JLabel getLblServerNameFild() {
		if (lblServerNameFild == null) {
			lblServerNameFild = new JLabel("New label");
			lblServerNameFild.setFont(new Font("Showcard Gothic", Font.PLAIN, 24));
			lblServerNameFild.setForeground(new Color(255, 153, 51));
			lblServerNameFild.setBounds(185, 101, 128, 30);
		}
		return lblServerNameFild;
	}

	private JTextField getTextRoom() {
		if (textRoom == null) {
			textRoom = new JTextField();
			textRoom.setBackground(new Color(255, 255, 204));
			textRoom.setForeground(new Color(255, 153, 51));
			textRoom.setHorizontalAlignment(SwingConstants.CENTER);
			textRoom.setFont(new Font("Showcard Gothic", Font.PLAIN, 24));
			textRoom.setBounds(179, 158, 186, 30);
			textRoom.setColumns(10);
		}
		return textRoom;
	}
}
