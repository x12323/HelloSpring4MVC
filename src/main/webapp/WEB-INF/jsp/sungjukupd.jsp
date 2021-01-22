<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>성적처리수정</title>
</head>
<body>
<h1>성적처리수정</h1>
<form name="sjfrm" method="post" action="/sungjukupdok">
    <>이름 : <button type="text" name="name" value="${sj.name}"readonly></button></div>
    <div>국어 : <button type="text" name="kor" value="${sj.kor}"></button></div>
    <div>영어 : <button type="text" name="eng" value="${sj.eng}"></button></div>
    <div>수학 : <button type="text" name="mat" value="${sj.mat}"></button></div>
    <input type="hidden" name="sjno" value="${sj.sjno}">
    <div><button type="submit">수정완료</button></div>
</form>
</body>
</html>
