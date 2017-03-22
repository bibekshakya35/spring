
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

        <meta name="viewport" content="width=device-width, initial-scale=1">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" media="all" href="<c:url value="/resources/css/cssLayout.css"/>">
        <link rel="stylesheet" media="all" href="<c:url value="/resources/css/allpage.css"/>">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
          <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

        <!-- The fav icon -->
        <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/img/favicon.ico" />
        <link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.9/themes/base/jquery-ui.css" type="text/css" media="all" />
    </head> 
    <body>
        <nav class="navbar navbar-inverse" style="background-color: #020203;">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#" style="text-align: center;padding-top: 20px;font-size: 22px;font-weight: bold;color: white">E-Health</a>
                </div>
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#" style="text-align: center;padding-top: 20px;font-size: 16px;font-weight: bold;color: white"></a></li>
                    <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#" style="text-align: center;padding-top: 20px;font-size: 16px;font-weight: bold;color: white">Page 1 <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="#" style="text-align: center;padding-top: 10px;font-size: 16px;font-weight: bold;">Page 1-1</a></li>
                            <li><a href="#" style="text-align: center;padding-top: 10px;font-size: 16px;font-weight: bold;">Page 1-2</a></li>
                            <li><a href="#" style="text-align: center;padding-top: 10px;font-size: 16px;font-weight: bold;">Page 1-3</a></li>
                        </ul>
                    </li>
                    <li><a href="#" style="text-align: center;padding-top: 20px;font-size: 16px;font-weight: bold;color: white;">Page 2</a></li>
                    <li><a href="#" style="text-align: center;padding-top: 20px;font-size: 16px;font-weight: bold;color: white;">Page 3</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">    
                    <li><a href="<c:url value="/login/login"/>" style="text-align: center;padding-top: 20px;font-size: 16px;font-weight: bold;color: white;"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                </ul>
            </div>
        </nav>
    </body>
</html>