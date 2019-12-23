package com.cognizant.truyum.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MenuItem {
	private long id;
	private String name;
	private float price;
	private boolean active;
	private Date datOfLaunch;
	private String category;
	private boolean freeDelivery;

	public MenuItem(long id, String name, float price, boolean active, Date datOfLaunch, String category,
			boolean freeDelivery) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.active = active;
		this.datOfLaunch = datOfLaunch;
		this.category = category;
		this.freeDelivery = freeDelivery;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getDatOfLaunch() {
		return datOfLaunch;
	}

	public void setDatOfLaunch(Date datOfLaunch) {
		this.datOfLaunch = datOfLaunch;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean isFreeDelivery() {
		return freeDelivery;
	}

	public void setFreeDelivery(boolean freeDelivery) {
		this.freeDelivery = freeDelivery;
	}

	public double getPrice() {

		return price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MenuItem other = (MenuItem) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String detials = String.format("%-20s Rs. %7.2f %-15s %-10s %-10s %-5s Edit", name, price,
				active ? "Yes" : "No", sdf.format(datOfLaunch), category, freeDelivery ? "Yes" : "No");
		return detials;
	}

}
