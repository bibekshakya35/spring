<%-- 
    Document   : loginlayout
    Created on : Jun 30, 2016, 9:29:07 AM
    Author     : bibekshakya
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>  
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%> 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><tiles:insertAttribute name="title" ignore="true"/></title>
        <link rel="stylesheet" href="<c:url value="/resources/bootstrap-3.1.1/css/bootstrap.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/css/allpage.css"/>">
    </head>
    <body>
        <div class="container"><div class="row">
                <div class="col-md-7">
                    <tiles:insertAttribute name="body"/>
                </div>
            </div>
        </div>
        <div class="footer">
            <tiles:insertAttribute name="footer"/>
        </div>
    </body>
</html>
