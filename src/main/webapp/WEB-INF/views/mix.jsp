<%--
  Created by IntelliJ IDEA.
  User: feeling_x64
  Date: 2016-12-08
  Time: 오전 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>전체 검색 - ${searchWord}</title>
</head>
<body>
<h2>전체 검색 결과(질의어: ${searchWord})</h2>

<form action="/cs/naver" method="GET">
    <input type="text" name="searchWord" placeholder="Naver 검색"/>
    <input type="submit" value="검색">
</form>

<form action="/cs/daum" method="GET">
    <input type="text" name="searchWord" placeholder="Daum 검색"/>
    <input type="submit" value="검색">
</form>

<form action="/cs/google" method="GET">
    <input type="text" name="searchWord" placeholder="Google 검색"/>
    <input type="submit" value="검색">
</form>

<form action="/cs/mix" method="GET">
    <input type="text" name="searchWord" placeholder="전체 검색"/>
    <input type="submit" value="검색">
</form>
<br/><br/>


<h3>웹문서 검색결과</h3><br/><br/>
<c:choose>
    <c:when test="${not empty ar.items}">
        <c:forEach var="item" items="${ar.items}">
            ${item.title}<br/>
            <a href=${item.link} target="_blank">${item.link}</a><br/>
            ${item.description}<br/><br/>
        </c:forEach>
    </c:when>
    <c:otherwise>
        검색 결과가 없습니다.<br/><br/>
    </c:otherwise>
</c:choose>
<br/><br/>

</body>
</html>
