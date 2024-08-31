package forms;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		// フォワードによる画面遷移
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/confirmPage.jsp");
		dispatcher.forward(req, resp);
	}

}
