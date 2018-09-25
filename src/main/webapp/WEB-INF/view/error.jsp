<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div style="background-color:#eee; height:200px; width:350px; float:left;" >
    <div><b>Error Page</b></div>
    <c:out value="${exception.message}"/><br/>
</div>
