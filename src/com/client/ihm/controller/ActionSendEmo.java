package com.client.ihm.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.LCA_Const;
import com.client.ihm.view.LCA_view;
import com.components.CS_Message;

public class ActionSendEmo implements ActionListener {


	private LCA_view _view;
	private ImageIcon _emo;
	public ActionSendEmo( LCA_view v) {
		_view = v;
		_emo = LCA_Const._EMO;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (_view.getClient().getSocket().isConnected()
				&& !_view.getClient().getSocket().isClosed()) {
			try {
				String content = _view.getInput().getText();
				String name = _view.getClient().get_name();
				if (!name.isEmpty() && !content.isEmpty()) {
					ObjectOutputStream _oos = _view.getClient().getOOS();
					_oos = new ObjectOutputStream(_view.getClient().getSocket()
							.getOutputStream());
					JLabel lblToSend = new JLabel(content, _emo, JLabel.RIGHT);
					lblToSend.setHorizontalTextPosition(JLabel.RIGHT);
					CS_Message msg2 = new CS_Message(name, lblToSend, true);
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
