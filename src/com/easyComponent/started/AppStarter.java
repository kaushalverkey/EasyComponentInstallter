package com.easyComponent.started;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

import com.easyComponent.factory.CommandFactory;
import com.easyComponent.factory.commands.ICommand;
import com.easyComponent.manger.PackageManager;

public class AppStarter {

	private static String[] commands = new String[] { "DEPEND TELNET TCPIP NETCARD", "DEPEND TCPIP NETCARD",
			"DEPEND DNS TCPIP NETCARD", "DEPEND BROWSER TCPIP HTML", "INSTALL NETCARD", "INSTALL TELNET", "INSTALL foo",
			"REMOVE NETCARD", "INSTALL BROWSER", "INSTALL DNS", "LIST", "REMOVE TELNET", "REMOVE NETCARD", "REMOVE DNS",
			"REMOVE NETCARD", "INSTALL NETCARD", "REMOVE TCPIP", "REMOVE BROWSER", "REMOVE TCPIP", "END" };

	public static void main(String[] args) {
		PackageManager packageManager = new PackageManager();
		
		
		try (InputStreamReader in = new InputStreamReader(System.in);
				BufferedReader buffer = new BufferedReader(in)) {
				String line;
				while ((line = buffer.readLine()) != null) {
					String[] tokens = line.split("\\s");
					System.out.println(Arrays.toString(tokens));
					executeCommand(tokens, packageManager);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	private static void executeCommand(String[] args, PackageManager packageManager) {
		for (String commandLine : commands) {
			// String commandTokens = commandLine.split(" ");
			// TODO: need to parse args to get command components
			String commandName = args.length > 0 ? args[0] : "Help";

			String[] commandArgs = args.length > 1 ? Arrays.copyOfRange(args, 1, args.length) : new String[0];

			ICommand command = CommandFactory.GetCommand(commandName);

			if (command != null) {
				if (command.ValidateCommand(commandArgs)) {
					command.ProcessCommand(commandArgs, packageManager);
					
				} else {
					System.out.println(command.getCommand());
				}
				break;
			}
		}
	}

}
