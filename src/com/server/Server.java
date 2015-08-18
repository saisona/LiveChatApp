package com.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.SocketException;

import com.components.ConnectionManager;

public class Server {
	private ServerSocket _SocketServer;
	
	public Server(int port) throws IOException
	{
		this._SocketServer = new ServerSocket(port);
	}
	
	public void build() throws SocketException
	{
		_SocketServer.setReuseAddress(true);
		new ConnectionManager(_SocketServer).run();
	}
	
	/*
	 * That's the end of this class
	 * It only job is to declare a new ServerSocket on a specific port !
	 */
}
