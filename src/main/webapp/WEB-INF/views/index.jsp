<%--
  Created by IntelliJ IDEA.
  User: 성준이
  Date: 2016-12-08
  Time: 오전 3:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> WSC TermProject </title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link type="text/css" rel="stylesheet" href="/resources/css/bootstrap.min.css" media="screen">
    <link type="text/css" rel="stylesheet" href="/resources/css/font-awesome.min.css" media="screen">
    <link type="text/css" rel="stylesheet" href="/resources/css/main.css" media="screen">
    <link type="text/css" rel="stylesheet" href="/resources/css/simple-sidebar.css" media="screen">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="/resources/js/main.js"></script>

</head>
<body class="body_set">
    <div id="container">
        <div id="wrapper">
            <!-- /#sidebar-wrapper -->
            <!-- Page Content -->
            <div id="page-content-wrapper" style=" margin-top: 18px;">
                <div class="container-fluid">
                    <div class="text-center">
                        <div style="font-size:3em" class="form-space">
                            과제 도우미 서비스
                        </div>
                        <div style="font-size:1.1em; margin: 20px 0 40px 0; line-height: 29px;">
                            내 과제를 한눈에<br>
                            과제 관련 자료를 한방에!
                        </div>
                        <div>
                            <form  method="POST" name="login">
                                <input type="hidden" id="publicKeyModulus" value="${publicKeyModulus}">
                                <input type="hidden" id="publicKeyExponent" value="${publicKeyExponent}">
                                <input type="hidden" id="session" value="${session}">
                                <input type="text" class="form-control form-space btn_max" placeholder="아이디" id="id" name="id">
                                <input type="password" class="form-control form-space btn_max" placeholder="비밀번호" id="pw" name="pw">
                                <input type="button" class="btn btn-primary form-space btn_max" style="background-color:#606fb3;" onClick="javascript:gologin()" value="로그인">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Menu Toggle Script -->
    <script>
        $("#menu-toggle").click(function(e) {
            e.preventDefault();
            $("#wrapper").toggleClass("toggled");
        });
    </script>
    <script src="http://el.koreatech.ac.kr/js/prng4.js"></script>
    <script src="http://el.koreatech.ac.kr/js/rsa.js"></script>
    <script src="http://el.koreatech.ac.kr/js/jsbn.js"></script>
    <script src="http://el.koreatech.ac.kr/js/rng.js"></script>

</body>
</html>
