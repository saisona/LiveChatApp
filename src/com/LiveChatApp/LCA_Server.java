package com.LiveChatApp;

import java.io.IOException;

import com.LCA_Const;
import com.server.Server;

public class LCA_Server {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		if (args.length >= 1) {
			Server server = new Server(Integer.parseInt(args[0]));
			server.build();
		} else {
			System.out.println("[INFO] Usage java -jar [LCA_Server.jar] \"port number\" -> using the Default port : "+ LCA_Const.LOCALSPORT);
			Server server = new Server(LCA_Const.LOCALSPORT);
			server.build();
		}

	}
}
