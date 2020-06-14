package com.easyComponent.factory.commands;

import com.easyComponent.manger.PackageManager;

public class HelpCommand implements ICommand {
	
	
	private String helpText = "#  =========================================================\n"
							+"##  |    COMMAND SYNTAX         |  INTERPRETATION/RESPONSE  |\n"
							+"##  =========================================================\n"
							+"##  | DEPEND item1 item2 [item3 | item1 depends on item2    |\n"
							+"##  | ...]                      | (and item3 ...)           |\n"
							+"##  ---------------------------------------------------------\n"
							+"##  | INSTALL item1             | install item1 and those   |\n"
							+"##  |                           | on which it depends       |\n"
							+"##  ---------------------------------------------------------\n"
							+"##  | REMOVE item1              | remove item1, and those   |\n"
							+"##  |                           | on whch it depends, if    |\n"
							+"##  |                           | possible                  |\n"
							+"##  ---------------------------------------------------------\n"
							+"##  | LIST                      | list the names of all     |\n"
							+"##  |                           | currently-installed       |\n"
							+"##  |                           | components in             |\n"
							+"##  |                           | alphabetical order.       |\n"
							+"##  ---------------------------------------------------------\n";
	

	@Override
	public boolean ValidateCommand(String[] args) {
		return true;
	}

	@Override
	public void ProcessCommand(String[] args, PackageManager packageManager) {
		System.out.println(helpText);
	}

	@Override
	public String getCommand() {
		return helpText;
	}

}
