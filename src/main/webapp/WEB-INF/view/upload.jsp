<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div style="background-color:#eee; height:200px; width:350px; float:left;" >
    <div><b>Main Menu</b></div>
    <spring:message code="hello"/><br/>
    <spring:eval expression="@application['CONTEXT_PATH']"> </spring:eval><br/>
    <p><spring:eval expression="@config['EMAIL_SERVER']"> </spring:eval>
    <p><spring:eval expression="@restful['JIRA_DASHBOARD']"> </spring:eval>
    <p><spring:eval expression="@restful['JIRA_ISSUE']"> </spring:eval>
    <p><spring:eval expression="@restful['JIRA_ISSUETYPE']"> </spring:eval>
</div>

<div style="background-color:#aaa; height:200px; width:100px; float:right;">
    <div><b>File info</b></div>
    Name: <c:out value="${fileInfo.filename}" /><br/>
    Extname: <c:out value="${fileInfo.extname}" /><br/>
    Size: <c:out value="${fileInfo.size}" /><br/>
    <div><b>Other param</b></div>
    name1: <c:out value="${param.name1}" /><br/>
    name2: <c:out value="${param.name2}" /><br/>
</div>
