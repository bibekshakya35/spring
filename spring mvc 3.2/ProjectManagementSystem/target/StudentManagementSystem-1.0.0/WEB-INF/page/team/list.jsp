<%@include file="../include/head.jsp" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<security:authorize access="hasRole('ROLE_USER')">
    <span class="text-info" style="text-align: center;font-size:1em;"><i class="glyphicon glyphicon-info-sign"></i> You have no right to edit or delete the Team Member</span>

</security:authorize>
<security:authorize access="hasRole('ROLE_ADMIN')">
    <span class="text-info" style="text-align: center;font-size:1em;"><i class="glyphicon glyphicon-info-sign"></i> You have right to edit or delete the Team Member</span>
</security:authorize>

<div>
    <c:if test="${not empty message}">
        <p style="text-align: center;padding-bottom: 10px;margin-bottom: 10px; margin-left: 10px;">${message}</p>
    </c:if>
    <c:if test="${not empty errorMessage}">
        <p style="text-align: center;padding-bottom: 10px;margin-bottom: 10px; margin-left: 10px;">${errorMessage}</p>
    </c:if>
</div>
<div class="row">

    <div class="card card-1 col-md-3 col-xs-3">

        <h4 class="text-success" style="text-align: center;font-style: monospace;font: 20px; color: black;"><hr>
            Alpha-Spring</h4>

        <table class="table table-condensed">
            <thead>
                <tr>
                    <th style="text-align: center;">Member</th>
                    <th style="text-align: center;">Skill</th>
                </tr>
            </thead>
            <c:forEach begin="0" step="1" varStatus="status" items="${teamMember}" var="teams">

                <tr>
                    <td><p class="text-info" style="text-align: center;font: 14px; color: black;"><i class="glyphicon glyphicon-user"></i> ${teams.employeeName}</p></td>
                    <td><p class="text-info" style="text-align: center;font: 14px; color: black;"><i class="glyphicon glyphicon-stats"></i> ${teams.employeeRole}</p></td>
                </tr>

            </c:forEach>
        </table>
        <hr>
    </div>
    <div class="card card-2 col-md-3 col-xs-3">

        <h4  style="text-align: center;font-style: monospace; font: 20px; color: black;"><hr>
            Alpha-php</h4>

        <table class="table table-condensed">
            <thead>
                <tr>
                    <th style="text-align: center;">Member</th>
                    <th style="text-align: center;">Skill</th>
                </tr>
            </thead>
            <c:forEach begin="0" step="1" varStatus="status" items="${teamMember1}" var="teams">

                <tr>
                    <td><p class="text-info" style="text-align: center;font: 14px; color: black;"><i class="glyphicon glyphicon-user"></i> ${teams.employeeName}</p></td>
                    <td><p class="text-info" style="text-align: center;font: 14px; color: black;"><i class="glyphicon glyphicon-stats"></i> ${teams.employeeRole}</p></td>
                </tr>

            </c:forEach>
        </table>
        <hr>
    </div>


    <div class="card card-3 col-md-3 col-xs-3">

        <h4 class="text-success" style="text-align: center;font-style: monospace;font: 20px; color: black;"><hr>
            Alpha-Ejb</h4>


        <table class="table table-condensed">
            <thead>
                <tr>
                    <th style="text-align: center;">Member</th>
                    <th style="text-align: center;">Skill</th>
                </tr>
            </thead>
            <c:forEach begin="0" step="1" varStatus="status" items="${teamMember2}" var="teams">

                <tr>
                    <td><p class="text-info" style="text-align: center;font: 14px; color: black;"><i class="glyphicon glyphicon-user"></i> ${teams.employeeName}</p></td>
                    <td><p class="text-info" style="text-align: center;font: 14px; color: black;"><i class="glyphicon glyphicon-stats"></i> ${teams.employeeRole}</p></td>
                </tr>

            </c:forEach>
        </table>
        <hr>
    </div>





</div>


