<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link href="./style/style.css" rel="Stylesheet" type="text/css"/>
	</head>
	<body> 
			
				<header ><span class="texts">truYum</span>
						<img class="imag" src="./images/truyum-logo-light.png"/> 
						<p id="txts1"><a id="txtcolor" href="ShowCart">Cart</a></p><p id="txts2"><a id="txtcolor" href="ShowMenuItemListCustomer">Menu</a></p>
				</header>
				<br/>
			
				<h1 class="mytab">Menu Items</h1>
				
				<h3 class="col myitm">Items added to Cart Successfully</h3>
				
				<table class="mytab">
				
					<tr>
						<th class="tright spaces ">Name</th>
						<th class="tcenter">Free Delivery</th>
						<th class="tgap tprice">Price</th>
						<th class="tgap tcat">Category</th>
						<th class="tgap tcenter">Action</th>
					</tr>
					
					<c:forEach items="${menuItemList1}" var="menu">
					<tr>
						<td class="tright">${menu.name}</td>
						<td class="tcenter">${menu.freeDelivery?'Yes':'No'}</td>
						<td class="tprice">Rs. ${menu.price}</td>
						<td class="tcat">${menu.category}</td>
						<td class="tcenter"><a href="AddToCart?menuItemId=${menu.id}">Add to Cart</a></td>
					</tr>
					</c:forEach>
					
				
				</table >

				</br>
				<footer>
					<h5>Copyright &copy 2019</h5>
				</footer>
	</body>
</html>