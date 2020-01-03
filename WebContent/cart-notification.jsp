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
			
				<h1 class="mytab">Cart</h1>
				
				<h3 class="col mytab"></h3>
				
				<table class="mytab">
				
					<tr>
						<th class="tright spaces ">Name</th>
						<th class="tcenter">Free Delivery</th>
						<th class="tgap tprice">Price</th>
						<th></th>
						
					</tr>
					
					<c:forEach items="${menuitem}" var="menu">
					<tr>
						<td class="tright">${menu.name}</td>
						
					
  
						<td class="tcenter">${menu.freeDelivery?'Yes':'No'}</td>
						<td class="tprice">Rs.${menu.price}</td>
						<td ><a href="RemoveCart?menuItemId=${menu.id}">Delete</a></td>
					</tr>
					</c:forEach>
					
				</table >

				</br>
				<footer>
					<h5>Copyright &copy 2019</h5>
				</footer>
	</body>
</html>