<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>  
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%> 
<div class="panel panel-primary" style="width: 500px;margin-left: 300px;">
    <div class="panel-heading"><p  style="text-align: center;font-size: 18px; margin-top: 10px;">Sign Up</p></div>
    <div class="panel-body">
        <c:if test="${not empty message}">
            <span class="text-primary">${message}</span>
        </c:if>
        <c:if test="${not empty errorMessage}">
            <span class="text-danger">${errorMessage}</span>
        </c:if>
        <c:url value="/user/save" var="saveUser"/>
        <form:form modelAttribute="user" action="${saveUser}" method="POST" class="form-horizontal" cssStyle="margin-right:100px">
            <div class="form-group">
                <label class="col-sm-6 control-label">First name</label>
                <div class="col-sm-6">
                    <form:input path="firstName"/> 
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-6 control-label">Last name</label>
                <div class="col-sm-6">
                    <form:input path="lastName"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-6 control-label">User Name</label>
                <div class="col-sm-6"><form:input path="username"/></div>
            </div>
            <div class="form-group">
                <label class="col-sm-6 control-label">Email Id</label>
                <div class="col-sm-6"><form:input type="email" path="email"/></div>
            </div>
            <div class="form-group">
                <label class="col-sm-6 control-label">Password</label>
                <div class="col-sm-6">
                    <form:password path="password"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-6 control-label">Confirm<br>Password</label>
                <div class="col-sm-6">
                    <form:password path="confirmPassword"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-offset-6 control-label">Active / InActive</label>
              
                    <form:checkbox path="enabled"/>
                
            </div>
            <div class="form-group">
                <label class="col-sm-6 control-label">Role</label>
                <div class="col-sm-6">
                    <form:select path="roleData">
                        <c:forEach items="${roleList}" var="roledata">
                            <form:option value="${roledata.id}" label="${roledata.role}"/>
                        </c:forEach>
                    </form:select>
                </div>
            </div>
            <div class="form-group">
                <button class="btn btn-primary" type="submit"><i class="glyphicon glyphicon-save"></i> Save</button>
            </div>


        </form:form>
    </div>
</div>
