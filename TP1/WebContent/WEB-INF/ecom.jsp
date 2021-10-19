
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Hello Kiddie is a free, open source Bootstrap 4 theme" />
    <meta name="generator" content="Themestr.app">
    <link rel="icon" href="http://themes.guide/favicon.ico" type="image/x-icon" />
    <link rel="shortcut icon" href="http://themes.guide/favicon.ico" type="image/x-icon" />
    <meta property="og:image" name="twitter:image" content="http://bootstrap.themes.guide/assets/ss_hello_kiddie.png">
    <meta name="twitter:card" content="summary_large_image">
    <meta name="twitter:site" content="@ThemesGuide">
    <meta name="twitter:creator" content="@ThemesGuide">
    <meta name="twitter:title" content="Open-source Bootstrap 4 Themes">
    <meta name="twitter:description" content="Download Hello Kiddie - free, open source Bootstrap 4 theme by Themes.guide">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/3.0.0/css/ionicons.css" rel="stylesheet">
    <link href="css/theme.css" rel="stylesheet">
    <link href="./template.css" rel="stylesheet">
</head>

  <style>
      header {
          background-image: url('img/bground.jpg');
          background-repeat: no-repeat;
          background-size: cover;
          background-position: center top;
         
      }
  </style>
 	

<header class="bg-primary">
        <div class="container h-100">
            <div class="row h-100">
                <div class="col-12">
                    <div class="text-center m-0 vh-100 d-flex flex-column justify-content-center text-dark">
                        <h1 class="display-4">Hello ${sessionScope.email}</h1>
                        <p class="lead">Stay at home and shop online.</p>
                       
                    </div>
                </div>
            </div>
        </div>
    </header>
    <body><c:import url="home.jsp">
 	</c:import>
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