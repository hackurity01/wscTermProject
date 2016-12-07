
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

var publicKeyModulus = "${publicKeyModulus}";
var publicKeyExponent = "${publicKeyExponent}";
var securedUsername;
var securedPassword;

function login(){
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
  doo();
}
function doo() {
  post_to_url("/login", {'publicKeyModulus':publicKeyModulus,'publicKeyExponent':publicKeyExponent,'rsaUserid':securedUsername,'rsaPassword':securedPassword});
}

//login();
//doo();