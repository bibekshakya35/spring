
<%-- 
    Document   : addProject
    Created on : Jun 18, 2016, 11:22:02 PM
    Author     : bibekshakya
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  
         pageEncoding="UTF-8"%>  
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>  
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html>
<html>
    <head>

        <meta name="viewport" content="width=device-width, initial-scale=1">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" media="all" href="<c:url value="/resources/css/cssLayout.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/bootstrap-3.1.1/css/bootstrap.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/css/jquery-ui-1.10.4.custom.css"/>">

        <link href="<c:url value="resources/css/bootstrap-responsive.css"/>"
              rel="stylesheet" />
        <link href="<c:url value="/resources/css/navbar.css"/>"
              rel="stylesheet" />
        <link href="<c:url value="/resources/css/jquery-ui-1.8.21.custom.css"/>"
              rel="stylesheet" />
        <link href="<c:url value="/resources/css/uniform.default.css"/>"
              rel='stylesheet' />
        <link href="<c:url value="/resources/css/sidebar.css"/>"
              rel='stylesheet' />


        <!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
          <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

        <!-- The fav icon -->
        <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/img/favicon.ico" />





        <script src="<c:url value="/resources/js/jquery-1.11.1.js"/>" defer="true"></script>
        <script src="<c:url value="/resources/js/jquery-ui-1.10.4.custom.js"/>" defer="true"></script>
        <script src="<c:url value="/resources/js/bootstrap.min.js"/>" defer="true"></script>


        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
        <script src="//code.jquery.com/jquery-1.10.2.js" defer="true"></script>
        <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js" defer="true"></script>
        <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    </head> 
    <body>
        <div class="span2 main-menu-span">

            <div class="well nav-collapse sidebar-nav">
                <ul class="nav nav-tabs nav-stacked main-menu">
                    <li class="accordion-heading"><a class="accordion-toggle"
                                                     data-toggle="collapse" href="#" title="Bank Management">
                            <i class="icon-road"></i> <span class="hidden-tablet">
                                Project Management</span>
                        </a></li>
                    <ul id="banks"
                        class="accordion-body collapse subnav-body nav nav-tabs nav-stacked">
                        <li><a styleClass="ajax-link"
                               href="/pms/project/addProject"> <i
                                    class="icon-ban-circle"></i> <span class="hidden-tablet">
                                    Add Project</span>
                            </a></li>
                        <li><a styleClass="ajax-link"
                               href="/pms/project/list"> <i
                                    class="icon-plus-sign"></i> <span class="hidden-tablet">
                                    List Project</span>
                            </a></li>
                    </ul>
                </ul>
                <ul class="nav nav-tabs nav-stacked main-menu">
                    <li class="accordion-heading"><a class="accordion-toggle"
                                                     data-toggle="collapse" href="#transactions"
                                                     title="Bank Management"> <i class="icon-road"></i> <span
                                class="hidden-tablet"> Member</span>
                        </a></li>
                    <ul id="transactions"
                        class="accordion-body collapse subnav-body nav nav-tabs nav-stacked">
                        <li><a styleClass="ajax-link"
                               href="/pms/member/addmember"> <i class="icon-ban-circle"></i> <span class="hidden-tablet">
                                    Add Member</span>
                            </a></li>
                        <li><a styleClass="ajax-link"
                               href="/pms/employee/addemployee"> <i class="icon-ban-circle"></i> <span class="hidden-tablet">
                                    Add Employee</span>
                            </a></li>

                    </ul>

                </ul>
            </div>
        </div>
    </body>
</html>