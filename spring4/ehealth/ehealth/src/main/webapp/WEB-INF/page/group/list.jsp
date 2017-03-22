<%-- 
    Document   : list
    Created on : Nov 13, 2016, 8:03:30 AM
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
                <div class="col-sm-10 offset2">
                    <div>
                        <c:if test="${not empty message}">
                            <label class="label label-info">${message}</label>
                        </c:if>
                        <c:if test="${not empty errorMessage}">
                            <label class="label label-danger">${errorMessage}</label>
                        </c:if>
                    </div>
                    <table class="table table-condensed">

                        <thead>
                            <tr>

                                <th class="center-block center_content" style="text-align: center;">List of Group</th>
                            </tr>
                            <tr>
                                <th>SN</th>
                                <th>Code</th>
                                <th>Description</th>
                                <th>Option</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="g" items="#{groups}" varStatus="status">
                                <tr>
                                    <td>${status.count}</td>
                                    <td>${g.code}</td>
                                    <td>${g.description}</td>
                                   
                                    <td><a href="<c:url value="/group/edit/${g.code}"/>" title="Edit"><img src="<c:url value="/resources/images/edit.jpg"/>"/></a></td>  
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
