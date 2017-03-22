
<%-- 
    Document   : addProject
    Created on : Jun 18, 2016, 11:22:02 PM
    Author     : bibekshakya
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  
         pageEncoding="UTF-8"%>  
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>  
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" media="all" href="<c:url value="/resources/css/cssLayout.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/bootstrap-3.1.1/css/bootstrap.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/css/jquery-ui-1.10.4.custom.css"/>">
        
        <link href="<c:url value="resources/css/bootstrap-responsive.css"/>"
		rel="stylesheet" />
        <link href="<c:url value="resources/css/charisma-app.css"/>"
		rel="stylesheet" />
        <link href="<c:url value="resources/css/jquery-ui-1.8.21.custom.css"/>"
		rel="stylesheet" />
        <link href="<c:url value="resources/css/uniform.default.css"/>"
		rel='stylesheet' />
        <link href="<c:url value="resources/css/jquery.cleditor.css"/>"
		rel='stylesheet' />
        <link href="<c:url value="resources/css/jquery.iphone.toggle.css"/>"
		rel='stylesheet' />
        <link href="<c:url value="resources/css/opa-icons.css"/>" rel='stylesheet' />
        <link href="<c:url value="resources/css/uploadify.css"/>" rel='stylesheet' />
	
	<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
	<!--[if lt IE 9]>
          <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

	<!-- The fav icon -->
        <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/img/favicon.ico" />
        
        
        
        
        
        <script src="<c:url value="/resources/js/jquery-1.11.1.js"/>"></script>
        <script src="<c:url value="/resources/js/jquery-ui-1.10.4.custom.js"/>"></script>
        <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
        

        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
    </head>
    <body>
        <div class="navbar">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".top-nav.nav-collapse,.sidebar-nav.nav-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
				</a>
				<!-- user dropdown starts -->
				<div class="btn-group pull-right">
					<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
						<i class="icon-user"></i><span class="hidden-phone">
                                                </span> <span class="glyphicon glyphicon-log-out" style="color: white;"> Logout</span>
					</a>
					<ul class="dropdown-menu">

						<li><a href="/faces/preference.xhtml">
								Preference </a></li>
						<li class="divider"></li>
						
                                                <security:authorize access="! isAuthenticated()">
                                                    <li><a href="<spring:url value="/logout"/>">Login</a></li>

                                                </security:authorize>
                                                    <security:authorize access="isAuthenticated()">
                                                        <li><a href="<spring:url value="/logout"/>">Logout</a></li>
                                                    </security:authorize>
						

					</ul>
				</div>
			</div>
		</div>
        </div>

