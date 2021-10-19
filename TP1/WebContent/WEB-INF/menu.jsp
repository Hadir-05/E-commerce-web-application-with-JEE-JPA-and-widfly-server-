<nav class="navbar navbar-expand-lg navbar-light bg-light">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <div class="container-fluid">
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
      <a class="navbar-brand" href="Servlet?page=ecom">E-commerce</a>
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
	  <a class="nav-link <c:if test='${param.page=="home"}'>active</c:if	>" aria-current="page" href="Servlet?page=home"> Acceuil</a>
       </li>
       <c:if test='${sessionScope.email =="admin@admin.com"}'>
        <li class="nav-item">
		  <a class="nav-link <c:if test='${param.page=="add"}'>active</c:if	>" aria-current="page" href="Servlet?page=add"> Ajouter produit</a>
        </li>
        <li class="nav-item">
          <a class="nav-link <c:if test='${param.page=="updateproduct"}'>active</c:if	>" aria-current="page" href="Servlet?page=updateproduct">Modifier un produit</a>
        </li>
        </c:if>
        <li class="nav-item">
          <a class="nav-link <c:if test='${param.page=="addCart"}'>active</c:if	>" aria-current="page" href="Servlet?page=addCart">Panier</a>
        </li>
        <li class="nav-item">
          <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true"> Disabled</a>
        </li>
      </ul>
      <form class="d-flex" action="Servlet" method="post">
        <input type="hidden" name="action" value="search">
        <input class="form-control me-2" name="search" type="search" placeholder="Search" aria-label="Search" > <a href="Servlet?page=searching"></a>
        <button class="btn btn-outline-success" type="submit" >Search</button>
      </form>
      <span>
      	Welcome ${sessionScope.email}
      	<a href="Servlet?page=deconnexion">Se déconnecter</a>
      </span>
    </div>
  </div>
</nav>