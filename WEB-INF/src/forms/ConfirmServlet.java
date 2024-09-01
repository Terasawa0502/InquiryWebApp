package forms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// TODO:バリデーションのメソッド化、定数を定義するクラス作成

public class ConfirmServlet extends HttpServlet {
	
	// POSTメソッドのリクエスト時に実行されるメソッド
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// リクエスト・レスポンスの設定
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		// JSPからのリクエストデータ取得
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String message = req.getParameter("message");
		
		// リクエストスコープにデータ保存
		req.setAttribute("name", name);
		req.setAttribute("email", email);
		req.setAttribute("message", message);

		
		// データが存在しない場合は空文字に置き換え
		name = Objects.toString(name, "");
		email = Objects.toString(email, "");
		message = Objects.toString(message, "");
		
		// バリデーションNG時のメッセージを格納するリスト
		ArrayList<String> errorList = new ArrayList<>();
		
		// お名前のバリデーション(空白チェック)
		if ("".equals(name.trim())) {
			errorList.add("お名前を入力してください。");
		}
		
		// メールアドレスのバリデーション(空白チェックとアドレス形式チェック)
		if ("".equals(email)) {
			errorList.add("メールアドレスを入力してください");
		} else if (!email.matches("^[a-zA-Z0-9.]+@[a-zA-Z0-9.]+$")) {
			errorList.add("メールアドレスの形式に誤りがあります。");
		}
		
		// メッセージのバリデーション(空白チェックと文字数が100文字以内かのチェック)
		if ("".equals(message.trim())) {
			errorList.add("お問い合わせ内容を入力してください");
		} else if (message.length() > 100) {
			errorList.add("お問い合わせ内容は100文字を超えています");
		}
		
		// エラーリストが空かどうか
		if (!errorList.isEmpty()) {
			req.setAttribute("errorList", errorList);
		} else {
			// セッションの取得
			HttpSession session = req.getSession();
			
			// セッションへデータ登録
			session.setAttribute("name", name);
			session.setAttribute("email", email);
			session.setAttribute("message", message);
			
			// クッキーに保存
			setCookie(resp, "name", name);
			setCookie(resp, "email", email);
		}
		
		// フォワードによる画面遷移
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/confirmPage.jsp");
		dispatcher.forward(req, resp);
	}
	// 新しいクッキーにを設定するメソッド
	private void setCookie(HttpServletResponse resp, String name, String value) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(60*2);
		resp.addCookie(cookie);
	}

}
