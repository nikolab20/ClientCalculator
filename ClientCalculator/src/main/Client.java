package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Client {

	static Socket socketForCommunication = null;
	static BufferedReader fromServer = null;
	static PrintStream forServer = null;
	static BufferedReader userEntry = null;

	public static void main(String[] args) {

		try {
			socketForCommunication = new Socket("localhost", 9000);

			fromServer = new BufferedReader(new InputStreamReader(socketForCommunication.getInputStream()));
			forServer = new PrintStream(socketForCommunication.getOutputStream());
			userEntry = new BufferedReader(new InputStreamReader(System.in));

			while (true) {

				String first, second, answer;
				boolean exit = false;

				do {
					System.out.println(fromServer.readLine());
					first = userEntry.readLine();
					forServer.println(first);
					answer = fromServer.readLine();
				} while (!answer.equals("OK"));

				do {
					System.out.println(fromServer.readLine());
					second = userEntry.readLine();
					forServer.println(second);
					answer = fromServer.readLine();
				} while (!answer.equals("OK"));

				System.out.println(fromServer.readLine());
				String operation = userEntry.readLine();
				forServer.println(operation);

				String result = fromServer.readLine();

				if (result.equals("Goodbye! :)")) {
					System.out.println(result);
					exit = true;
				} else {
					System.out.println("Result: " + result + "\n");
				}

				if (exit)
					break;
			}

			socketForCommunication.close();
		} catch (IOException e) {
			System.out.println("Problems with connection.");
		}
	}
}
