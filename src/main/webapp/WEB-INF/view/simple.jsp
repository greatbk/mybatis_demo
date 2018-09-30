<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div style="background-color:#eee; height:auto; width:auto; padding-left:20px;" >
    <div><b>Main Menu</b></div>
    <p>
        <spring:message code="hello"/><br/>
        <spring:eval expression="@application['CONTEXT_PATH']"> </spring:eval><br/>
        <spring:eval expression="@config['EMAIL_SERVER']"> </spring:eval><br/>
        <spring:eval expression="@restful['JIRA_DASHBOARD']"> </spring:eval><br/>
        <spring:eval expression="@restful['JIRA_ISSUE']"> </spring:eval><br/>
        <spring:eval expression="@restful['JIRA_ISSUETYPE']"> </spring:eval><br/>
    </p>
</div>
