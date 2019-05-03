package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUIControler {

	static Socket socketForCommunication = null;
	static BufferedReader fromServer = null;
	static PrintStream forServer = null;
	static BufferedReader userEntry = null;
	static boolean connected = false;

	public static ClientGUI mainWindow;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainWindow = new ClientGUI();
					mainWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void connectOnTheServer(JPanel contentPane, JPanel colorPanel, JMenuItem connectItem,
			JMenuItem disconnectItem) {

		try {
			socketForCommunication = new Socket("localhost", 9000);

			fromServer = new BufferedReader(new InputStreamReader(socketForCommunication.getInputStream()));
			forServer = new PrintStream(socketForCommunication.getOutputStream());
			userEntry = new BufferedReader(new InputStreamReader(System.in));

			colorPanel.setBackground(Color.GREEN);
			connectItem.setEnabled(false);
			disconnectItem.setEnabled(true);
			connected = true;

		} catch (IOException e) {
			JOptionPane.showMessageDialog(contentPane, "Socket closed.", "Error!", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void calculate(JTextField jtfFirstNumber, JTextField jtfSecondNumber, JTextField jtfResult,
			JPanel colorPanel, JMenuItem connectItem, JMenuItem disconnectItem, String operation, JPanel contentPane) {

		String first, second, answer;

		try {
			first = jtfFirstNumber.getText();
			forServer.println(first);

			second = jtfSecondNumber.getText();
			forServer.println(second);

			forServer.println(operation);

			answer = fromServer.readLine();

			if (!answer.equals("OK")) {
				JOptionPane.showMessageDialog(contentPane, answer, "Error!", JOptionPane.ERROR_MESSAGE);
			}

			answer = fromServer.readLine();

			try {
				Double.parseDouble(answer);
				jtfResult.setText(answer);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(contentPane, answer, "Error!", JOptionPane.ERROR_MESSAGE);
				jtfFirstNumber.setText("");
				jtfSecondNumber.setText("");
				jtfResult.setText("");
			}

		} catch (IOException e) {
			JOptionPane.showMessageDialog(contentPane, "You're not connected!", "Error!", JOptionPane.ERROR_MESSAGE);
			connected = false;
			disconnectFromServer(jtfFirstNumber, jtfSecondNumber, jtfResult, colorPanel, connectItem, disconnectItem,
					ClientGUI.btnCalculate, ClientGUI.itemLogin, ClientGUI.itemRegister, ClientGUI.itemGuest);
		}

	}

	public static void disconnectFromServer(JTextField jtfFirstNumber, JTextField jtfSecondNumber, JTextField jtfResult,
			JPanel colorPanel, JMenuItem connectItem, JMenuItem disconnectItem, JButton btnCalculate,
			JMenuItem itemLogin, JMenuItem itemRegister, JMenuItem itemGuest) {
		if (connected) {
			forServer.println("/exit");
			forServer.println("/exit");
			forServer.println("/exit");
			connected = false;
		}

		jtfFirstNumber.setText("");
		jtfSecondNumber.setText("");
		jtfResult.setText("");
		jtfFirstNumber.setEnabled(false);
		jtfSecondNumber.setEnabled(false);
		btnCalculate.setEnabled(false);
		itemLogin.setEnabled(true);
		itemRegister.setEnabled(true);
		itemGuest.setEnabled(true);
		colorPanel.setBackground(Color.RED);
		connectItem.setEnabled(true);
		disconnectItem.setEnabled(false);
	}

	public static void exitApp(JPanel contentPane, JTextField jtfFirstNumber, JTextField jtfSecondNumber,
			JTextField jtfResult, JPanel colorPanel, JMenuItem connectItem, JMenuItem disconnectItem) {
		int option = JOptionPane.showConfirmDialog(mainWindow, "Do you really want to quit?", "Exit",
				JOptionPane.YES_NO_OPTION);

		if (option == JOptionPane.YES_OPTION) {
			disconnectFromServer(jtfFirstNumber, jtfSecondNumber, jtfResult, colorPanel, connectItem, disconnectItem,
					ClientGUI.btnCalculate, ClientGUI.itemLogin, ClientGUI.itemRegister, ClientGUI.itemGuest);
			System.exit(0);
		}
	}

	public static void loginStart() {
		forServer.println("/login");
	}

	public static void registerStart() {
		forServer.println("/reg");
	}

	public static void guest() {
		forServer.println("/guest");
	}

	public static void login(JTextField username, JTextField password, LoginGUI loginWindow, JTextField firstNumber,
			JTextField secondNumber, JButton btnCalculate, JMenuItem itemLogin, JMenuItem registerItem,
			JMenuItem guestItem) {
		try {

			String answer = null;

			forServer.println(username.getText());
			forServer.println(password.getText());

			answer = fromServer.readLine();

			if (!answer.equals("OK")) {
				JOptionPane.showMessageDialog(ClientGUI.loginWindow.getContentPane(), answer, "Error!",
						JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(ClientGUI.loginWindow.getContentPane(), "Successful logging!", "Notice",
						JOptionPane.NO_OPTION);
				firstNumber.setEnabled(true);
				secondNumber.setEnabled(true);
				btnCalculate.setEnabled(true);
				itemLogin.setEnabled(false);
				registerItem.setEnabled(false);
				guestItem.setEnabled(false);

				loginWindow.dispose();
			}

		} catch (IOException e) {
			ClientGUI.loginWindow.dispose();

			JOptionPane.showMessageDialog(ClientGUI.contentPane, "Server's not in function!", "Error!",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void register(JTextField username, JTextField password, RegistrationGUI registerWindow,
			JTextField firstNumber, JTextField secondNumber, JButton btnCalculate) {
		try {

			String answer = null;

			forServer.println(username.getText());
			forServer.println(password.getText());

			answer = fromServer.readLine();

			if (!answer.equals("OK")) {
				JOptionPane.showMessageDialog(ClientGUI.registerWindow.getContentPane(), answer, "Error!",
						JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(ClientGUI.registerWindow.getContentPane(), "Successful registration!",
						"Notice", JOptionPane.NO_OPTION);

				firstNumber.setEnabled(true);
				secondNumber.setEnabled(true);
				btnCalculate.setEnabled(true);

				registerWindow.dispose();
			}

		} catch (IOException e) {
			ClientGUI.registerWindow.dispose();

			JOptionPane.showMessageDialog(ClientGUI.contentPane, "Server's not in function!", "Error!",
					JOptionPane.ERROR_MESSAGE);

		}
	}
}
