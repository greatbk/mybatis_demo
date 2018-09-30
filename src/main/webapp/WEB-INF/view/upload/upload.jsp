<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div style="background-color:#eee; height:auto; width:auto; padding-left:20px;">
    <div><b>File info</b></div>
    <p>
        Name: <c:out value="${fileInfo.filename}" /><br/>
        Extname: <c:out value="${fileInfo.extname}" /><br/>
        Size: <c:out value="${fileInfo.size}" /><br/>
    </p>
    <div><b>Other param</b></div>
    <p>
        name1: <c:out value="${param.name1}" /><br/>
        name2: <c:out value="${param.name2}" /><br/>
    </p>
</div>
