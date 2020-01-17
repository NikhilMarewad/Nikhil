package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImpl implements MenuItemDao {

	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		Connection con = ConnectionHandler.getConnection();
		List<MenuItem> menuItemList = new ArrayList<>();
		try {
			String query = "select * from menu_item";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery(query);
			while (rs.next()) {
				MenuItem menu = new MenuItem();
				menu.setId(rs.getInt("me_id"));
				menu.setName(rs.getString("me_name"));
				menu.setPrice(rs.getFloat("me_price"));
				menu.setActive(rs.getString("me_active").equalsIgnoreCase("Yes"));
				menu.setDatOfLaunch(rs.getDate("me_date_of_launch"));
				menu.setCategory(rs.getString("me_category"));
				menu.setFreeDelivery(rs.getString("me_free_delivery").equalsIgnoreCase("Yes"));
				menuItemList.add(menu);
			}
			rs.close();
			ps.close();
		} catch (SQLException sqle) {
			System.out.println(sqle);
		} finally {
			try {
				con.close();
			} catch (SQLException sqle) {

				System.out.println(sqle);
			}
		}
		return menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {

		Connection con = ConnectionHandler.getConnection();
		List<MenuItem> menuItemList1 = new ArrayList<>();

	       try {

               String sql = "select me_id, me_name, me_price,me_active,me_date_of_launch, me_category, me_free_delivery from menu_item where me_active = ? and me_date_of_launch <?";
               PreparedStatement ps = con.prepareStatement(sql);
               ps.setString(1, "Yes");
               ps.setDate(2, java.sql.Date.valueOf(java.time.LocalDate.now()));
               ResultSet rs = ps.executeQuery();

               while (rs.next()) {
                     MenuItem menu = new MenuItem();
                     menu.setId(rs.getInt("me_id"));
                     menu.setName(rs.getString("me_name"));
                     menu.setPrice(rs.getFloat("me_price"));
                     menu.setActive(rs.getString("me_active").equalsIgnoreCase("Yes"));
                     menu.setDatOfLaunch(rs.getDate("me_date_of_launch"));
                     menu.setCategory(rs.getString("me_category"));
                     menu.setFreeDelivery(rs.getString("me_free_delivery").equalsIgnoreCase("Yes"));
                     menuItemList1.add(menu);
               }


		} catch (SQLException sqle) {
			System.out.println(sqle);
		} finally {
			try {
				con.close();
			} catch (SQLException sqle) {

				System.out.println(sqle);
			}
		}
		return menuItemList1;
	}

	@Override
	public void ModifyItem(MenuItem menuItem) {
		
	Connection con = ConnectionHandler.getConnection();
try {
	
	String query2 = "update menu_item set me_name=?,me_price=?,me_active=?,me_date_of_launch=?, me_category=?,me_free_delivery=? where me_id=?";
	PreparedStatement ps = con.prepareStatement(query2);
	ps.setString(1,menuItem.getName());
	ps.setDouble(2,menuItem.getPrice());
	ps.setString(3,menuItem.isActive()?"Yes":"No");
	ps.setDate(4,new java.sql.Date(menuItem.getDatOfLaunch().getTime()));
	ps.setString(5,menuItem.getCategory());
    ps.setString(6,menuItem.isFreeDelivery()?"Yes":"No");
	ps.setLong(7,menuItem.getId());
	
  int output= ps.executeUpdate();
  System.out.println(output);
	
}
catch(SQLException sqle) {
	System.out.println(sqle);
}finally {
	try {
		con.close();
	} catch (SQLException sqle) {

		System.out.println(sqle);
	}
}
	}

	@Override
	public MenuItem getMenuItem(long menuId) {
		Connection con = ConnectionHandler.getConnection();
		MenuItem menu = new MenuItem();
		String query3="select me_id, me_name, me_price,me_active,me_date_of_launch, me_category, me_free_delivery from menu_item where me_id=? ";
		try {
			PreparedStatement ps = con.prepareStatement(query3);
			ps.setLong(1, menuId);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				menu.setId(rs.getInt("me_id"));
				menu.setName(rs.getString("me_name"));
				menu.setPrice(rs.getFloat("me_price"));
				menu.setActive(rs.getString("me_active").equalsIgnoreCase("Yes"));
				menu.setDatOfLaunch(rs.getDate("me_date_of_launch"));
				menu.setCategory(rs.getString("me_category"));
				menu.setFreeDelivery(rs.getString("me_free_delivery").equalsIgnoreCase("Yes"));
				
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		 
		return menu ;
		
		
	}

}
