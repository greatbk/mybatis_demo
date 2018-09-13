<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="rightcolumn">
    <div class="card">
        <h2>About Me</h2>
        <div class="fakeimg" style="height:100px;">Image</div>
        <p>Some text about me in culpa qui officia deserunt mollit anim..</p>
    </div>
    <div class="card">
        <h3>Reference Multi Languages</h3>
        <div class="fakeimg"><p><spring:message code="hello"/></p></div>
        <div class="fakeimg"><p>Image</p></div>
        <div class="fakeimg"><p>Image</p></div>
    </div>
    <div class="card">
        <h3>Reference XML Properties</h3>
        <p><spring:eval expression="@application['CONTEXT_PATH']"> </spring:eval>
    </div>
</div>
