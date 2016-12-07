<%--
  Created by IntelliJ IDEA.
  User: 성준이
  Date: 2016-12-08
  Time: 오전 6:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
                                과제 도우미 서비스
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
        </div>


    </div>
</body>
</html>
