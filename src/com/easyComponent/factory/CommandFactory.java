package com.easyComponent.factory;

import com.easyComponent.factory.commands.DependCommand;
import com.easyComponent.factory.commands.HelpCommand;
import com.easyComponent.factory.commands.ICommand;
import com.easyComponent.factory.commands.InstallCommand;
import com.easyComponent.factory.commands.ListCommand;
import com.easyComponent.factory.commands.RemoveCommand;

public class CommandFactory {

	public final static String COMMAND_DEPEND = "DEPEND";
	public final static String COMMAND_INSTALL = "INSTALL";
	public final static String COMMAND_REMOVE = "REMOVE";
	public final static String COMMAND_LIST = "LIST";

	public static ICommand GetCommand(String commandName) {
		switch (commandName) {
		case COMMAND_DEPEND:
			return new DependCommand();
		case COMMAND_INSTALL:
			return new InstallCommand();
		case COMMAND_LIST:
			return new ListCommand();
		case COMMAND_REMOVE:
			return new RemoveCommand();
		default:
			System.out.println("Unsupported Command: " + commandName);
			break;
		}

		return new HelpCommand();
	}

}
