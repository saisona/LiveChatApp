package com.client.ihm.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import com.client.Client;

public class ActionQuit implements ActionListener {
	
	private Client _client;
	
	public ActionQuit(Client c) {
		_client = c;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (_client.getOOS() != null) {
			try {
				_client.getOOS().flush();
				_client.getOOS().close();
				_client.getSocket().close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		System.exit(0);
	}

}
