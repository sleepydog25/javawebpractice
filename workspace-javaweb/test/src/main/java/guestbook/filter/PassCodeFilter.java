package guestbook.filter;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//passcode = 1234
//使用者輸入通關密碼才可以到訪客留言板 (GuestBook)
@WebFilter("/guestbook/*")

public class PassCodeFilter extends HttpFilter {

	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("PASSCODEFILTER 過濾");

		if (req.getMethod().equals("GET")) {
			//有deleted ID 不檢查code，檢查是否有deleted ID
			if (req.getParameter("deleteId") == null) {
				// check code equals 1234
				if (req.getParameter("code") == null || !req.getParameter("code").equals("1234")) {
					res.getWriter().print("Passcode Error!");
					return;
				}
			}
		}

		// 放行
		chain.doFilter(req, res);
	}

}
