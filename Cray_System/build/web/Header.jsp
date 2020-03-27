<%-- 
    Document   : Header
    Created on : Aug 11, 2019, 8:14:22 AM
    Author     : VitaKing
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="craysystems.QueryDao"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Cray Systems</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
      crossorigin="anonymous"
    />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="https://kit.fontawesome.com/7fd21bcdb3.js"></script>
    
    <style>
        @media only screen and (max-width:500px) {
            /* For mobile phones: */
            #textarea{
                resize: none;
            }
        }
    </style>
</head>

<body>
    <%
            //allow access only if session exists
            if(session.getAttribute("currentSessionUser") == null){
    
            response.sendRedirect("login_page.jsp");
            }
%>
  <div class="container">
    <!-- Static navbar -->
    <nav class="navbar navbar-expand-sm bg-light navbar-light">
      <div class="container-fluid">
          <div class="navbar-header">
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
                <span class="navbar-toggler-icon"></span>
                </button>
              <a class="navbar-brand" href="#">Cray systems</a>
          </div>
        <div id="collapsibleNavbar" class="collapse navbar-collapse">
          
          <ul class="navbar-nav">
            <li class="nav-item active" id="home"><a class="nav-link" href="query.jsp">Query</a></li>
<!--            <li class="nav-item" id="write"><a class="nav-link" href="#">Write</a></li>
            <li class="nav-item" id="read"><a class="nav-link" href="#">Read</a></li>
            <li class="nav-item" id="manage"><a class="nav-link" href="#">Manage</a></li>-->
          </ul>
          
        </div><!--/.nav-collapse -->
        <ul class="navbar-nav justify-content-end">
            <li class="nav-item"><a class="nav-link " href="#"><i class="far fa-user-circle"></i>${currentSessionUser.getFirstName()}</a></li>
            <li class="nav-item"><a  class="nav-link" href="logout"> Logout</a></li>
          </ul>
      </div><!--/.container-fluid -->
    </nav>
            