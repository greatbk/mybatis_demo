<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="leftcolumn">
    <div class="card">
        <h3>Reference XML Properties</h3>
        <p>
            <spring:eval expression="@application['CONTEXT_PATH']"> </spring:eval><br/>
        </p>
    </div>
    <div class="card">
        <h3>Reference Properties</h3>
        <p>
            <spring:eval expression="@config['EMAIL_SERVER']"> </spring:eval><br/>
            <spring:eval expression="@restful['JIRA_DASHBOARD']"> </spring:eval><br/>
            <spring:eval expression="@restful['JIRA_ISSUE']"> </spring:eval><br/>
            <spring:eval expression="@restful['JIRA_ISSUETYPE']"> </spring:eval><br/>
        </p>
    </div>
    <div class="card">
        <h3>Reference Multi Languages</h3>
        <p>
            <spring:message code="hello"/><br/>
        </p>
    </div>
</div>
