<%-- 
    Document   : formLayout
    Created on : Jun 18, 2016, 1:38:20 PM
    Author     : bibekshakya
--%>

<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>  
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
    <head>
        <title><tiles:insertAttribute name="title" ignore="true"/></title>
        <link rel="stylesheet" href="<c:url value="/resources/bootstrap-3.1.1/css/bootstrap.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/css/allpage.css"/>">
    </head>
    <body class="layout-body container"> 
        <table class="layout-body container">
            <tr>
                <td width="80%" class="td_body">
                    <tiles:insertAttribute name="body"/>
                </td>
            </tr>
        </table>
    </body>
</html>
