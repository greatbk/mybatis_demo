<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div style="background-color:#eee; height:auto; width:100%;" >
    <div><b>File Upload Example</b></div>
    <form action="/upload9" method="post" enctype="multipart/form-data">
        <div>
            <input type="file" name="file">
        </div>
        <div>
            <input type="text" name="name1" value="abc">
        </div>
        <div>
            <input type="text" name="name2" value="123">
        </div>
        <input type="submit" value="Upload" name="submit">
    </form>
</div>
