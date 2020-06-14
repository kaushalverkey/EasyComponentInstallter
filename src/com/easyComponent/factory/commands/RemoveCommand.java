package com.easyComponent.factory.commands;

import java.util.Iterator;
import java.util.List;

import com.easyComponent.manger.PackageManager;
import com.easyComponent.packages.InstalledPackage;
import com.easyComponent.packages.PackageObj;

public class RemoveCommand implements ICommand {

	@Override
	public boolean ValidateCommand(String[] args) {
		return args.length == 1;
	}

	@Override
	public void ProcessCommand(String[] args, PackageManager packageManager) {
		var packageName = args[0];

		InstalledPackage installedPackage = packageManager.GetInstalledPackage(packageName);

		if (installedPackage != null) {
			// verify that package is not a dependency
			List<InstalledPackage> parentDependents = packageManager
					.GetDependentInstalledPackages(installedPackage.packageObj.getName());

			if (parentDependents == null || parentDependents.size() == 0) {
				packageManager.RemoveInstalledPackage(installedPackage);

				// TODO: cleanup any unecessary dependencies
				for (PackageObj dependent : installedPackage.packageObj.getDependencies()) {
					var installedDependent = packageManager.GetInstalledPackage(dependent.getName());
					if (installedDependent != null && !installedDependent.isExplicit()) {
						packageManager.RemoveInstalledPackage(installedDependent);
					}
				}
			} else {
				// TODO: return error to the caller?
				System.out.println("Package is depended by: ");
				for (InstalledPackage packageObj : parentDependents) {
					System.out.println(", " + packageObj.getPackageObj().getName());
				}
			}

		} else {
			// TODO: return error to the caller?
			System.out.println(packageName +" is not installed" );

		}

	}

	@Override
	public String getCommand() {
		return "Usage: REMOVE item1";
	}

}
