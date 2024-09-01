<%@ page contentType="text/html; charset=UTF-8" %>

<html>
    <head>
        <title>Servlet/JSPの基礎を学ぼう</title>
    </head>
    <body>
    
        <%
        // セッションからデータ取得
        String name = (String) session.getAttribute("name");
        %>
         <h2>${name}様、お問い合わせを承りました。</h2>
        <p>ありがとうございました。今後の参考にさせていただきます。</p>

        <%-- 戻るボタン（入力フォームに戻る） --%>
        <button onclick="location.href='<%= request.getContextPath() %>/form';">戻る</button>
    </body>
</html>
