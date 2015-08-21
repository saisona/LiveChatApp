package com.components;

import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.LCA_Const;

public class CS_Message implements Serializable {

	private static final long serialVersionUID = 7142430973801500900L;
	private String _exp;
	private JLabel _msgToSend;
	private ImageIcon _emo;
	
	public CS_Message(String exp, JLabel msg, boolean withEmo) {
		_msgToSend = msg;
		_exp = exp;
		if (withEmo) {
			_emo = new ImageIcon(LCA_Const.ICON_EMO);
		}
	}

	
	public JLabel getMessageContent() {
		if (_exp.isEmpty() || _msgToSend.getText().isEmpty())
			return new JLabel();
		String _msg = (_exp + " : " + _msgToSend.getText());

		if (_emo != null) {
			System.err.println("[INFO] Sending with an emo");
			return new JLabel(_msg, _emo, JLabel.LEFT);
		} else {
			System.err.println("[INFO] Sending without emo");
			return new JLabel(_msg);
		}
	}

	public void setExp(String nwExp) {
		_exp = nwExp;
	}
	
	public String toString()
	{
		return (_exp +" : "+(_msgToSend.getText()));
	}
}
