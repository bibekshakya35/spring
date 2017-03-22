<%-- 
    Document   : add
    Created on : Nov 13, 2016, 7:03:22 AM
    Author     : bibek
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<!DOCTYPE html>
<html>
    <head>

        <meta name="viewport" content="width=device-width, initial-scale=1">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
        <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/css/jquery-ui-1.10.4.custom.css"/>">
        <script src="<c:url value="/resources/js/jquery-1.11.1.js"/>"></script>
        <script src="<c:url value="/resources/js/jquery-ui-1.10.4.custom.js"/>"></script>
        <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
    </head>
    <body>
        <div class="row">
            <div class="col-sm-9 col-md-9">
                <div>
                    <c:if test="${not empty message}">
                        <label class="label label-info">${message}</label>
                    </c:if>
                    <c:if test="${not empty errorMessage}">
                        <label class="label label-danger">${errorMessage}</label>
                    </c:if>
                </div>
                <c:url value="/role/editRole/${role.id}" var="edit"/>
                <form:form id="editRoleForm" modelAttribute="role" action="${edit}" method="post">
                    <table class="table table-condensed" id="tablegroup">
                        <tr>
                            <td><label class="label label-primary">Code</label></td>
                            <td><form:input path="code"/></td>
                            <td><form:errors path="code" cssClass="label label-danger"/></td>
                        </tr>

                        <tr>
                            <td><label class="label label-primary">Description</label></td>
                            <td><form:input path="description"/></td>

                        </tr>
                        <tr>
                            <td><label class="label label-primary">User Type</label></td>
                            <td> 
                                <c:forEach items="${group}" var="m" varStatus="i">
                                    <label class="label label-success"><c:out value="${m.key}"/></label><br>
                                    <c:forEach items="${m.value}" var="p">
                                        <form:checkbox value="${p.code}" 
                                                       path="permissions" 
                                                       label="${p.code}"
                                                       checked="${p.checked ?'checked':''}"
                                                       /> 
                                    </c:forEach>
                                </c:forEach>
                            </td>

                        </tr>
                    </table>

                    <div class="form-group" style="margin-bottom: 100px;">
                        <button class="btn btn-primary btn-lg col-sm-offset-3" type="submit" ><i class="glyphicon glyphicon-save"></i> Save</button>
                    </div>
                </form:form>
            </div>
    </body>
</html>
