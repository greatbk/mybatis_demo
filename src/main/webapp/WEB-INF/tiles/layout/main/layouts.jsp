<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!doctype html>
<html lang="ko">

<head>
    <tiles:insertAttribute name="header"/>
</head>

<body>
<div class="wrapper">
    <tiles:insertAttribute name="left"/>
    <div class="main-panel">
        <tiles:insertAttribute name="top"/>
        <tiles:insertAttribute name="content"/>
        <tiles:insertAttribute name="footer"/>
    </div>
</div>
<tiles:insertAttribute name="module"/>
</body>

<tiles:insertAttribute name="bottom"/>
</html>