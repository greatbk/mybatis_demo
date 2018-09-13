<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!doctype html>
<html lang="ko">

<head>Demo</head>

<body>
    <tiles:insertAttribute name="top"/>
    <div class="wrapper wrapper-full-page">
            <tiles:insertAttribute name="content"/>
            <tiles:insertAttribute name="footer"/>
    </div>
    <tiles:insertAttribute name="module"/>
</body>

<tiles:insertAttribute name="bottom"/>
</html>
