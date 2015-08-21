package com.components;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ConnectionManager implements Runnable {
	private ServerSocket _serverSocket;
	private ArrayList<Socket> _client;

	public ConnectionManager(ServerSocket serverSocket) {
		this._serverSocket = serverSocket;
		this._client = new ArrayList<Socket>();
	}

	public ServerSocket getThisServerSocket() {
		return this._serverSocket;
	}

	public ArrayList<Socket> get_Client() {
		return this._client;
	}

	@Override
	public void run() {
		System.out.println("[SERVER] INIT DONE !");
		Socket socket;
		try {

			while (!_serverSocket.isClosed()) {
				System.out.println("[SERVER] Waiting for connection...");
				socket = _serverSocket.accept();
				System.out.println("[SERVER] New Client Connected !");
				// DATA Treatment :)
				_client.add(socket);
				// TODO : Fix Me !
				new Thread(new CommandListener(this)).start();
				ClientManager CM = new ClientManager(_client, socket);
				new Thread(CM).start();

			}
		} catch (IOException e) {
			System.err.println("[SERVER] END OF STREAM !");
		}
	}
}
