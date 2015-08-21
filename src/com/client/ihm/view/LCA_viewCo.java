package com.client.ihm.view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class LCA_viewCo extends JFrame implements ActionListener{

	private static final long serialVersionUID = -6917140277664494507L;
	private LCA_view _view;
	private JLabel 	 _lbl;
	private Container content = getContentPane();
	public LCA_viewCo(LCA_view v) {
		_view = v;
		_lbl = new JLabel("Connected as " + _view.getClient().get_name());
		setLocationRelativeTo(v);
		setMaximumSize(new Dimension(600, 750));
		setMinimumSize(new Dimension(300, 450));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(300, 450);
		setTitle("LiveTchatApp");
	}
	
	public void build()
	{
		content.add(_lbl);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		build();
	}
}
