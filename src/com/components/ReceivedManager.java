package com.components;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import com.client.ihm.view.LCA_view;

public class ReceivedManager implements Runnable {

	private ObjectInputStream _ois;
	private Socket _socket;
	private LCA_view _view;

	public ReceivedManager(Socket socket, LCA_view v) {
		_socket = socket;
		_view = v;
	}

	@Override
	public void run() {
		try {
			while (_socket.isConnected() && !_socket.isClosed()) {
				_ois = new ObjectInputStream(_socket.getInputStream());
				CS_Message msg = (CS_Message) _ois.readObject();
				_view.getInfoPanel().addMessage(msg);
				_view.getInfoPanel().printMessagesIntoPanel();
			}
		} catch (IOException e) {
			System.err.println("\n[SERVER] The server may have been closed !");
			System.exit(-1);
		} catch (ClassNotFoundException e) {
			// NOTHING TO PRINT HERE BECAUSE IT CAN'T HAPPEN !
		}
	}

}
