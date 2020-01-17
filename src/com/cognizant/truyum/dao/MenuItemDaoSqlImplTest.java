package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImplTest {

	public static void main(String[] args) {
		try {
			System.out.println("*-----Admin Detials-----*");
			testGetMenuItemListAdmin();
			System.out.println("*-----Customer Detials-----*");
			testGetMenuItemListCustomer();
			System.out.println("*-----Modified Detials-----*");
			testModifyMenuItem();
			testGetMenuItemListAdmin();
		}catch(Exception e)
		{
			System.out.println(e);
		}
		

	}

	
	private static void testGetMenuItemListAdmin() {
		MenuItemDao MenuitemDao = new MenuItemDaoSqlImpl();
		MenuitemDao.getMenuItemListAdmin();
		List<MenuItem> menuItemList = MenuitemDao.getMenuItemListAdmin();
		for (MenuItem x : menuItemList) {
			System.out.println(x);
		
	}

}
	
	private static void testGetMenuItemListCustomer() {
		MenuItemDao menuItemDao1 = new MenuItemDaoSqlImpl();
		menuItemDao1.getMenuItemListCustomer();
		List<MenuItem> menuItemList1 =menuItemDao1 .getMenuItemListCustomer();
		for (MenuItem x : menuItemList1) {
			System.out.println(x);
		}
		
	}
	
	private static void testModifyMenuItem() throws ParseException {
		MenuItem menuItem=new MenuItem(1, "French Fries", 100.0f, true, DateUtil.convertToDate("28/07/2017"),"Starters", true);
		MenuItemDao MenuitemDao = new MenuItemDaoSqlImpl();
		MenuitemDao.ModifyItem(menuItem);
		
	}

}
