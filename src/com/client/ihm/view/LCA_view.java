package com.client.ihm.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.LCA_Const;
import com.client.Client;
import com.client.ihm.controller.ActionChangeConnection;
import com.client.ihm.controller.ActionChangeServer;
import com.client.ihm.controller.ActionNewAccount;
import com.client.ihm.controller.ActionQuit;
import com.client.ihm.controller.ActionSend;
import com.client.ihm.controller.ActionSendEmo;
import com.components.MessagePane;
import com.components.ReceivedManager;

public class LCA_view extends JFrame{
	
	private static final long serialVersionUID = 2477092403829656446L;
	private Container content = this.getContentPane();
	private MessagePane 	_infos;
	private JPanel	_inputs;
	private JPanel	_adds;
	private JTextField _input;
	private JButton	_send;
	private JButton	_emo;
	private JLabel _color;
	private JComboBox _colors;
	
	private JMenuBar 	_bar;
	private JMenu 		_option;
	private JMenu		_connection;
	private JMenuItem	_newConnection;
	private JMenuItem	_ServerList;
	private JMenuItem 	_newAccount;
	private JMenuItem	_quit;
	private JMenuItem	_prefs;
	private Client _client;
	
	public LCA_view(Client c) {
		_client = c;
		_infos = new MessagePane();
		_input = new JTextField();
		_inputs = new JPanel();
		_adds = new JPanel();
		_send = new JButton("Send");
		_emo = new JButton(new ImageIcon(LCA_Const.ICON_EMO));
		_color = new JLabel("Color :");
		
		_bar = new JMenuBar();
		_ServerList = new JMenuItem("Change Server");
		_option = new JMenu("Preferences");
		_connection = new JMenu("Connection");
		_newConnection = new JMenuItem("new Connection");
		_newAccount = new JMenuItem("new Account");
		_quit = new JMenuItem("Quit");
		_prefs = new JMenuItem("Preferences");
		_colors = new JComboBox();
	}
	
	public void build()
	{
		_bar.add(_connection);
		_bar.add(_option);
		
		_connection.add(_newAccount);
		_connection.add(_newConnection);
		_connection.addSeparator();
		_connection.add(_quit);
		
		_option.add(_prefs);
		_option.add(_ServerList);
	
		_adds.add(_color, BorderLayout.WEST);
		_adds.add(_colors, BorderLayout.CENTER);
		//_adds.setLayout(new BorderLayout(2,0));
		_adds.setBackground(new Color(140, 140, 147));

		_colors.addItem("Black");
		_colors.addItem("Red");
		_colors.addItem("Breen");
		_colors.addItem("Blue");

		_inputs.setLayout(new BorderLayout(1, 0));
		_inputs.add(_input, BorderLayout.CENTER);
		_inputs.add(_emo, BorderLayout.LINE_START);
		_inputs.add(_send, BorderLayout.LINE_END);
		_inputs.add(_adds, BorderLayout.PAGE_START);
		
		_inputs.setBackground(Color.LIGHT_GRAY);
		_inputs.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		content.setLayout(new BorderLayout(0,1));
		content.add(_infos, BorderLayout.CENTER);
		content.add(_inputs, BorderLayout.SOUTH);
		
		
		this.setJMenuBar(_bar);
		this.setTitle("Client");
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setMinimumSize(new Dimension(800,600));
		this.setVisible(true);
		addActionListener();
	}
	
	public void update() {
		new Thread(new ReceivedManager(_client.getSocket(), this)).start();
	}
	
	public void addActionListener()
	{
		_send.addActionListener(new ActionSend(this));
		_emo.addActionListener(new ActionSendEmo(this));
		_newAccount.addActionListener(new ActionNewAccount(_client));
		_newConnection.addActionListener(new ActionChangeConnection(_client));
		_ServerList.addActionListener(new ActionChangeServer(_client));
		_quit.addActionListener(new ActionQuit(_client));
	}
	
	public Client getClient()
	{
		return _client;
	}

	public JTextField getInput()
	{
		return _input;
	}

	public MessagePane getInfoPanel()
	{
		return _infos;
	}
}
