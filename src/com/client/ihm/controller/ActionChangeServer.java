package com.client.ihm.controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.client.Client;

public class ActionChangeServer implements ActionListener {

	private Client _client;
	private JFrame _frame;
	private JLabel _labelPort;
	private JLabel _labelHost;
	private JTextField _fieldPort;
	private JTextField _fieldHost;
	private JButton _accept;
	private JButton _accept2;
	private JButton _accept3;
	private JPanel _panel1;
	private JPanel _panel2;

	public ActionChangeServer(Client c) {
		_client = c;

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		/*-------------------|
		 * Construction Part |
		 *-------------------|
		 */
		_labelHost = new JLabel("HostName : ");
		_labelPort = new JLabel("Server Port :");
		_fieldPort = new JTextField(10);
		_fieldHost = new JTextField(10);
		_accept = new JButton("Change HostName");
		_accept2 = new JButton("Change ServerPort");
		_accept3 = new JButton("Change All");
		_panel1 = new JPanel();
		_panel2 = new JPanel();
		_frame = new JFrame("Change Server");

		/*-------------------|
		 *   Adding Part	 |
		 *-------------------|
		 */
		_panel1.add(_labelHost, BorderLayout.WEST);
		_panel1.add(_fieldHost, BorderLayout.CENTER);
		_panel1.add(_accept2, BorderLayout.EAST);
		_panel2.add(_labelPort, BorderLayout.WEST);
		_panel2.add(_fieldPort, BorderLayout.CENTER);
		_panel2.add(_accept, BorderLayout.EAST);

		_frame.getContentPane().add(_panel1, BorderLayout.NORTH);
		_frame.getContentPane().add(_panel2, BorderLayout.CENTER);
		_frame.getContentPane().add(_accept3, BorderLayout.SOUTH);
		

		_frame.pack();
		_frame.setResizable(false);
		_frame.setVisible(true);
		_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		_accept3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					System.out.println("[INFO] Changing the Server ...");
					_client.ConnectToNewServer(_fieldHost.getText(),
							_fieldPort.getText());
				} catch (Exception e) {
					System.err
							.println("[ERROR] Something has failed ->\n1) HostName Input\n2) ServerPort Number");
				}
			}
		});
		_accept.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("[INFO] Changing the ServerPort ...");
				_client.ConnectToNewServerPort(_fieldPort.getText());
			}
		});
		_accept2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("[INFO] Changing the HostName ...");
				_client.ConnectToNewHost(_fieldHost.getText());
			}
		});
	}

}
