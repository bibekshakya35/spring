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
                <c:url value="/group/save" var="save"/>
                <form:form id="addgroupcode" modelAttribute="group" action="${save}">
                    <table class="table table-condensed" id="tablegroup">
                        <tr>
                            <td><label class="label label-primary">Code</label></td>
                            <td><form:input path="code"/></td>
                            <td><form:errors path="code" cssClass="label label-danger"/></td>
                        </tr>
                        <tr>
                            <td><label class="label label-primary">Name</label></td>
                            <td><form:input path="name"/></td>
                            <td><form:errors path="name" cssClass="label label-danger"/></td>
                        </tr>
                        <tr>
                            <td><label class="label label-primary">Description</label></td>
                            <td><form:input path="description"/></td>

                        </tr>
                        <tr>
                            <td><label class="label label-primary">User Type</label></td>
                            <td> 
                                <form:select path="userType">
                                    <c:forEach items="${usertype}" var="types">
                                        <form:option value="${types}"/>
                                    </c:forEach>
                                </form:select>
                            </td>
                            <td><td><form:errors path="userType" cssClass="label label-danger"/></td></td>
                        </tr>
                    </table>

                    <div class="form-group" style="margin-bottom: 100px;">
                        <button class="btn btn-primary btn-lg col-sm-offset-3" type="submit" ><i class="glyphicon glyphicon-save"></i> Save / Edit</button>
                    </div>


                    <table class="table table-condensed">
                        <thead>
                            <tr>
                                <th>code</th>
                                <th>name</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="p" items="${permissions}">
                                <tr><td>${p.code}</td>  <td>${p.name}</td></tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="col-sm-3 col-md-3">
                    <fieldset>
                        <legend>Permission</legend>

                        <div class="form-group">
                            <label class="label col-md-3 label-primary control-label">code</label>
                            <div class="col-sm-9">
                                <form:input path="permission.code"/>

                            </div>

                        </div>
                        <div class="form-group">
                            <label class="label col-md-3 label-primary control-label">Name</label>
                            <div class="col-sm-9">
                                <form:input path="permission.name"/>


                            </div>
                        </div>
                        <div class="form-group">
                            <label class="label col-md-3 label-primary control-label">Description</label>
                            <div class="col-sm-9">
                                <form:input path="permission.descriptions"/>

                            </div>
                        </div>
                        <div class="form-group" style="margin-bottom: 100px;">
                            <button class="btn btn-primary btn-lg col-sm-offset-3" type="submit" name="addPermission" id="btngroup"><i class="glyphicon glyphicon-save"></i> Save / Edit</button>
                        </div>

                    </form:form>
                </fieldset>
            </div>
        </div>


    </body>
</html>
