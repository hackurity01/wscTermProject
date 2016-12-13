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

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="/resources/js/main.js"></script>
    <script src="/resources/js/rsa.js"></script>
    <script src="/resources/js/prng4.js"></script>
    <script src="/resources/js/rng.js"></script>
    <script src="/resources/js/jsbn.js"></script>


</head>
<body>
    <form  method="POST" name="login">
        <input type="hidden" id="publicKeyModulus1" value="${publicKeyModulus}">
        <input type="hidden" id="publicKeyExponent1" value="${publicKeyExponent}">
        <input type="hidden" id="session1" value="${session}">
        <input type="hidden" id="id1" value="${id}">
        <input type="hidden" id="pw1" value="${pw}">
        <script type="text/javascript">
            (function(){
                var securedUsername;
                var securedPassword;
                var publicKeyModulus = $("#publicKeyModulus1").val();
                var publicKeyExponent = $("#publicKeyExponent1").val();
                var session = $("#session1").val();
                var userid = $("#id1").val();
                var userpassword = $("#pw1").val();
                var rsa = new RSAKey();
                rsa.setPublic(publicKeyModulus,publicKeyExponent);

                securedUsername = rsa.encrypt(userid);
                securedPassword = rsa.encrypt(userpassword);

                /*
                document.write("rsaUserid : " + securedUsername);
                document.write("<br><br>");
                document.write("rsaPassword : " + securedPassword);
                document.write("<br><br>");
                document.write("publicKeyModulus : " + publicKeyModulus);
                document.write("<br><br>");
                document.write("publicKeyExponent : " + publicKeyExponent);
                document.write("<br><br>");
                document.write("userid : " + userid);
                document.write("<br><br>");
                document.write("userpassword : " + userpassword);
                */
                document.write("Please wait......");

                post_to_url("/assign", {'publicKeyModulus':publicKeyModulus,'publicKeyExponent':publicKeyExponent,'rsaUserid':securedUsername,'rsaPassword':securedPassword, 'session':session, 'userID':userid, 'userPW':userpassword});

            })();
        </script>
    </form>
</div>

<script src="http://el.koreatech.ac.kr/js/prng4.js"></script>
<script src="http://el.koreatech.ac.kr/js/rsa.js"></script>
<script src="http://el.koreatech.ac.kr/js/jsbn.js"></script>
<script src="http://el.koreatech.ac.kr/js/rng.js"></script>

</body>
</html>
