package com.components;

import java.util.Scanner;

public class CommandListener implements Runnable {

	public static Scanner _sc;
	
	public CommandListener() {
		_sc = new Scanner(System.in);
	}
	
	public void parseString(String str)
	{
		int i = 0;
		while (i < str.length())
		{
			
			i++;
		}
	}
	
	@Override
	public void run() {
		System.out.print("[SERVER-COMMAND] :");
		
	}

}
