<%@ page language="java" contentType="text/html; charset=UTF-8"  
         pageEncoding="UTF-8"%>  
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>  
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<div class="span2 main-menu-span">
    
        <div class="well nav-collapse sidebar-nav">
            <ul class="nav nav-tabs nav-stacked main-menu">
                <li class="accordion-heading"><a class="accordion-toggle"
                                                 data-toggle="collapse" href="#banks" title="Bank Management">
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
    