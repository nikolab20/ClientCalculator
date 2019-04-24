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

				System.out.println(fromServer.readLine());
				String first = userEntry.readLine();
				forServer.println(first);

				System.out.println(fromServer.readLine());
				String second = userEntry.readLine();
				forServer.println(second);
				
				String result = fromServer.readLine();
				
				if(result.equals("Goodbye! :)")){
					System.out.println(result);
					break;
				}

				System.out.println("Result: " + result);
			}
			socketForCommunication.close();
		} catch (IOException e) {
			System.out.println("Problems with connection.");
		}
	}
}
