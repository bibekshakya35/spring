<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>  
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%> 

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title><tiles:insertAttribute name="title" ignore="true" /></title>
        <link rel="stylesheet" href="<c:url value="/resources/bootstrap-3.1.1/css/bootstrap.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/css/allpage.css"/>">

    </head>
    <body class="layout-body container" style="overflow: hidden;" > 
        <div class="layout_table">
            <div>
                <div class="td_header" style="overflow: visible;"><tiles:insertAttribute name="header" /></div>
            </div>
            
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-3" style="top:90px; margin-left: 0px;left: -60px;">
                        <tiles:insertAttribute name="menu"/>
                    </div>
                    <div class="col-md-9" style="margin-left: 250px;top:120px; position: fixed ">
                        <tiles:insertAttribute name="body"/>
                    </div>
                </div>
            </div>
            
               
                <div class="td_footer">
                    <div><tiles:insertAttribute name="footer" /></div>
                </div>
            
        </div>

    </body>

</html>