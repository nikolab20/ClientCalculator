package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUIControler {

	static Socket socketForCommunication = null;
	static BufferedReader fromServer = null;
	static PrintStream forServer = null;
	static BufferedReader userEntry = null;

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

	public static void connectOnTheServer(JPanel contentPane, JPanel colorPanel) {

		try {
			socketForCommunication = new Socket("localhost", 9000);

			fromServer = new BufferedReader(new InputStreamReader(socketForCommunication.getInputStream()));
			forServer = new PrintStream(socketForCommunication.getOutputStream());
			userEntry = new BufferedReader(new InputStreamReader(System.in));
			
			colorPanel.setBackground(Color.GREEN);
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(contentPane, "Socket closed.", "Error!", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void calculate(JTextField firstNumber, JTextField secondNumber, JTextField result, String operation,
			JPanel contentPane) {

		String first, second, answer;

		try {
			first = firstNumber.getText();
			forServer.println(first);

			second = secondNumber.getText();
			forServer.println(second);

			forServer.println(operation);

			answer = fromServer.readLine();
			
			if (!answer.equals("OK"))
				JOptionPane.showMessageDialog(contentPane, answer, "Error!", JOptionPane.ERROR_MESSAGE);
			
			answer = fromServer.readLine();
			
			try {
				Double.parseDouble(answer);
				result.setText(answer);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(contentPane, answer, "Error!", JOptionPane.ERROR_MESSAGE);
			}
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(contentPane, "Problems with communication!", "Error!", JOptionPane.ERROR_MESSAGE);
		}

	}
}
