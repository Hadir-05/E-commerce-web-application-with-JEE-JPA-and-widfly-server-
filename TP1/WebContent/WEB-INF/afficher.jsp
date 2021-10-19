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
</head>
<body>
	
 	<c:import url="home.jsp">
 		<c:param name="page" value="home"></c:param>
 	</c:import>
	<div class="container">
	
	 <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
	 <c:forEach var="produit" items="${model.productlist }" varStatus="indice">
     	<div class="col">
	
		<div class="card shadow-sm">
           <img src="img/${produit.libelle}.jpg"style="width:300px;height:300px;">
            <div class="card-body">
              <p class="card-text">${produit.libelle}</p>
              
              <p class="card-text">${produit.prix} Dhs</p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                  
                  <button type="button" class="btn btn-primary btn-sm mr-2" data-bs-toggle="modal" data-bs-target="#staticBackdrop${produit.id }">
  							Add card
					</button>
                   <a class="btn btn-primary btn-sm" href="<c:url value="Servlet?page=detail&id=${produit.id}"/>">More details</a>
                   <!--  	               
                   <c:if test='${sessionScope.email =="admin@admin.com"}'>
                   <a class="btn btn-primary btn-sm" href="<c:url value="Servlet?page=remove&id=${produit.id}"/>">Remove</a>
                   </c:if>
                   -->
                </div>

              </div>
            </div>
          </div>
		
		<!-- Modal -->
<div class="modal fade" id="staticBackdrop${produit.id }" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">Quantite du Produit</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
       <form action="Servlet" method="get">
        <input type="number" name="qtt" min="1" class="form-control form-control-sm">
        <input type="number" name="id" value="${produit.id }" hidden="hidden">
        <input type="number" name="id1" value="${user.id }" hidden="hidden">
        <input type="text" name="page" value="addCart" hidden="hidden">
        <button type="submit" class="btn btn-primary mt-4">Add</button>
        </form>
      </div>
       
    </div>
  </div>
</div>
	 </div>
	  </c:forEach>
	  
	 </div>
	 </div>
	 <script type="text/javascript" src="js/bootstrap.js"></script>
<br><br>
<!-- Footer -->
<footer class="bg-dark text-center text-white">
  <!-- Grid container -->
  <div class="container p-4">

    <!-- Section: Form -->
    <section class="">
      <form action="">
        <!--Grid row-->
        <div class="row d-flex justify-content-center">
          <!--Grid column-->
          <div class="col-auto">
            <p class="pt-2">
              <strong>Sign up for our newsletter</strong>
            </p>
          </div>
          <!--Grid column-->

          <!--Grid column-->
          <div class="col-md-5 col-12">
            <!-- Email input -->
            <div class="form-outline form-white mb-4">
              <input type="email" id="form5Example2" class="form-control" />
              <label class="form-label" for="form5Example2">Email address</label>
            </div>
          </div>
          <!--Grid column-->

          <!--Grid column-->
          <div class="col-auto">
            <!-- Submit button -->
            <button type="submit" class="btn btn-outline-light mb-4">
              Subscribe
            </button>
          </div>
          <!--Grid column-->
        </div>
        <!--Grid row-->
      </form>
    </section>
    <!-- Section: Form -->

    <!-- Section: Text -->
    <section class="mb-4">
      <p>
        Shop What you want Anywhere and Anytime!
        You are Welcome!
      </p>
    </section>
    <!-- Section: Text -->
  <!-- Grid container -->

  <!-- Copyright -->
  <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
    © 2021 Copyright:
    <a class="text-white" href="https://mdbootstrap.com/">As'Shopping.com</a>
  </div>
  <!-- Copyright -->
</footer>
<!-- Footer -->
</body>
</html>