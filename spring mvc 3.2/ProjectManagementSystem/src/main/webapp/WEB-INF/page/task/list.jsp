<%@include file="../include/head.jsp" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<table class="table tableList" style="position: fixed;margin-left: 0px;">

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
            <th><span style="margin: 70px;">P.Name</span></th>
            <th><span style="margin: 40px;">P.Tools</span></th>
            <th><span style="margin:50px;">Team</span></th>
            <th><span style="margin: 20px;">Progress</span></th>
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
        
        

        <c:forEach items="${listProject}"  var="list" varStatus="status">
            <tr>
                <td><span style="margin: 20px; font-size: 14px; color: #101010;">${status.count}</span></td>
                <td><span style="margin:70px;font-size: 14px;color: #101010;">${list.projectName}</span></td>
                <td><span style="margin: 40px;font-size: 14px;color: #101010;">${list.projectResource}</span></td>
                <td><span style="margin: 40px; text-align: center; font-size:12px;color: #101010;">${list.teamName}</span></td>
                <td>
                  
                    <div class="progress">
                        
                        <div class="progress-bar progress-bar-info progress-striped" role="progressbar"
                             aria-valuemin="0" aria-valuemax="100" style="width:<c:out value="${progressList[status.index]}"/>; font:11px bold;padding: 5px;color: red;">
                            <c:out value="${progressList[status.index]}"/>%
                        </div>
                  

                </td>
                <td>
                    <security:authorize access="hasRole('ROLE_ADMIN')">
                    <a href="/admin/project/edit/${list.projectId}" class="btn btn-info"><i class="glyphicon glyphicon-edit"></i> Edit</a></td><td>
                    <a href="/admin/project/delete/${list.projectId}" class="btn btn-danger"><i class="glyphicon glyphicon-remove"></i> Project Finish</a>
                    </security:authorize>
                    <security:authorize access="hasRole('ROLE_USER','ROLE_ADMIN')">
                        <a href="/both/project/view/${list.projectId}" class="btn btn-info"><i class="glyphicon glyphicon-tasks"></i> Project Graph</a>
                    </security:authorize>
                </td>
            </tr>
        </c:forEach>

    </tbody>



</table>


