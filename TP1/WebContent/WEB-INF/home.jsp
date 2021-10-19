<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <!-- CSRF Token -->
    <meta name="csrf-token" content="5uI2IrotgWQlKHnvOraMs1f7hDI5oeiE0wgojMwW">


    <!-- Scripts -->
    <script type="text/javascript" src="http://gc.kis.v2.scr.kaspersky-labs.com/8E28A4E2-1665-BD49-BB6A-00250C1BA8F1/main.js" charset="UTF-8"></script><script src="http://vampireecommerce.herokuapp.com/js/app.js"></script>

    <!-- Fonts -->
    <link rel="dns-prefetch" href="//fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css?family=Merienda One" rel="stylesheet">
    
    <!-- Styles -->
    <link href="/css/app.css" rel="stylesheet">
</head>
<body>
    <div id='app'>
        <nav class="navbar navbar-expand-lg fixed-top navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="Servlet?page=ecom">
            As'Shopping
        </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"  aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
    <li class="nav-item">
	  <a class="nav-link <c:if test='${param.page=="home"}'>active</c:if	>" aria-current="page" href="Servlet?page=home"> Shop</a>
       </li>
    <c:if test='${sessionScope.email =="admin@admin.com"}'>
        <li class="nav-item">
		  <a class="nav-link <c:if test='${param.page=="add"}'>active</c:if	>" aria-current="page" href="Servlet?page=add"> Add Product</a>
		  
        </li>
        </c:if>
        <c:if test='${sessionScope.email =="admin@admin.com"}'>
        <li class="nav-item">
          <a class="nav-link <c:if test='${param.page=="updateproduct"}'>active</c:if	>" aria-current="page" href="Servlet?page=updateproduct">Update Product</a>
        </li>
        </c:if>
      <c:if test='${sessionScope.email !="admin@admin.com"}'>  
    <li class="nav-item">
          <a class="nav-link <c:if test='${param.page=="addCart"}'>active</c:if	>" aria-current="page" href="Servlet?page=addCart">Cart</a>
        </li>
        </c:if>
</ul>
            
                <form class="d-flex" action="Servlet" method="post">
        <input type="hidden" name="action" value="search">
        <input class="form-control me-2" name="search" type="search" placeholder="Search" aria-label="Search" > <a href="Servlet?page=searching"></a>
        <button class="btn btn-outline-success" type="submit" >Search</button>
      </form>
            
            </div>

            <!-- Right Side Of Navbar -->
            <ul class="navbar-nav ml-auto">
                <!-- Authentication Links -->
                
                                            <li class="nav-item">
                                           
                            <a class="nav-link" href="Servlet?page=deconnexion">Log out</a>
                        </li>
                                                </ul>
        </div>
    </div>
</nav>
<div id="cont">
    <ul style="height:4em">

    </ul>
</div>        
<div class="" style="margin-top: -1.3em">
                                    
<!-- start hero section -->
<!-- start page content -->
   
</body>
</html>
