<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charaset="UTF-8"></meta>
		<title>問い合わせフォーム</title>
	</head>

	<body>
	    <h1>お問い合わせを承りました。</h1>
	    <button onclick="location.href='<%= request.getContextPath() %>/form';">問い合わせ画面へ戻る</button>
	</body>
</html>