package com;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class LCA_Const {
	/*
	 * Changing this file means to change the default values, change this file only if you're sure that what you've done is
	 * Correct, or is you are using a server which may be better to use with finals static values !
	 * 
	 * BUFFER_CS_SIZE is the BufferSize, the number of Message which will be display to the screen 
	 * LOCALHOST is the String which is used to connect to the Server, it means the hostname.
	 * LOCALSERVERPORT is obviously the Port which is used for the connection between the client and the server for the Socket Connection
	 */
	
	public static final int BUFFER_CS_SIZE = 25;
	public static final String LOCALHOST = "localhost";
	public static final String LOCALSERVERPORT = "4244";
	public static final int LOCALSPORT = 4244;
	public static final URL ICON_EMO = LCA_Const.class.getClassLoader().getResource("emo.png");
	public static final ImageIcon _EMO = new ImageIcon(ICON_EMO);
	
	public static final JButton RED_BUTTON = new JButton();
	public static final JButton BLACK_BUTTON = new JButton();
	public static final JButton BLUE_BUTTON = new JButton();
	public static final JButton GREEN_BUTTON = new JButton();
}
