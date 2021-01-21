<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>회원정보 입력 폼</title>
</head>
<body>
<h1>회원정보 입력 폼</h1>
<form name="mbfrm" method="post" action="/memberok">
    <div>아이디 <input type="text" name="userid" style="vertical-align: bottom"></div>
    <div>비밀번호 <input type="password" name="passwd" style="vertical-align: bottom"></div>
    <div>이름 <input type="text" name="name" style="vertical-align: center"></div>
    <div><button type="submit">입력완료</button>
    <button type="reset">다시입력</button> </div>
</form>
</body>
</html>
