<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link href="./style/style.css" rel="Stylesheet" type="text/css"/>
		<script src="./js/script.js" type="text/javascript"></script>
	</head>
	<body> 
				<header >
					<span class="texts">truYum</span>
					<img class="imag" src="./images/truyum-logo-light.png"/> 
					<p id="txts2"><a id="txtcolor" href="ShowMenuItemListAdmin">Menu</a></p>
				</header>
				<br/>
				
				<h3 class="myform">Edit Menu Item</h3>
				<form class="myform" action="EditMenuItem?MenuItemId=${menuItem.id}"  name="myForm" onsubmit="return validateForm()" method="Post">
				    <table>
				
					<tr>
						<td>Name:</td>
					</tr>

                    <tr>					
						<td colspan="4">
							<input type="text" name="name" class="txtname" value="${menuItem.name}" />
						</td>
					</tr>
					
					<tr>
						<td>Price(Rs.)</td>
						<td>Active</td>
						<td>Date of Launch</td>
						<td>Category</td>
					</tr>
					
					<tr>
						<td>
							<input type="number" name="price" value="${menuItem.price}" class="txtno"/></td>
						<td>
							<label for="rdo1" class="radios">
							<input type="radio" checked name="active"id="rd1" value="${menuItem.active?'Yes':'No'}" <c:if test="${menuItem.active eq 'Yes'}"> </c:if>/>Yes
							<input type="radio"  name="active" id="rd1" value="${menuItem.active?'Yes':'No'}" <c:if test="${menuItem.active eq 'No'}"> </c:if>"/>No
							</label>
						</td>
						<td>
						
							<input type="text" name="datOfLaunch" class="txtdate" value="<fmt:formatDate value='${menuItem.datOfLaunch}' pattern='dd/MM/yyyy'></fmt:formatDate>" />
						</td>
						<td>
							<select class="tabsize name="category">
							<option value="${menuItem.category}">Main Course</option>
							<option  value="${menuItem.category}">Starters</option>
							<option  value="${menuItem.category}">Dessert</option>
							<option  value="${menuItem.category}">Drinks</option>
							</select>
						</td>
					</tr>
					
					<tr>
						<td>
						    <label for="chk1">
							<input type="checkbox" name="freeDelivery" value="${menuItem.freeDelivery?'Yes':'No'}" id="chk1" checked="true"/>Free Delivery
							</label>
						</td>
					</tr>
					
					<tr>
						<td>
						 <input type="submit" value="Save" class="btn"/>
						</td>		
					</tr>
				
					</table>
				</form>
				<br/>
				<footer class="foote">
						<h5>Copyright &copy 2019</h5>
				</footer>
			
	</body>
</html>