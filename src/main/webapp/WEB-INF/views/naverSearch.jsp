<%--
  Created by IntelliJ IDEA.
  User: feeling_x64
  Date: 2016-12-07
  Time: 오후 2:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>네이버 검색 - ${searchWord}</title>
</head>
<body>
<h2>네이버 검색 결과(질의어: ${searchWord})</h2>

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
<br/><br/>


<h3>백과사전 검색결과</h3><br/><br/>
<c:choose>
    <c:when test="${not empty encyc.items}">
        <c:forEach var="item" items="${encyc.items}">
            <c:if test="${not empty item.thumbnail}">
                <img src=${item.thumbnail} width="100" height="80"/>
            </c:if>
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


<h3>지식in 검색결과</h3>
<br/><br/>
<c:choose>
    <c:when test="${not empty kin.items}">
        <c:forEach var="item" items="${kin.items}">
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


<h3>카페 검색결과</h3>
<br/><br/>
<c:choose>
    <c:when test="${not empty cafearticle.items}">
        <c:forEach var="item" items="${cafearticle.items}">
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


<h3>블로그 검색결과</h3>
<br/><br/>
<c:choose>
    <c:when test="${not empty blog.items}">
        <c:forEach var="item" items="${blog.items}">
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

<h3>웹페이지 검색결과</h3><br/><br/>
<c:choose>
    <c:when test="${not empty webkr.items}">
        <c:forEach var="item" items="${webkr.items}">
            ${item.title}<br/>
            <a href=${item.link} target="_blank">${item.link}</a><br/>
            ${item.description}<br/><br/>
        </c:forEach>
    </c:when>
    <c:otherwise>
        검색 결과가 없습니다.<br/><br/>
    </c:otherwise>
</c:choose>

</body>
</html>
