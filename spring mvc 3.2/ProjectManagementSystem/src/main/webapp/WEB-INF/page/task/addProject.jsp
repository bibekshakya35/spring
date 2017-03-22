<%@include file="../include/head.jsp" %>

<center>

    <div class="panel panel-primary" style="width:700px;height: auto;margin-left:-150px;margin-top:-20px;">
        <div class="panel-heading">
            <h5 class="text-center" style="color: white;font:16px bold;">Add a project</h5>
        </div>
        <div class="panel-body" style="padding-right: 100px;">
            <div style="padding: 10px;margin-bottom: 10px;">
                <c:if test="${not empty message}">
                    <span class="text-info">${message}</span>
                </c:if>
                <c:if test="${not empty errorMessage}">
                    <span class="text-danger">${errorMessage}</span>
                </c:if>
            </div>
            <form:form id="addProject" commandName="project" modelAttribute="project" cssClass="form-horizontal" action="save" method="POST"  enctype="multipart/form-data">
                <div class="form-group">
                    <label class="col-sm-6 control-label text-center" style="text-align: center;">Project name</label>
                    <div class="col-md-6">
                        <form:input path="projectName"  class="input-medium"/>
                        <form:errors path="projectName"  class="input-medium"/>
                    </div>
                </div>

                <div class="form-group">
                    <label style="text-align: center;" class="col-sm-6 control-label text-center">Resources</label>
                    <div class="col-sm-6">
                        <form:select path="projectResource" id="projectResource">
                            <c:forEach items="${projectRes}" var="res">
                                <form:option value="${res}"></form:option>
                            </c:forEach>
                        </form:select>
                    </div>
                </div>

                <div class="form-group">
                    <label style="text-align: center;" class="col-sm-6 control-label text-center">Commencement:</label>
                    <div class="col-sm-6">
                        <form:input  path="projectStartingDate"  id="datepicker"/>
                    </div>
                </div>
                <div class="form-group">
                    <label style="text-align: center;" class="control-label col-sm-6 text-center">Completion:</label>
                    <div class="col-sm-6">
                        <form:input path="projectEndingDate"  id="datepicker1"/>
                    </div>
                </div>
                <div class="form-group">
                    <label style="text-align: center;" class="col-sm-6 text-center control-label">Team Name: </label>
                    <div class="col-sm-6">
                        <form:select path="teamName" id="selectBox">
                            <c:forEach items="${skill}" var="skills">
                                <form:option value="${skills}">${skills}</form:option>
                            </c:forEach>
                        </form:select>
                    </div>
                </div>
                <div class="form-group">
                    <label style="text-align: center;" class="col-sm-6 control-label">Project Status</label>
                    <div class="col-sm-6">
                        <c:forEach var="check" items="${projectStatus}">
                            <form:checkbox path="projectStatus" value="${check}"/><label>${check}</label>
                        </c:forEach>
                    </div>
                </div>
                <div class="form-group">
                    <label style="text-align: center;" class="col-sm-6 control-label">Project Requirement</label>
                    <div class="col-sm-6">
                        <input type="file" name="files" />
                    </div>
                </div>

                <div class="form-group">
                    <button class="btn btn-primary" style="width: 300px;height: 40px; margin-left: 70px"><i class="glyphicon glyphicon-save"></i>  Create</button>
                </div>

            </form:form>
        </div>
        <div class="panel-footer" style="margin-top: -25px;">
            <p class="text-center text-info">&copy; 2016 Bitcrafter Pvt. Ltd.</p>

        </div>
    </div>




</center>


