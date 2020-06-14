package com.easyComponent.factory.commands;

import com.easyComponent.manger.PackageManager;
import com.easyComponent.packages.InstalledPackage;
import com.easyComponent.packages.PackageObj;

public class ListCommand implements ICommand {

	@Override
	public boolean ValidateCommand(String[] args) {
		return args == null || args.length == 0;
	}

	@Override
	public void ProcessCommand(String[] args, PackageManager packageManager) {
		for (InstalledPackage installedPackage : packageManager.GetAllInstalledPackages()) {
			System.out.println("Package: " + installedPackage.getPackageObj().getName() + ", "
					+ (installedPackage.isExplicit() ? "*" : ""));
			System.out.println("- Dependencies: ");
			for (PackageObj packageObj : installedPackage.getPackageObj().getDependencies()) {
				System.out.println(", " + packageObj.getName());
			}
		}
	}

	@Override
	public String getCommand() {
		return "LIST";
	}

}
