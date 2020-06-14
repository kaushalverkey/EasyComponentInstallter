package com.easyComponent.packages;

public class InstalledPackage {

	public InstalledPackage(boolean explicit, PackageObj packageObj) {
		super();
		this.explicit = explicit;
		this.packageObj = packageObj;
	}


	// was this package explicitly installed?
	public boolean explicit;

	public boolean isExplicit() {
		return explicit;
	}

	public void setExplicit(boolean explicit) {
		this.explicit = explicit;
	}

	public PackageObj getPackageObj() {
		return packageObj;
	}

	public void setPackageObj(PackageObj packageObj) {
		this.packageObj = packageObj;
	}

	// reference to package object that was installed
	public PackageObj packageObj;

}
