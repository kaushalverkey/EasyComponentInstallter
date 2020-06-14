package com.easyComponent.factory.commands;

import com.easyComponent.manger.PackageManager;

public interface ICommand {

	boolean ValidateCommand(String[] args);

	void ProcessCommand(String[] args, PackageManager packageManager);

	String getCommand();
}
