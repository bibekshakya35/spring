<%@include file="../include/head.jsp" %>

<div class="panel panel-primary" style="width: 600px;margin-left: 100px;">
    <div class="panel-heading"><p style="color: white;font: 20px bold;text-align: center;">Add A Employee</p></div>
    <div class="panel-body">


        <div style="margin: 10px;">
            <c:if test="${not empty message}">
                <p style="text-align: center;padding-bottom: 10px;margin-bottom: 10px; margin-left: 10px;">${message}</p>
            </c:if>
            <c:if test="${not empty errorMessage}">
                <p style="text-align: center;padding-bottom: 10px;margin-bottom: 10px; margin-left: 10px;">${errorMessage}</p>
            </c:if>
        </div>
        <spring:url value="/admin/employee/add" var="url"/>
        <form:form modelAttribute="employee" commandName="employee" method="POST" action="${url}">
            <form:errors path="*"/>
            <div class="form-group">
                <label class="col-sm-6 control-label">Employee Name</label>
                <div class="col-sm-6">
                    <form:input path="employeeName" class="input-medium"/>

                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-6 control-label">Employee DOB</label>
                <div class="col-sm-6">
                    <form:input path="employeeDOB" type="text"  id="datepicker"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-6 control-label">Gender</label>
                <div class="col-sm-6">
                    <form:select path="gender">
                        <c:forEach items="${gender}" var="genderData">
                            <form:option value="${genderData}">${genderData}</form:option>
                        </c:forEach>
                    </form:select>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-6 control-label">Role</label>
                <div class="col-sm-6">
                    <form:select path="roleEmployee">
                        <c:forEach items="${role}" var="roleData">
                            <form:option value="${roleData}">${roleData}</form:option>
                        </c:forEach>
                    </form:select>
                </div>

            </div>
            <div class="form-group">
                <label class="col-sm-6 control-label">Employee Home Address</label>
                <div class="col-sm-6"><form:input path="employeeAddress"/>
                </div>                                
            </div>
            <div class="form-group">
                <label class="col-sm-6 control-label">Employee Mobile Number</label>
                <div class="col-sm-6">
                    <form:input  path="mobileNumber" />
                </div>
            </div>
            <div class="form-group" >
                <label class="col-sm-6 control-label">Employee Email</label>
                <div class="col-sm-6">
                    <form:input path="email"/>
                </div>
            </div>
            <div class="form-group col-sm-offset-5">
                <button class="btn btn-primary" type="submit" style="margin-top: 20px;">
                    <i class="glyphicon glyphicon-save"> Create</i>
                </button>
            </div>


        </form:form>
    </div>
    <div class="panel-footer" style="margin-top: -25px;">
        <p class="text-center text-info">&copy; 2016 Bitcrafter Pvt. Ltd.</p>

    </div> 
</div>


