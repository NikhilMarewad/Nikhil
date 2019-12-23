package com.cognizant.truyum.dao;

import java.util.List;
import java.text.ParseException;

import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImplTest {

	public static void main(String... arg) throws ParseException {
		try {
			testgetAllCartItems();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		testAddCartItem();
		testgetAllCartItems();
		testRemoveCartItem();
		testgetAllCartItems();

	}

	private static void testAddCartItem() {
		CartDaoCollectionImpl CartDao = new CartDaoCollectionImpl();
		CartDao.addCartItem(1, 2);
		CartDao.addCartItem(1, 3);
		CartDao.addCartItem(1, 4);
		CartDao.addCartItem(1, 5);
		List<MenuItem> menuItemListCustomer = CartDao.getAllCartItems(1);
		System.out.println("-----AddCartItem-----");
		for (MenuItem x : menuItemListCustomer)
			System.out.println(x);

	}

	private static void testgetAllCartItems() {
		CartDaoCollectionImpl CartDao = new CartDaoCollectionImpl();
		CartDao.getAllCartItems(1);
		List<MenuItem> menuItemListCustomer = CartDao.getAllCartItems(1);
		System.out.println("-----AllCartItems-----");
		for (MenuItem x : menuItemListCustomer)
			System.out.println(x);
	}

	private static void testRemoveCartItem() {
		CartDaoCollectionImpl CartDao = new CartDaoCollectionImpl();
		CartDao.removeCartItem(1, 2);

		List<MenuItem> menuItemListCustomer = CartDao.getAllCartItems(1);
		System.out.println("-----RemoveCartItem------");
		for (MenuItem x : menuItemListCustomer)
			System.out.println(x);

	}

}
