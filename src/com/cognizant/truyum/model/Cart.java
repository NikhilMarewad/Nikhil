package com.cognizant.truyum.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<MenuItem> menuItemList;
	private double total;

	public List<MenuItem> getMenuItemList() {
		return menuItemList;
	}

	public void setMenuItemList(List<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}

	public Cart() {
		super();
		menuItemList = new ArrayList<>();
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

}
