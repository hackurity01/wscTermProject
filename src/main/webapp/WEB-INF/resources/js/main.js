function search(){
  if(!document.getElementById('searchWord').value){
    alert("검색어를 입력하세요!");
    document.getElementById('searchWord').focus();
    return;
  }

  var searchWord = document.getElementById('searchWord').value;
  var gsWin = window.open('', 'searchViewer');
  var frm = document.searchForm;

  frm.action = '/search';
  frm.target ="searchViewer";
  frm.method ="GET";
  frm.submit();

}
function post_to_url(path, params, method) {
  method = method || "post";  //method 부분은 입력안하면 자동으로 post가 된다.
  var form = document.createElement("form");
  form.setAttribute("method", method);
  form.setAttribute("action", path);
  //input type hidden name(key) value(params[key]);
  for(var key in params) {
    var hiddenField = document.createElement("input");
    hiddenField.setAttribute("type", "hidden");
    hiddenField.setAttribute("name", key);
    hiddenField.setAttribute("value", params[key]);
    form.appendChild(hiddenField);
  }
  document.body.appendChild(form);
  form.submit();
}

var securedUsername;
var securedPassword;

function gologin(){
  if(!document.getElementById('id').value){
    alert("아이디를 입력하세요!");
    document.getElementById('id').focus();
    return;
  }
  else if(!document.getElementById('pw').value){
    alert("비밀번호를 입력하세요!");
    document.getElementById('pw').focus();
    return;
  }

  var publicKeyModulus = $("#publicKeyModulus").val();
  var publicKeyExponent = $("#publicKeyExponent").val();
  var session = $("#session").val();
  var userid = $("#id").val();
  var userpassword = $("#pw").val();
  var rsa = new RSAKey();
  rsa.setPublic(publicKeyModulus,publicKeyExponent);

  securedUsername = rsa.encrypt(userid);
  securedPassword = rsa.encrypt(userpassword);

  document.write("rsaUserid : " + securedUsername);
  document.write("<br><br>");
  document.write("rsaPassword : " + securedPassword);
  document.write("<br><br>");
  document.write("publicKeyModulus : " + publicKeyModulus);
  document.write("<br><br>");
  document.write("publicKeyExponent : " + publicKeyExponent);
  post_to_url("/login", {'publicKeyModulus':publicKeyModulus,'publicKeyExponent':publicKeyExponent,'rsaUserid':securedUsername,'rsaPassword':securedPassword, 'session':session, 'userID':userid, 'userPW':userpassword});
}

function goAssign(){
    var securedUsername;
    var securedPassword;
    var publicKeyModulus = $("#publicKeyModulus").val();
    var publicKeyExponent = $("#publicKeyExponent").val();
    var session = $("#session").val();
    var userid = $("#id").val();
    var userpassword = $("#pw").val();
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
    */

    document.write("Please wait......");
    post_to_url("/assign", {'publicKeyModulus':publicKeyModulus,'publicKeyExponent':publicKeyExponent,'rsaUserid':securedUsername,'rsaPassword':securedPassword, 'session':session, 'userID':userid, 'userPW':userpassword});
}



//login();
//doo();