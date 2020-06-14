package com.easyComponent.factory.commands;

import com.easyComponent.manger.PackageManager;
import com.easyComponent.packages.PackageObj;

public class InstallCommand implements ICommand {

	@Override
	public boolean ValidateCommand(String[] args) {
		return args.length == 1;
	}

	@Override
	public void ProcessCommand(String[] args, PackageManager packageManager) {
		String packageName = args[0];

		// validate that the package exists in the repository
		PackageObj packageObj = packageManager.GetPackage(packageName);

		if (packageObj != null) {
			// TODO: loop through dependencies

			for (PackageObj dependent : packageObj.getDependencies()) {
				packageManager.InstallPackage(dependent, false);
			}

			packageManager.InstallPackage(packageObj, true);
		} else {
			// TODO: return error to the caller?
			System.out.println("Package is not configured: " + packageName);
		}

	}

	@Override
	public String getCommand() {
		return "Usage: DEPEND item1 item2 [item3]";
	}

}
