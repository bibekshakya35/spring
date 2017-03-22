<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
        <div class="container">
            <div class="row">
                <div>
                    <c:if test="${not empty message}">
                        <p style="text-align: center;padding-bottom: 10px;margin-bottom: 10px; margin-left: 10px;">${message}</p>
                    </c:if>
                    <c:if test="${not empty errorMessage}">
                        <p style="text-align: center;padding-bottom: 10px;margin-bottom: 10px; margin-left: 10px;">${errorMessage}</p>
                    </c:if>
                </div>
                <div class="col-sm-offset-1 col-sm-9">

                    <table class="table table-condensed">
                        <thead>
                            <tr><th colspan="6" style="text-align: center;font-size: 20px;color: blue;" class="text-justify">List of User

                                </th></tr>
                            <tr>
                                <th>SN.</th>
                                <th>Full Name</th>
                                <th>Email Address</th>

                                <th>Mobile No</th>
                                <th colspan="2">Option</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="user" items="${users}" varStatus="status">
                                <tr>
                                    <td>${status.count}</td>
                                    <td>${user.userProfile.fullname}</td>
                                    <td>${user.userProfile.emailId}</td>
                                    <td>${user.userProfile.mobileNumber}</td>
                                    <td><a href="<c:url value="/user/edit/${user.userName}"/>" title="Edit"><img src="<c:url value="/resources/images/edit.jpg"/>"/></a></td>  
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