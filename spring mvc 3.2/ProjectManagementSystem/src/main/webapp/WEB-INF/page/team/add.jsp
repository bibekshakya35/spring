<%@include file="../include/head.jsp" %>
<div class="container">
    <div class="row">
          <div class="panel panel-primary" style="width: 350px; margin:0px 250px 20px 250px;">
        <div class="panel-heading">
            <h5 style="color: white; text-align: center;font: 16px bold;">Add A Member</h5>
            
        </div>
        <div class="panel-body">
           <c:if test="${not empty message}">
                <p style="color: white;">${message}</p>
            </c:if>
            <form:form modelAttribute="team" action="savemember" method="POST" cssClass="form-horizontal">
                <div class="form-group">
                    <label class="col-sm-6 control-label" style="text-align: center;">List of Team</label>
                    <div class="col-sm-6">
                        <form:select path="teamName">
                            <c:forEach items="${teamNameList}" var="teamMember">
                                <form:option value="${teamMember}">${teamMember}</form:option>
                            </c:forEach>
                        </form:select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-6 control-label" style="text-align: center;">Employee Name</label>
                    <div class="col-sm-6">
                        <form:select path="employeeId">
                            <c:forEach items="${employeeList}" var="employeeName">
                                <form:option value="${employeeName.employeeId}">${employeeName.employeeName}</form:option>
                            </c:forEach>
                        </form:select>
                    </div>
                </div>
                <div class="form-group">
                    <button class="btn btn-primary center-block" type="submit"><i class="glyphicon glyphicon-save"></i>  Create</button>
                </div>

            </form:form>
        </div>
        <div class="panel-footer" style="margin-top: -25px;">
            <p class="text-center text-info">&copy; 2016 Bitcrafter Pvt. Ltd.</p>

        </div> 
        </div>
    </div>
        
    
    
    </div>
