package com.components;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ClientManager implements Runnable {
	private ArrayList<Socket> _Asockets;
	private Socket _socket;
	private ObjectOutputStream _oos;
	private ObjectInputStream _ois;
	private CS_Message _msg;

	public ClientManager(ArrayList<Socket> ArrayList, Socket sckt) {
		_Asockets = ArrayList;
		_socket = sckt;
		_msg = null;
		_ois = null;
	}

	@Override
	public void run() {
		System.out.println("[SERVER] Server waits messages from Client !");
		while (!_socket.isClosed() && _socket.isConnected()) {
			try {
				_ois = new ObjectInputStream(_socket.getInputStream());
				_msg = (CS_Message) _ois.readObject();
			} catch (IOException e) {
				System.err.println("[SERVER] NEW DISCONNECTED CLIENT");
				_Asockets.remove(_socket);
				try {
					_socket.close();
				} catch (Exception e2) {
					System.err
							.println("[ERROR] Can't close the socket ! CRASH EXIT");
					System.exit(-1);
				}
			} catch (ClassNotFoundException e) {
			}
			for (Socket socket : _Asockets) {
				try {
					_oos = new ObjectOutputStream(socket.getOutputStream());
					_oos.writeObject(_msg);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
	}
}
