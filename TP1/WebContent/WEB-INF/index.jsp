<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<c:import url="home.jsp">
	<c:param name="page" value="add"></c:param>
</c:import>
<div class="container col-md-6">
	<h2 style="text-align:center">Ajouter Produit</h2>
	<c:if test="${model.msg=='add' }">
		<div style="text-align:center" class="alert-info">Produit Ajouté</div>
	</c:if>
	<div class="panel panel-primary">
		<div class="panel-body">
		<form action="Servlet" method="post">
		<br><br>
		<div class="form-group">
			<label class="control-label">Libellé:</label>
			<input type="text" name="libelle" class="form-control" placeholder="libellé du produit"><br>
		</div>
		<div class="form-group">
			<label class="control-label">Categorie:</label>
			<input type="text" name="cat" class="form-control" placeholder="Categorie"><br>
		</div>
		<div class="form-group">
			<label class="control-label">Description:</label>
			<input type="text" name="description" class="form-control" placeholder="description du produit"><br>
		</div>
		<div class="form-group">
			<label class="control-label">Quantité:</label>
			<input type="number" name="quantite" class="form-control" placeholder="quantite du produit"><br>
		</div>
		<div class="form-group">
			<label class="control-label">Prix:</label>
			<input type="number" name="prix" class="form-control" placeholder="prix du produit"><br>
		</div>
		 <input type="hidden" name="action" value="add">
		<input type="submit" value="Ajouter" class="btn btn-primary" ><br>
	    </form>
	</div>
	</div>
</div>
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