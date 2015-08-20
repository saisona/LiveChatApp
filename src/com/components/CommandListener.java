package com.components;

import java.io.IOException;
import java.util.Scanner;

public class CommandListener implements Runnable {

	public static Scanner _sc;
	public ConnectionManager _coMan;

	public CommandListener(ConnectionManager s) {
		_sc = new Scanner(System.in);
		_coMan = s;
	}

	public void parseString(String str) {
		if (str.startsWith("disc") || str.startsWith("Disc")) {
			System.out
					.println("[SERVER] Closing the Server (means ServerPort and HostConnection)");
			try {
				_coMan.getThisServerSocket().close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out
					.println("[SERVER] Closing the ServerSocket is a Success !");
			System.exit(0);
		} else if (str.startsWith("num") || str.startsWith("Num"))
			System.out.println("[SERVER] nuber of connected people = "
					+ _coMan.get_Client().size());
		else if (str.equalsIgnoreCase("PP")
				|| str.equalsIgnoreCase("printport"))
			System.out.println("[SERVER] The server is connected to the port : "
					+ this._coMan.getThisServerSocket().getLocalPort());
	}

	@Override
	public void run() {
		while (true) {
			System.out.print("[SERVER-COMMAND] : ");
			parseString(_sc.nextLine());
		}
	}

}
