<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charaset="UTF-8"></meta>
		<title>問い合わせフォーム</title>
	</head>

	<body>
	    <h2>入力内容をご確認ください。</h2>
        <p>問題なければ「確定」、修正する場合は「キャンセル」をクリックしてください。</p>
	    <table border="1">
	    	<tr>
	    		<th>項目</th>
	    		<th>入力内容</th>
	    	</tr>
	    	<tr>
	    		<td>お名前</td>
	    		<!-- お名前を取得 -->
	    		<td>${name}</td>
	    	</tr>
	    	<tr>
	    		<td>メールアドレス</td>
	    		<!-- メールアドレスを取得 -->
	    		<td>${email}</td>
	    	</tr>
	    	<tr>
	    		<td>お問い合わせ内容</td>
	    		<td>${message}</td>
	    	</tr>
	    </table>
	    <%
	    ArrayList<String> errorList = (ArrayList<String>) request.getAttribute("errorList");
	    String disableConfirm = (errorList != null) ? "disabled" : "";
	    %>
	    <p>
	    <button onclick="location.href='<%= request.getContextPath() %>/complete';"<%= disableConfirm %>>確定</button>
	    <button onclick="history.back();">キャンセル</button>
	    </p>
	    <%
	    if (errorList != null) {
	    	for (String errorMessage : errorList) {
	    		out.println("<font color=\"red\">" + errorMessage + "</font><br>");
	    	}
	    }
	    %>
	    
	</body>
</html>