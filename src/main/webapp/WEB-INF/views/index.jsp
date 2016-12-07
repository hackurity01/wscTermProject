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

    <script>
        var publicKeyModulus = "${publicKeyModulus}";
        var publicKeyExponent = "${publicKeyExponent}";
        var session = "${session}";
    </script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="/resources/js/main.js"></script>

</head>
<body>
    <nav class="navbar" style="background-color:#3b52af;">
        <div class="container-fluid">
            <div class="navbar-header">

                <button type="button" id="menu-toggle" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">

                    <img src="/resources/images/sidebar_memu_white.png" style="width: 20px; height: 20px;">
                </button>
            </div>
        </div>
    </nav>
    <div id="container">
        <div id="wrapper">
            <!-- Sidebar -->
            <div id="sidebar-wrapper">
                <ul class="sidebar-nav">
                    <li class="sidebar-brand">
                        <div style="width:234px; height:56px; background-color: #f5f5f5; margin:8px;">
                        </div>
                    </li>
                    <li>
                        <div  style="height:1px; width: 25px;border:solid 1px black; margin:0 113px 0 120px">
                        </div>
                    </li>
                    <li>
                        <a href="logout.jsp">
                            <div class="text-center" style="width:253px; height:170px;     padding-top: 77px;">
                                <img src="/resources/images/sidebar_logout.png" style="width: 20px; height: 20px; margin-bottom:10px">

                                <div style="font-size:1.5em">로그아웃</div>
                            </div>
                        </a>
                    </li>
                    <li>
                        <div class="text-center" style="width:253px; margin-top:100px">
                            <div style="color:#d0d0d0; font-size:1.5em">
                                Printee
                            </div>
                        </div>
                    </li>
                </ul>
            </div>


            <!-- /#sidebar-wrapper -->
            <!-- Page Content -->
            <div id="page-content-wrapper" style=" margin-top: 18px;">
                <div class="container-fluid">
                    <div class="text-center">
                        <div style="font-size:3em" class="form-space">
                            과제 도우미 서비스
                        </div>
                        <div style="font-size:1.1em; margin: 20px 0 40px 0; line-height: 29px;">
                            내 과제를 한눈에, <br>
                            Printee을 이용하세요!
                        </div>

                        <div>
                            <form  method="POST" name="login">
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
