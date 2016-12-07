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
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="/resources/css/bootstrap.min.csss" media="screen">
    <link type="text/css" rel="stylesheet" href="/resources/css/font-awesome.min.css" media="screen">
    <link type="text/css" rel="stylesheet" href="/resources/css/main.css" media="screen">
    <link type="text/css" rel="stylesheet" href="/resources/css/simple-sidebar.css" media="screen">


    <script src="/clothesShop/common/js/main.js" type="text/javascript"></script>

</head>
<body>
    <nav class="navbar" style="background-color:#3b52af;">
        <div class="container-fluid">
            <div class="navbar-header">

                <button type="button" id="menu-toggle" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">

                    <img src="./icon/sidebar_memu_white.png" style="width: 20px; height: 20px;">
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
                            <div style="float:left">
                                <img src="./icon/sidebar_user.png" style="width: 20px; height: 20px;">
                                <?=$_SESSION['id']?>
                            </div>
                            <!--<div style="float:right; padding:16px">
                                <div style="background-color:#3b52af; border-radius:20px; width:53px; height:22px">
                                </div>
                                <?=$_SESSION['point']?>
                            </div>-->
                        </div>
                    </li>
                    <li>
                        <div data-toggle="modal" data-target="#myModal">
                            <div class="text-center" style="width:253px; height:203px;     padding-top: 64px;">
                                <img src="./icon/sidebar_point.png" style="width: 20px; height: 20px; margin-bottom:10px">
                                <div style="font-size:1.5em; color:black;">포인트 충전</div>
                                <div style="font-size:1.1em; color:#9b9b9b;">
                                    <div id="point">보유 포인트 <?=$_SESSION['point']?>P</div>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div  style="height:1px; width: 25px;border:solid 1px black; margin:0 113px 0 120px">
                        </div>
                    </li>
                    <li>
                        <a href="logout.jsp">
                            <div class="text-center" style="width:253px; height:170px;     padding-top: 77px;">
                                <img src="./icon/sidebar_logout.png" style="width: 20px; height: 20px; margin-bottom:10px">

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

            <!-- Modal -->
            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="myModalLabel">포인트 충전</h4>
                        </div>
                        <div class="modal-body">
                            <button type="button" class="btn btn-default" onClick="request()">충전하실래요? ㅎ</button>

                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>

                        </div>
                    </div>
                </div>
            </div>
            <!-- /#sidebar-wrapper -->
            <!-- Page Content -->
            <div id="page-content-wrapper" style=" margin-top: 18px;">
                <div class="container-fluid">
                    <div class="text-center">
                        <div style="font-size:3em" class="form-space">
                            <div><img src="./icon/login_logo.png" style="width: 75px; height: 75px;"></div>
                            Printee
                        </div>
                        <div style="font-size:1.1em; margin: 20px 0 40px 0; line-height: 29px;">
                            바쁜 일상 속 프린트를 손쉽게<br>
                            Printee을 이용하세요!
                        </div>

                        <div>
                            <form action="login.php" method="POST" name="login">
                                <input type="text" class="form-control form-space btn_max" placeholder="아이디" id="id" name="id">
                                <input type="password" class="form-control form-space btn_max" placeholder="비밀번호" id="pw" name="pw">
                                <input type="button" class="btn btn-primary form-space btn_max" style="background-color:#606fb3;" onClick="login()" value="로그인">
                            </form>
                        </div>

                        <div>
                            <a href="join.php" style="color : white">계정이 없으신가요?</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    <script src="./asset/js/main.js"></script>
    <!-- Menu Toggle Script -->
    <script>
        $("#menu-toggle").click(function(e) {
            e.preventDefault();
            $("#wrapper").toggleClass("toggled");
        });
    </script>

</body>
</html>
