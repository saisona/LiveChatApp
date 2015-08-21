package com.components;

import java.io.IOException;
import java.util.Scanner;

import javax.swing.JLabel;

public class CommandListener implements Runnable {

	public static Scanner _sc;
	private ConnectionManager _coMan;
	public static boolean _gotCommand = false;

	public CommandListener(ConnectionManager s) {
		_sc = new Scanner(System.in);
		_coMan = s;
	}

	public void parseString(String str) throws IOException {
		if (str.startsWith("/")) {
			_gotCommand = true;
			str = str.substring(1);
			String[] cmd = str.split(" ");
			if (cmd.length == 1) {
				String command = cmd[0];
				if (command.equalsIgnoreCase("disc")) {
					System.out.println("[SERVER] Shutting down the Server !");
					_coMan.getThisServerSocket().close();
					System.out
							.println("[SERVER] Shutting down the Server is a SUCCESS");
					System.exit(0);
				} else if (command.equalsIgnoreCase("num"))
					System.out.println("[SERVER] Number of Connected : "
							+ _coMan.get_Client().size());
				else if (command.equalsIgnoreCase("pp"))
					System.out.println("[SERVER] Server is running on port : "
							+ _coMan.getThisServerSocket().getLocalPort());
			} else if (cmd.length == 3) {
				if (cmd[0].equalsIgnoreCase("msg")) {
					/*
					 * TODO : FIX ME -> Try to send msg from the Server to
					 * clients ! -----> HERE
					 */
					CS_Message msg = new CS_Message(cmd[1], new JLabel(cmd[2]),
							false);
					System.out.println(msg);
				}

			} else {
				System.err.println("[SERVER-ERROR] NOT A COMMAND !");
			}
		}
	}

	@Override
	public void run() {
		while (true) {
			System.out.print("[SERVER-COMMAND] : ");
			try {
				parseString(_sc.nextLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
