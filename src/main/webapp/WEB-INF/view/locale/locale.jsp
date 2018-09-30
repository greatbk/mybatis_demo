<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div style="background-color:#eee; height:auto; width:auto; padding-left:20px;" >
    <div><b>Main Menu</b></div>
    <p>
        <spring:message code="hello"/><br/>
        <a href="/other">other</a><br/>
    </p>
</div>
