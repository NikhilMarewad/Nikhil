<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link href="./style/style.css" rel="Stylesheet" type="text/css"/>
	</head>
	<body> 
			
				<header >
						<span class="texts">truYum</span>
						<img class="imag" src="./images/truyum-logo-light.png"/> 
						<p id="txts1"><a id="txtcolor" href="ShowMenuItemListAdmin">Menu</a></p>
				</header>
				<br/>
			
				<h1 class="mytab">Menu Items</h1>
				<table class="mytab" >
				
					<tr>
					<th  class="tright spaces">Name</th>
						<th class="tgaps">Price</th>
						<th class="tgaps ">Active</th>
						<th class="tcenter">Date of Launch</th>
						<th class="tgaps tcenter ">Category</th>
						<th class="tgaps ">Free Delivery</th>
						<th class="tgaps ">Action</th>
					</tr>
				
				<c:forEach items="${menuItemList1}" var="menu">
					<tr>
					<td class="tright">${menu.name}</td>
						<td class="tcenter">Rs. ${menu.price}</td>
						<td class="tcenter">${menu.active?'Yes':'No'}</td>
						<td class="tcenter">${menu.datOfLaunch }</td>
						<td class="tcenter">${menu.category}</td>
						<td class="tcenter">${menu.freeDelivery?'Yes':'No'}</td>
						<td class="tcenter"><a href="ShowEditMenuItem?menuItemId=${menu.id}">Edit</a></td>
					</tr>
					</c:forEach>	
				</table>
			
				<br/>
				<footer>
				<h5>Copyright &copy 2019</h5>
				</footer>
	</body>
</html>