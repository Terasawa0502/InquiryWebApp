package forms;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormServlet extends HttpServlet {
	
	// GETメソッドのリクエスト時に実行されるメソッド
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// クッキーの取得
		Cookie[] userCookie = req.getCookies();
		if (userCookie != null) {
			for (Cookie cookie : userCookie) {
				switch (cookie.getName()){
				case "name": 
					req.setAttribute("name", cookie.getValue());
					break;
				case "email": 
					req.setAttribute("email", cookie.getValue());
					break;
				default:
					break;
				}
			}
		}
		
		// フォワードによる画面遷移
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/formPage.jsp");
		dispatcher.forward(req, resp);
	}

}
