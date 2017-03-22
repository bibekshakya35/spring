<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>  
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%> 
<div class="panel panel-primary" style="width: 400px;margin-top: 100px;margin-left: 300px;">
    <div class="panel-heading"><p  style="text-align: center;font-size: 18px; margin-top: 10px;">Login</p></div>
    <div class="panel-body">
        <form class="form-signin" role="form" action="<spring:url value="/j_spring_security_check" />" method="POST">
            <h2 class="form-signin-heading">Please sign in</h2>
            <input type="text" name="username" class="form-control" placeholder="Name" required autofocus> 
            <div class="form-group">
             <label class="input-group-addon" for="password"><i class="fa fa-lock"></i></label> 
            <input type="password" name="password" class="form-control" placeholder="Password" required> 
            </div>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        </form>
    </div>
</div>