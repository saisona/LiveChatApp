package com.client.ihm.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.client.Client;
import com.client.ihm.view.LCA_view;

public class ActionChangeConnection implements ActionListener {
	
	private Client _client;
	
	public ActionChangeConnection(Client c) {
		_client = c;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		LCA_view v = new LCA_view(_client);
		v.build();
		v.update();
	}

}
