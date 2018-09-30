<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!doctype html>
<html lang="ko">
<head>
    <tiles:insertAttribute name="header"/>
</head>
<body>
<tiles:insertAttribute name="top"/>
<div class="row">
    <tiles:insertAttribute name="content"/>
    <tiles:insertAttribute name="right"/>
</div>
<tiles:insertAttribute name="footer"/>
</body>
</html>
