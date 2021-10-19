<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart</title>
<link rel="stylesheet" href="css/bootstrap.min.css"/>
</head>
<body>
	<c:import url="home.jsp">
 		<c:param name="page" value="addCart"></c:param>
 	</c:import>
	<div class="container">
		<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
	 <c:forEach var="cart" items="${panier.cartproduit }" varStatus="indice">
	 	<c:forEach var="product" items="${cart.getProducts() }" varStatus="indice">
     		<div class="col">
	
				<div class="card shadow-sm">
           			<img src="img/${product.libelle}.jpg"style="width:300px;height:300px;">
		
            		<div class="card-body">
             		 <p class="card-text">${product.libelle}</p>
              			<p class="card-text">${product.description}</p>
             			 <p class="card-text">${product.prix}</p>
             			 <p class="card-text">${cart.quantite}</p>	 
            	<div class="d-flex justify-content-between align-items-center">
       		 </div>
       		 </div>
        </div>
        </div>
        </c:forEach>
      </c:forEach>
      </div>
      </div>
</body>
</html>