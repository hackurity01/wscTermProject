<%--
  Created by IntelliJ IDEA.
  User: 성준이
  Date: 2016-12-13
  Time: 오전 3:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>전체 검색 - ${searchWord}</title>
    <link type="text/css" rel="stylesheet" href="/resources/css/bootstrap.min.css" media="screen">
    <link type="text/css" rel="stylesheet" href="/resources/css/font-awesome.min.css" media="screen">
    <link type="text/css" rel="stylesheet" href="/resources/css/main.css" media="screen">
    <link type="text/css" rel="stylesheet" href="/resources/css/simple-sidebar.css" media="screen">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    <script src="/resources/js/main.js"></script>
</head>
<body>
    <div class="container">
        <div class="wrapper" style="margin: 0 200px 0 200px;">
            <Strong><p class="text-center" style="font-size:2em;">${searchWord} 검색 결과</p></Strong>
                <strong><p class="text-center" style="font-size:1.5em;">Google</p></strong>
                <c:choose>
                    <c:when test="${not empty googleSearch.items}">
                        <c:forEach var="item" items="${googleSearch.items}">
                            <strong><p>${item.htmlTitle}</p></strong>
                            <a href=${item.link} target="_blank">${item.link}</a>
                            <p style="margin-bottom: 40px;">${item.htmlSnippet}</p>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        검색 결과가 없습니다.<br/><br/>
                    </c:otherwise>
                </c:choose>
                <br/><br/>


                <strong><p class="text-center" style="font-size:1.5em;">Naver</p></strong>
                <p class="text-center">백과사전 검색 결과</p>
                <c:choose>
                    <c:when test="${not empty encyc.items}">
                        <c:forEach var="item" items="${encyc.items}">
                            <c:if test="${not empty item.thumbnail}">
                                <img src=${item.thumbnail} width="100" height="80"/>
                            </c:if>
                            <strong><p>${item.title}</p></strong>
                            <a href=${item.link} target="_blank">${item.link}</a>
                            <p style="margin-bottom: 40px;">${item.description}</p>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        검색 결과가 없습니다.<br/><br/>
                    </c:otherwise>
                </c:choose>
                <br/><br/>



                <p class="text-center">지식in 검색결과</p>
                <br/><br/>
                <c:choose>
                    <c:when test="${not empty kin.items}">
                        <c:forEach var="item" items="${kin.items}">
                            <strong><p>${item.title}</p></strong>
                            <a href=${item.link} target="_blank">${item.link}</a>
                            <p style="margin-bottom: 40px;">${item.description}</p>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        검색 결과가 없습니다.<br/><br/>
                    </c:otherwise>
                </c:choose>
                <br/><br/>



                <p class="text-center">카페 검색결과</p>
                <br/><br/>
                <c:choose>
                    <c:when test="${not empty cafearticle.items}">
                        <c:forEach var="item" items="${cafearticle.items}">
                            <strong><p>${item.title}</p></strong>
                            <a href=${item.link} target="_blank">${item.link}</a>
                            <p style="margin-bottom: 40px;">${item.description}</p>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        검색 결과가 없습니다.<br/><br/>
                    </c:otherwise>
                </c:choose>
                <br/><br/>



                <p class="text-center">블로그 검색결과</p>
                <br/><br/>
                <c:choose>
                    <c:when test="${not empty blog.items}">
                        <c:forEach var="item" items="${blog.items}">
                            <strong><p>${item.title}</p></strong>
                            <a href=${item.link} target="_blank">${item.link}</a>
                            <p style="margin-bottom: 40px;">${item.description}</p>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        검색 결과가 없습니다.<br/><br/>
                    </c:otherwise>
                </c:choose>
                <br/><br/>


                <p class="text-center">웹페이지 검색결과</p>
                <c:choose>
                    <c:when test="${not empty webkr.items}">
                        <c:forEach var="item" items="${webkr.items}">
                            <strong><p>${item.title}</p></strong>
                            <a href=${item.link} target="_blank">${item.link}</a>
                            <p style="margin-bottom: 40px;">${item.description}</p>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        검색 결과가 없습니다.<br/><br/>
                    </c:otherwise>
                </c:choose>


                <strong><p class="text-center" style="font-size:1.5em;">Daum</p></strong>
                <p class="text-center">게시판 검색결과</p>
                <c:choose>
                    <c:when test="${not empty daumBoard.channel.item}">
                        <c:forEach var="item" items="${daumBoard.channel.item}">
                            <strong><p><c:out value="${item.title}" escapeXml="false"/></p></strong>
                            <a href=${item.link} target="_blank">${item.link}</a>
                            <p style="margin-bottom: 40px;">${item.description}</p>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        검색 결과가 없습니다.<br/><br/>
                    </c:otherwise>
                </c:choose>
                <br/><br/>



                <p class="text-center">블로그 검색결과</p>
                <c:choose>
                    <c:when test="${not empty daumBlog.channel.item}">
                        <c:forEach var="item" items="${daumBlog.channel.item}">
                            <strong><p>${item.title}</p></strong>
                            <a href=${item.link} target="_blank">${item.link}</a>
                            <p style="margin-bottom: 40px;">${item.description}</p>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        검색 결과가 없습니다.<br/><br/>
                    </c:otherwise>
                </c:choose>
                <br/><br/>



                <p class="text-center">웹 검색결과</p>
                <c:choose>
                    <c:when test="${not empty web.channel.item}">
                        <c:forEach var="item" items="${web.channel.item}">
                            <strong><p>${item.title}</p></strong>
                            <a href=${item.link} target="_blank">${item.link}</a>
                            <p style="margin-bottom: 40px;">${item.description}</p>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        검색 결과가 없습니다.<br/><br/>
                    </c:otherwise>
                </c:choose>
                <br/><br/>



                <p class="text-center">팁 검색결과</p>
                <c:choose>
                    <c:when test="${not empty daumKnowledge.channel.item}">
                        <c:forEach var="item" items="${daumKnowledge.channel.item}">
                            <strong><p>${item.title}</p></strong>
                            <a href=${item.link} target="_blank">${item.link}</a>
                            <p style="margin-bottom: 40px;">${item.description}</p>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        검색 결과가 없습니다.<br/><br/>
                    </c:otherwise>
                </c:choose>
                <br/><br/>
        </div>
    </div>
</body>
</html>
