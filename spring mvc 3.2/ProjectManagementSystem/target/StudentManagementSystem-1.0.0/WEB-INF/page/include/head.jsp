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
<!DOCTYPE html>
<html>
    <head>
         <link href='http://fonts.googleapis.com/css?family=Didact+Gothic' rel='stylesheet' type='text/css'>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" media="all" href="<c:url value="/resources/css/cssLayout.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/bootstrap-3.1.1/css/bootstrap.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/css/jquery-ui-1.10.4.custom.css"/>">
        
        <link href="<c:url value="resources/css/bootstrap-responsive.css"/>"
		rel="stylesheet" />
        <link href="<c:url value="resources/css/charisma-app.css"/>"
		rel="stylesheet" />
         <link href="<c:url value="resources/css/allpage.css"/>"
		rel="stylesheet" />
        <link href="<c:url value="resources/css/jquery-ui-1.8.21.custom.css"/>"
		rel="stylesheet" />
        <link href="<c:url value="resources/css/uniform.default.css"/>"
		rel='stylesheet' />
        <link href="<c:url value="resources/css/jquery.cleditor.css"/>"
		rel='stylesheet' />
        <link href="<c:url value="resources/css/jquery.iphone.toggle.css"/>"
		rel='stylesheet' />
        <link href="<c:url value="resources/css/opa-icons.css"/>" rel='stylesheet' />
        <link href="<c:url value="resources/css/uploadify.css"/>" rel='stylesheet' />
	
	<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
	<!--[if lt IE 9]>
          <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

	<!-- The fav icon -->
        <link rel="shortcut icon" href="<c:url value="resources/img/favicon.ico"/>" />
        
        
        
        
        
        <script src="<c:url value="/resources/js/jquery-1.11.1.js"/>"></script>
        <script src="<c:url value="/resources/js/jquery-ui-1.10.4.custom.js"/>"></script>
        <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
        

        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
        <script type="text/javascript">
            $(function () {
            $("#datepicker").datepicker({
            dateFormat: "dd/mm/yy",
                    changeMonth: true,
                    changeYear: true,
                    showButtonPanel: true,
                    yearRange: "-100:+0"
            });
            $("#datepicker1").datepicker({
            dateFormat: "dd/mm/yy",
                    changeMonth: true,
                    changeYear: true,
                    showButtonPanel: true,
                    yearRange: "-100:+0"
            });
            });
        </script>
        <script>
            $(document).ready(function (){
            $(function (){
            $("#projectResource").change(function (){

            $.getJSON("http://localhost:8080/StudentManagementSystem/project/data/jsonList",
            {
            ajax:'true'
            }, function(data){
            var html = "<option value="">Skill</option>";
            var len = data.length;
            for (var i = 0; i < len; i++) {
            html += '<option value="' + data[i] + '">' + data[i] + '</option>';
            }
            html += "</option>"
                    $(#selectBox).html(html);
            }
            );
            });
            });
            });
           
        </script>
        <style>
         .ui-widget-header {
            background: #cedc98;
            border: 1px solid #DDDDDD;
            color: #333333;
            font-weight: bold;
         }
         .tableList{
             margin: 30px;
             margin-left: -230px;
             margin-top: -30px;
             width: 600px;
         }
         .tableList thead tr td{
             padding: 10px;
             text-align: center;
             margin: 10px;
         }
         .tableList tbody tr td{
             padding: 10px;
             text-align: center;
             margin: 10px;
            
         }
         td{
            padding: 20px;
            text-align: center;
         }
       
      </style>
    </head>
    <body>
        
    
