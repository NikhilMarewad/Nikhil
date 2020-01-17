package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImpl implements CartDao {

	@Override
	public void addCartItem(long userId, long menuItemId) {
		Connection con = ConnectionHandler.getConnection();
		String add = "insert into cart values(?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(add);
			ps.setLong(1, userId);
			ps.setLong(2, menuItemId);
		int rs =ps.executeUpdate();
		System.out.println(rs+ "record inserted");
			
		} catch (SQLException e) {

			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {

				System.out.println(e);
			}
		}

	}

	@Override
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException {
		Connection con = ConnectionHandler.getConnection();
		List<MenuItem>menuItem=new ArrayList<>();	
		Cart cart = new Cart();
		String show="select "
				+ "m.me_id,"
				+ "m.me_name,"
				+ "m.me_price,"
				+ "m.me_active,"
				+ "m.me_date_of_launch,"
				+ "m.me_category,"
				+ "m.me_free_delivery"
				+ " from menu_item m "
				+ "inner join cart c "
				+ "on m.me_id=c.ct_pr_id "
				+ "where c.ct_us_id=?";	
		try {
			PreparedStatement	ps = con.prepareStatement(show);
			ps.setLong(1, userId);
			ResultSet rs=ps.executeQuery(show);  
			while(rs.next()){  
				MenuItem menu=new MenuItem();
				menu.setId(rs.getInt("me_id"));
				menu.setName(rs.getString("me_name"));
				menu.setPrice(rs.getFloat("me_price"));
				menu.setActive(rs.getString("me_active").equalsIgnoreCase("Yes"));
				menu.setDatOfLaunch(rs.getDate("me_date_of_launch"));
				menu.setCategory(rs.getString("me_category"));
				menu.setFreeDelivery(rs.getString("me_free_delivery").equalsIgnoreCase("Yes"));
				cart.getMenuItemList().add(menu);		
			}  
		} catch (SQLException e) {
			System.out.println(e); 
		}  
		
		return cart.getMenuItemList();
	}

	@Override
	public void removeCartItem(long userId, long menuItemId) throws CartEmptyException {
		Connection con = ConnectionHandler.getConnection();
		String delete="delete from cart where ct_us_id=? and ct_pr_id=?";
		
		try {
			PreparedStatement ps=con.prepareStatement(delete);  
			ps.setLong(1,1);
			ps.setLong(2,2);
			int i=ps.executeUpdate();  
			System.out.println(i+" records deleted");  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		

	}

}
