<%@page import="com.midvi.entities.Products"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>afficher</title>
<link rel="stylesheet" href="css/bootstrap.min.css"/>
<link rel="stylesheet" href="css/app.css"/>

</head>
<body>
	
 	<c:import url="home.jsp">
 		<c:param name="page" value="detail"></c:param>
 	</c:import>
<!-- <div class="" style="margin-top: 2em"> -->
                                    
<!-- <div class="container"> -->

<!--     <div class="row" style="margin-bottom: 3em"> -->
<!--         <div class="col-md-4 product-image"> -->
<!--             <div> -->
<!--             </div> -->
<!--             <div class="image-thumbnails"> -->
<%--             <img src="img/${modelD.produit.libelle}.jpg"style="width:300px;height:300px;"> --%>
<!--                                                 </div> -->
<!--         </div> -->
<!--         <div class="product-details col-md-5 col-md-4"> -->
<%--             <h2 class="lead" style="margin-top:1em"><strong>${modelD.produit.libelle}</strong></h2> --%>
<!--             <span class="badge badge-success" style="font-size: 1em">In Stock</span> -->
<%--             <p class="light-text">${modelD.produit.description }</p> --%>
<%--             <h3 class="lead">${modelD.produit.prix }</h3> --%>
<!--             <p class="light-text"></p> -->
<!--                     </div> -->
<!--     </div> -->
<!--     <hr> -->
<!-- </div> -->
<!-- </div> -->
<div class="" style="margin-top: 2em">
                                    
<div class="container">

    <div class="row" style="margin-bottom: 3em">
        <div class="col-md-4 product-image">
            <div>
                <img src="img/${modelD.produit.libelle}.jpg" width="100%" height="100%" id="current-image">
            </div>
            
        </div>
        <div class="product-details col-md-5 offset-md-1">
        <br><br><br>
            <h2 class="lead" style="margin-top:1em">${modelD.produit.libelle}</h2>
            <span class="badge badge-success" style="font-size: 1em">In Stock</span>
            <h3 class="lead">${modelD.produit.prix } Dhs</h3>
            <p class="light-text">${modelD.produit.description }</p>
                    </div>
    </div>
</body>
</html>