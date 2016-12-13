<%--
  Created by IntelliJ IDEA.
  User: YDK
  Date: 2016-12-08
  Time: 오전 6:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>검색결과</title>
        <link type="text/css" rel="stylesheet" href="/resources/css/bootstrap.min.css" media="screen">
        <link type="text/css" rel="stylesheet" href="/resources/css/font-awesome.min.css" media="screen">
        <link type="text/css" rel="stylesheet" href="/resources/css/main.css" media="screen">
        <link type="text/css" rel="stylesheet" href="/resources/css/simple-sidebar.css" media="screen">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
        <script src="/resources/js/main.js"></script>
    </head>
<body >
<div class="container">
    <div class="wrapper" style="margin: 0 200px 0 200px;">


        <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">

            <c:forEach var="subjectlist" items="${clsList}" varStatus="status">
                <c:choose>
                    <c:when test = "${status.index == 0}">

                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="heading${status.index}">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapse${status.index}" aria-expanded="true" aria-controls="collapse${status.index}">
                                    ${subjectlist.name}
                            </a>
                        </h4>
                    </div>
                    <div id="collapse${status.index}" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="heading${status.index}">
                        <div class="panel-body">

                    </c:when>
                    <c:otherwise>

                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="heading${status.index}">
                        <h4 class="panel-title">
                            <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapse${status.index}" aria-expanded="false" aria-controls="collapse${status.index}">
                                    ${subjectlist.name}
                            </a>
                        </h4>
                    </div>
                    <div id="collapse${status.index}" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading${status.index}">
                        <div class="panel-body">

                    </c:otherwise>

                </c:choose>
                        <c:forEach var="assignmentList" items="${clsList[status.index].AList}" varStatus="content">
                            <div>
                                <strong><p>${assignmentList.title}</p></strong>
                                <p>${assignmentList.content}</p>
                            </div>

                        </c:forEach>

                        </div>
                    </div>
                </div>

            </c:forEach>
        </div>

        <form name="searchForm" action="" method="GET">
            <input type="text" class="form-control" name="searchWord" id="searchWord" style="float:left; width:90%;" placeholder="검색어를 입력하세요.">
            <input type="button" class="btn btn-primary" style="float:right;" onClick="javascript:search()" value="검색">
        </form>

        <form action="/aboutApi" method="GET">
            <input class="btn btn-primary" style="margin:10px 0 10px 0;" type="submit" value="과제도우미가 제공하는 API">
        </form>

        </div>
    </div>
</body>
</html>
