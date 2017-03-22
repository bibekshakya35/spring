<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>  
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%> 

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title><tiles:insertAttribute name="title" ignore="true" /></title>
        <link rel="stylesheet" href="<c:url value="/resources/bootstrap-3.1.1/css/bootstrap.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/css/allpage.css"/>">

    </head>
    <body style="overflow: hidden;" > 
        <div class="container-fluid">
            <div class="container-fluid">   
                <div class="row">
                    <div class="col-md-12">
                        <tiles:insertAttribute name="header"/>
                        <div class="row">
                            <div class="col-sm-3 col-md-3 col-xs-3"><tiles:insertAttribute name="sidebar"/></div>
                            <div class="col-xs-9 col-sm-9">
                                <tiles:insertAttribute name="body"/>
                            </div>
                        </div>

                    </div>
                </div>
            </div>


            <div class="td_footer">
                <div><tiles:insertAttribute name="footer" /></div>
            </div>

        </div>

    </body>

</html>