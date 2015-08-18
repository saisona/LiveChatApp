package com.components;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.LCA_Const;

public class MessagePane extends JPanel {

	/*
	 * @INFO : so this class has been created out of stream when I was hoping to
	 * fix some problems i got while the stream was on it takes only one more
	 * thing than a simple JPanel, this is an ArrayList of CS_Message which is
	 * the object where we store data in messages in order to print them in the
	 * panel.
	 */
	private static final long serialVersionUID = -5265194613733730753L;
	private ArrayList<CS_Message> _messages;

	public MessagePane() {
		_messages = new ArrayList<CS_Message>();
		fillBuffer();
	}

	public int getArrayListSize() {
		return _messages.size();
	}

	public ArrayList<CS_Message> getThisList() {
		return _messages;
	}

	/*
	 * This is where we add the message to the ArrayList to prevent the call of
	 * the printMessages right under this functions
	 */
	public void addMessage(CS_Message e) {
		if (e != null) {
			_messages.remove(0);
			_messages.add(e);
		} else
			System.err
					.println("[ERROR] NULL POINTER ->"
							+ " CS_Message is null or empty or have failed to be catched by the Client");

	}

	/*
	 * So this function is simple, it only remove all the JLabels (CS_Messages
	 * currently print) and after, repaint the JPanel with the new JLabels (it
	 * means the new CS_Messages), reset the layout wich takes the number of
	 * messages to allocate the right number of rows in the JPanel
	 * 
	 * So just to show you and explain you, you have to enter first your
	 * username by going Connection->new Account-> enter the username before
	 * anything else.
	 */

	public int getPaneWidth() {
		System.out.println(this.getBounds().width);
		return this.getBounds().width;
	}

	public int getPaneHeight() {
		System.out.println(this.getBounds().height);
		return this.getBounds().height;
	}

	public void printMessagesIntoPanel() {
		removeAll();
		this.setLayout(new GridLayout(getArrayListSize(), 1));

		for (CS_Message cs_Message : _messages) {
			JLabel msg = cs_Message.getMessageContent();
			this.add(msg);
		}
		this.revalidate();
		this.repaint();
	}

	public void fillBuffer() {
		for (int i = 0; i < LCA_Const.BUFFER_CS_SIZE; i++) {
			_messages
					.add(new CS_Message("", new JLabel(LCA_Const._EMO), false));
		}
	}
}
