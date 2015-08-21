package com.components;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JLabel;

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
			JFrame jf = new JFrame("[SERVER] ERROR 4242");
			JLabel lbl = new JLabel("[SERVER] You have been Disconnected from the Server");
			jf.getContentPane().add(lbl);
			_view.dispose();
			
			jf.pack();
			jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			jf.setVisible(true);
			System.err.println("[SERVER] The server may have been closed !");
		} catch (ClassNotFoundException e) {
			// NOTHING TO PRINT HERE BECAUSE IT CAN'T HAPPEN !
		}
	}

}
