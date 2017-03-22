<%-- 
    Document   : list
    Created on : Nov 13, 2016, 8:05:53 AM
    Author     : bibek
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta name="viewport" content="width=device-width, initial-scale=1">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-sm-offset-3 col-md-7 col-xs-7 col-lg-7">
                    <table class="table table-condensed">
                        <thead>
                            <tr>
                                <th>SN</th>
                                <th>Code</th>
                                <th>Description</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${roles}" var="r" varStatus="status">
                                <tr>
                                    <td>${status.index+1}</td>
                                    <td>${r.code}</td>
                                    <td>${r.description}</td>
                                   <td><a href="<c:url value="/role/edit/${r.id}"/>" title="Edit"><img src="<c:url value="/resources/images/edit.jpg"/>"/></a></td>  
                                    <td><a href="" title="Delete"><img src="<c:url value="/resources/images/delete.jpg"/>"/></a></td>
                                </tr>
                            </c:forEach>
                        </tbody>                        
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
