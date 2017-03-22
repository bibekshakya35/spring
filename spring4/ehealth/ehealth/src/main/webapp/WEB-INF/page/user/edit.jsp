<%-- 
    Document   : edit
    Created on : Nov 26, 2016, 9:27:48 AM
    Author     : Bibek Shakya
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>  

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
        <meta name="viewport" content="width=device-width, initial-scale=1.0"></meta>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script>
            $(function () {
                $("#datepicker").datepicker({
                    dateFormat: "dd/mm/yy",
                    changeMonth: true,
                    changeYear: true,
                    showButtonPanel: true,
                    yearRange: "-100:+0"
                });
            });
        </script>
        
    </head>
    <body>

        <div class="container">
            <div class="row" style="overflow: scroll;">
                <div class="well-sm">
                    <c:if test="${not empty message}">
                        <span class="success">${message}</span>
                    </c:if>
                    <c:if test="${not empty errorMessage}">
                        <span class="error-code">${errorMessage}</span>
                    </c:if>
                </div>
                
                <div class="row">
                    <div class="col-sm-offset-2" >
                        <c:url value="/user/edit/${user.userName}" var="edit"/>
                        <form:form cssClass="form-horizontal" method="POST" modelAttribute="user" action="${edit}" enctype="multipart/form-data">
                            <h5 class="col-sm-offset-3 text-success lead">Edit User Form</h5>
                            <div class="form-group">
                                
                                <label class="control-label col-sm-3">Username *</label>
                                <div class="col-sm-9">
                                    <form:input path="userName"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">Email</label>
                                <div class="col-sm-9">
                                    <form:input path="userProfile.emailId"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="password" class="col-sm-3 control-label">Password</label>
                                <div class="col-sm-9">
                                    <form:password path="userPassword"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="userType" class="col-sm-3 control-label">User Type</label>
                                <div class="col-sm-9">
                                    <form:select path="userType">
                                        <c:forEach items="${usertype}" var="types">
                                            <form:option value="${types}"/>
                                        </c:forEach>
                                    </form:select>
                                </div>
                            </div>


                            <div class="form-group">
                                <label for="fullName" class="col-sm-3 control-label">Full Name</label>
                                <div class="col-sm-9">
                                    <form:input path="userProfile.fullname"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="userDetails" class="col-sm-3 control-label">User Details</label>
                                <div class="col-sm-9">
                                    <form:textarea path="userProfile.basicInfo"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="userMobileNumber" class="col-sm-3 control-label">Mobile Number</label> 
                                <div class="col-sm-9">
                                    <form:input path="userProfile.mobileNumber"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="userMobileNumber" class="col-sm-3 control-label">Land Line Number</label> 
                                <div class="col-sm-9">
                                    <form:input path="userProfile.landLineNumber"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="userDob" class="col-sm-3 control-label">Date of Birth</label>
                                <div class="col-sm-9">
                                    <form:input path="userProfile.userDob" id="datepicker"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="userGender" class="col-sm-3 control-label">Gender</label>
                                <div class="col-sm-9">
                                    <form:select path="userProfile.userGender">
                                        <c:forEach items="${userGenders}" var="gender">
                                            <form:option value="${gender}"/>
                                        </c:forEach>
                                    </form:select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="userProfilePic" class="col-sm-3 control-label">Profile Pic</label>
                                <div class="col-sm-9">
                                    <input type="file" name="files"/>
                                </div>
                            </div>
                            <div class="form-group" style="margin-bottom: 100px;">
                                <button class="btn btn-primary btn-lg col-sm-offset-3" type="submit"><i class="glyphicon glyphicon-save"></i> Edit</button>
                            </div>

                        </form:form>
                    </div>
                </div>
                <!-- /form -->
            </div>
        </div>
    </body>
</html>

