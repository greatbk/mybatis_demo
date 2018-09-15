<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html>
<html>
<head>
    <tiles:insertAttribute name="header"/>
</head>
<body>
<div style="width:100%">
    <tiles:insertAttribute name="top"/>
    <tiles:insertAttribute name="content"/>
    <tiles:insertAttribute name="footer"/>
</div>
</body>
</html>
