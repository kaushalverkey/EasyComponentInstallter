package com.easyComponent.manger;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.easyComponent.factory.CommandFactory;
import com.easyComponent.packages.InstalledPackage;
import com.easyComponent.packages.PackageObj;

public class PackageManager {

	private Map<String, InstalledPackage> installedPackages;
	private Map<String, PackageObj> configuredPackages;
	private Map<String, List<InstalledPackage>> reverseDependencies;

	public PackageManager() {
		installedPackages = new HashMap<String, InstalledPackage>();
		configuredPackages = new HashMap<String, PackageObj>();
		reverseDependencies = new HashMap<String, List<InstalledPackage>>();

	}

	public PackageObj GetPackage(String packageName) {
		return configuredPackages.get(packageName);
	}

	public Collection<PackageObj> GetAllConfiguredPackages() {
		return configuredPackages.values();
	}

	public Collection<InstalledPackage> GetAllInstalledPackages() {
		return installedPackages.values();
	}

	public InstalledPackage GetInstalledPackage(String packageName) {
		return installedPackages.get(packageName);
	}

	public List<InstalledPackage> GetDependentInstalledPackages(String packageName) {
		return reverseDependencies.get(packageName);
	}

	public void InstallPackage(PackageObj packageObj, boolean isExplicit) {
		InstalledPackage installedPackage = GetInstalledPackage(packageObj.getName());

		if (installedPackage == null) {
			System.out.println(CommandFactory.COMMAND_INSTALL + packageObj.getName());
			installedPackage = new InstalledPackage(isExplicit, packageObj);
			installedPackages.put(packageObj.getName(), installedPackage);

		}
		// Only if this is an explicit installation, make sure the package is marked as
		// such
		else if (isExplicit) {
			System.out.println(packageObj.getName() +"is still needed" );
			installedPackage.setExplicit(true);
		}

	}

	public void RemoveInstalledPackage(InstalledPackage installedPackage) {

		installedPackages.remove(installedPackage.packageObj.getName());
		System.out.println(CommandFactory.COMMAND_REMOVE + installedPackage.packageObj.getName());

	}

	public void ConfigurePackage(PackageObj packageObj) {
		if (!configuredPackages.containsKey(packageObj.getName())) {
			System.out.println("Installing " + packageObj.getName());
			configuredPackages.put(packageObj.getName(), packageObj);
		} else {
			System.out.println(packageObj.getName() +" is already installed");
		}

		for (PackageObj dependent : packageObj.getDependencies()) {
			ConfigurePackage(dependent);
		}

	}

}
