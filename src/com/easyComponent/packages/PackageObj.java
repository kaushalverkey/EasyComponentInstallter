package com.easyComponent.packages;

import java.util.ArrayList;
import java.util.List;

public class PackageObj {

	public PackageObj(String name, List<PackageObj> dependencies) {
		super();
		this.name = name;
		if (dependencies!= null && dependencies.size() > 0) {
			this.dependencies = dependencies;
		} else {
			this.dependencies = (new ArrayList<PackageObj>());
		}
	}

	public String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<PackageObj> dependencies;

	public List<PackageObj> getDependencies() {
		return dependencies;
	}

	public void setDependencies(List<PackageObj> dependencies) {
		this.dependencies = dependencies;
	}

	public static PackageObj CreatePackage(String name, List<PackageObj> dependencies) {
		return new PackageObj(name, dependencies);
	}
}
