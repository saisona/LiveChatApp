package com.LiveChatApp;

import java.io.IOException;

import com.LCA_Const;
import com.client.Client;
import com.client.ihm.view.LCA_view;

public class LCA_Client {

	public static void main(String[] args) {

		try {
			if (args.length >= 2) {
				Client client = new Client(args[0], args[1]);
				LCA_view view = new LCA_view(client);
				view.build();
				view.update();
			} else {
				Client client = new Client(LCA_Const.LOCALHOST,
						LCA_Const.LOCALSERVERPORT);
				LCA_view view = new LCA_view(client);
				view.build();
				view.update();
				System.err
						.println("[INFO] You are using the Local Version\n"
								+ "Usage : java -jar LCA_Client.jar [HOSTNAME] [SERVERPORT] \n"
								+ "-> Using the Default ServerPort : "
								+ LCA_Const.LOCALSERVERPORT + "\n"
								+ "-> Using the Default Host : "
								+ LCA_Const.LOCALHOST);

			}
		} catch (IOException e) {
			System.err.println("[ERROR] Warning, server may be offline ! ");
			System.exit(-1);
		}
	}

}
