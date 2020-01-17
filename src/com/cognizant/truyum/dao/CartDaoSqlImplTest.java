package com.cognizant.truyum.dao;

import java.sql.SQLException;
import java.util.List;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImplTest {

	public static void main(String[] args) {
		try {
			testgetAllCartItems();
			testAddCartItem();
			testgetAllCartItems();
			testRemoveCartItem();
			testgetAllCartItems();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void testAddCartItem() throws Exception {
		CartDaoSqlImpl CartDao = new CartDaoSqlImpl();
		CartDao.addCartItem(1, 1);
		CartDao.addCartItem(2, 1);
		CartDao.addCartItem(3, 1);
		CartDao.addCartItem(4, 1);
	}
	public static void testgetAllCartItems() {
		CartDaoSqlImpl cartDao = new CartDaoSqlImpl();
		try {
			List<MenuItem> menuItemList = cartDao.getAllCartItems(1);
			System.out.println("-----AllCartItems-----");
			for (MenuItem x : menuItemList)
				System.out.println(x);
		} catch (Exception e) {

			System.out.println(e);
		}
	}
	public static void testRemoveCartItem() {
		CartDaoSqlImpl cartDao = new CartDaoSqlImpl();
		try {
			cartDao.removeCartItem(1, 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
