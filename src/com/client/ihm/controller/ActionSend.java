package com.client.ihm.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JLabel;

import com.client.ihm.view.LCA_view;
import com.components.CS_Message;

public class ActionSend implements ActionListener {

	private LCA_view _view;

	public ActionSend(LCA_view v) {
		_view = v;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (_view.getClient().getSocket().isConnected()
				&& !_view.getClient().getSocket().isClosed()) {
			try {
				String content = _view.getInput().getText();
				String name = _view.getClient().get_name();
				if (!name.isEmpty() && !content.isEmpty()) {
					ObjectOutputStream _oos = _view.getClient().getOOS();
					_oos = new ObjectOutputStream(_view.getClient().getSocket()
							.getOutputStream());
					CS_Message msg2 = new CS_Message(name, new JLabel(content), false);
					_view.getInput().setText("");
					_oos.writeObject(msg2);
				} else
					System.err
							.println("[CLIENT] INFO :Your're trying to send nothing to the server which can crashe it");
			} catch (IOException e1) {
				System.err
						.println("[SERVER] The server may have been closed !\nPlease contact the server's administrator.");
			}
		}
	}
}
