package com.easyComponent.factory.commands;

import java.util.ArrayList;
import java.util.List;

import com.easyComponent.manger.PackageManager;
import com.easyComponent.packages.PackageObj;

public class DependCommand implements ICommand {

	@Override
	public boolean ValidateCommand(String[] args) {
		return args.length > 0;
	}

	@Override
	public void ProcessCommand(String[] args, PackageManager packageManager) {
		String rootItemName = args[0];

		// build the dependencies
		List<PackageObj> dependencies = new ArrayList<PackageObj>();

		// start at index 1 to skip the root
		for (int i = 1; i < args.length; i++) {
			dependencies.add(PackageObj.CreatePackage(args[i], null));
		}

		PackageObj rootPackage = PackageObj.CreatePackage(rootItemName, dependencies);

		packageManager.ConfigurePackage(rootPackage);

	}

	@Override
	public String getCommand() {
		return "Usage: DEPEND item1 item2 [item3]";
	}

}
