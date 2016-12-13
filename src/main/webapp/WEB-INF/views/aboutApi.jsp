<%--
  Created by IntelliJ IDEA.
  User: 성준이
  Date: 2016-12-13
  Time: 오전 5:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Api 소개</title>
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
            <div class="wrapper text-center" style="margin-top: 10%;">
                <div style="font-size:2em;">
                    <strong>저희가 제공하는 API는 다음과 같습니다!</strong><br>
                </div>

                <div>
                    <strong><p style="font-size:1.3em">Naver, Daum, Google 통합 검색 API</p></strong><br>
                    <p style="font-size:1.2em"><strong>설명</strong></p><p>검색어를 통해 네이버, 다음, 구글의 검색 결과를 모두 받을 수 있습니다.</p>
                    <p style="font-size:1.2em"><strong>URL</strong></p><p> http://sample-env.dw2rfaamem.us-west-2.elasticbeanstalk.com/cs/api/<strong>검색어</strong></p>
                    <p style="font-size:1.2em"><strong>출력 결과</strong></p>

                    <strong><p>API Result</p></strong>
                    <p>int total : 검색 결과의 수</p>
                    <p>List items : 결과 객체</p>

                    <strong><p>Item</p></strong>
                    <p>String title : 제목</p>
                    <p>String link : 링크</p>
                    <p>String description : 글 내용</p>
                </div>
                <br><br><br><br>
                <div>
                    <strong><p style="font-size:1.3em">과제 리스트 제공 API</p></strong><br>
                    <p style="font-size:1.2em"><strong>설명</strong></p><p>아이디와 비밀번호를 입력하면 학생의 과제 목록을 받을 수 있습니다.</p>
                    <p style="font-size:1.2em"><strong>URL</strong></p><p> http://sample-env.dw2rfaamem.us-west-2.elasticbeanstalk.com/assign/<strong>아이디</strong>/<strong>비밀번호</strong></p>
                    <p style="font-size:1.2em"><strong>출력 결과</strong></p>

                    <strong><p>Clss</p></strong>
                    <p>String name : 과목 명</p>
                    <p>Arraylist Assi : 과제 목록</p>

                    <strong><p>Item</p></strong>
                    <p>String title : 과제 제목</p>
                    <p>String content : 과제 내용</p>
                    <p>String lectureLectureValue : 과목 번호</p>
                </div>


            </div>
        </div>
    </body>
</html>
