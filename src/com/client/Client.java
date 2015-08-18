package com.client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	private Socket _socket;
	private Socket _oldSocket;
	private String _name;
	private ObjectOutputStream _oos;
	private String _HostName;
	private String _ServerPort;

	public Client(String host, String port) throws NumberFormatException,
			UnknownHostException, IOException {
		_socket = new Socket(host, Integer.parseInt(port));
		_oldSocket = null;
		_HostName = host;
		_ServerPort = port;

		_name = null;
		_oos = null;
	}

	public Socket getSocket() {
		return _socket;
	}

	public ObjectOutputStream getOOS() {
		return _oos;
	}

	public String get_name() {
		return _name;
	}

	public void set_name(String name) {
		_name = name;
	}

	public void ConnectToNewServer(String host, String port) {
		try {
			if (!host.isEmpty() && !port.isEmpty()) { 
				_oldSocket = _socket;
				_socket = new Socket(host, Integer.parseInt(port));
				Disconnect(_oldSocket);
				_HostName = host;
				_ServerPort = port;
			}
		} catch (Exception e) {
			System.err
					.println("[ERROR] Failed Somewhere !\n1) Check the HostName\n2) Check the ServerPort");
		}
	}

	public void ConnectToNewServerPort(String ServerPort) {
		try {
			if (!ServerPort.isEmpty()) {
				_oldSocket = _socket;
				_socket = new Socket(_HostName, Integer.parseInt(ServerPort));
				//Disconnect(_oldSocket);
				_ServerPort = ServerPort;
				System.out
						.println("[INFO] Changing The ServerPort is a complete Success");
			}
		} catch (Exception e) {
			System.err
					.println("[ERROR] Changing the ServerPort has Failed please check the ServerPort that you want to use");
		}
	}

	public void ConnectToNewHost(String HostName) {
		try {
			if (!HostName.isEmpty()) {
				_oldSocket = _socket;
				_socket = new Socket(HostName, Integer.parseInt(_ServerPort));
				Disconnect(_oldSocket);
				_HostName = HostName;
				System.out.println("[INFO] changing HostName is a Success");
			}
		} catch (Exception e) {
			System.err
					.println("[ERROR]Changing the HostName has Failed please check the the name of the server (DNS or IP) "
							+ "that you want to use");
		}
	}

	public void Disconnect(Socket so) throws IOException {
		so.close();
		System.out.println("[INFO] is Communication Socket really closed : "
				+ _socket.isClosed());
	}
}
