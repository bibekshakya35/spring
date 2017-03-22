<%@include file="../include/head.jsp" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<table class="table tableList" style="position: fixed;margin-left: 0px; ">

    <thead>
        <tr><th colspan="6" style="text-align: center;font-size: 20px;color: blue;" class="text-justify">Latest Project List

                <div>
                    <c:if test="${not empty message}">
                        <p style="text-align: center;padding-bottom: 10px;margin-bottom: 10px; margin-left: 10px;">${message}</p>
                    </c:if>
                    <c:if test="${not empty errorMessage}">
                        <p style="text-align: center;padding-bottom: 10px;margin-bottom: 10px; margin-left: 10px;">${errorMessage}</p>
                    </c:if>
                </div>
            </th></tr>
        <tr>
            <th><span style="margin: 20px;">SN.</span></th>
            <th><span style="margin: 70px;">E.  Name</span></th>
            <th><span style="margin: 40px;text-align: center;">E.  Role</span></th>
            <th><span style="margin:50px;">E.Address</span></th>
            <th><span style="margin: 20px;">E. Mobile No</span></th>
            <th colspan="2"><span style="margin: 40px;">Option</span></th>
        </tr>
    </thead>
    <tbody>
        <security:authorize access="hasRole('ROLE_USER')">
        <span class="text-info" style="text-align: center;font-size:1em;"><i class="glyphicon glyphicon-info-sign"></i> You have no right to edit or delete the Project</span>

    </security:authorize>
    <security:authorize access="hasRole('ROLE_ADMIN')">
        <span class="text-info" style="text-align: center;font-size:1em;"><i class="glyphicon glyphicon-info-sign"></i> You have right to edit or delete the Project</span>
    </security:authorize>



    <c:forEach items="${listEmployee}"  var="list" varStatus="status">
        <tr>
            <td><span style="margin: 20px; font-size: 14px; color: #101010;">${status.count}</span></td>
            <td><span style="margin:70px;font-size: 14px;color: #101010;">${list.employeeName}</span></td>
            <td><span style="margin: 40px;font-size: 14px;color: #101010;">${list.roleEmployee}</span></td>
            <td><span style="margin: 40px; text-align: center; font-size:12px;color: #101010;">${list.employeeAddress}</span></td>
            <td>

                <span style="margin: 40px; text-align: center; font-size:12px;color: #101010;">${list.mobileNumber}</span>

            </td>
            <td>
                
                    <a href="/pms/admin/employee/edit/${list.employeeId}" class="btn btn-info"><i class="glyphicon glyphicon-edit"></i> Edit</a></td><td>
                 <security:authorize access="hasRole('ROLE_ADMIN')">   <a href="/admin/employee/delete/${list.employeeId}" class="btn btn-danger"><i class="glyphicon glyphicon-remove"></i> Resigned</a>
                </security:authorize>

            </td>
        </tr>
    </c:forEach>

</tbody>



</table>


