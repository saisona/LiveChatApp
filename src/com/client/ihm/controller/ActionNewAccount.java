package com.client.ihm.controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.client.Client;

public class ActionNewAccount implements ActionListener {

	private Client 	_client;
	private JFrame	_frame;
	private JLabel	_name;
	private JTextField	_username;
	private JButton	_nameSend;
	
	public ActionNewAccount(Client c) {
		_client = c;
		_username = new JTextField();
		_frame = new JFrame();
		_name = new JLabel("Username :");
		_nameSend = new JButton("Send");
	}
	
	public void build()
	{
		_frame.getContentPane().add(_name, BorderLayout.WEST);
		_frame.getContentPane().add(_username, BorderLayout.CENTER);
		_frame.getContentPane().add(_nameSend, BorderLayout.EAST);
		
		_frame.setMinimumSize(new Dimension(280,50));
		_frame.setVisible(true);
		_frame.setLocationRelativeTo(null);
		_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		_nameSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!_username.getText().isEmpty()) {
					_client.set_name(_username.getText());
					System.out.println("the Username has been set to " + _client.get_name());
					_frame.dispose();
				}else System.err.println("[INFO] null pointer detected -> username input");
			}
		});
		build();
	}

}
