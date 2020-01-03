package com.cognizant.truyum.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.truyum.dao.CartDaoCollectionImpl;
import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;

/**
 * Servlet implementation class ShowCartServlet
 */
@WebServlet({ "/ShowCartServlet", "/ShowCart" })
public class ShowCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ShowCartServlet() {
    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CartDaoCollectionImpl cartDao=new CartDaoCollectionImpl();
		
		double total=0;
		try {
			List<MenuItem> menuItemList = cartDao.getAllCartItems(1);
			for(MenuItem menuitem:menuItemList)
			{
				total+=menuitem.getPrice();
			}
			request.setAttribute("menuItemList1", menuItemList);
			request.setAttribute("total",total);
			RequestDispatcher rd=request.getRequestDispatcher("cart.jsp");
			rd.forward(request, response);
		} catch (CartEmptyException ec) {
			RequestDispatcher rd=request.getRequestDispatcher("cart-empty.jsp");
			rd.forward(request, response);
		}
			
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
