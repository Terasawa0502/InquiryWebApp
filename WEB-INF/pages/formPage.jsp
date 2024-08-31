<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charaset="UTF-8"></meta>
		<title>問い合わせフォーム</title>
	</head>

	<body>
	    <h1>お問い合わせ</h1>
	    <form action="<%= request.getContextPath() %>/confirm" method="post">
	    	<table>
	    		<tr>
	    			<td>お名前</td>
	    			<td>
	    				<input type="text" name="name">
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>メールアドレス</td>
	    			<td>
	    				<input type="text" name="email">
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>お問い合わせ内容</td>
	    			<td>
	    				<textarea name="message" cols="30" rows="10"></textarea>
	    			</td>
	    		</tr>
	    	</table>
	    	<input type="submit" value="送信">
	    </form>
	</body>
</html>