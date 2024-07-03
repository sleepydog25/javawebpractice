package room.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import room.service.BookingRoomService;
import room.service.RoomService;

@WebServlet("/bookingroom/update")
public class BookingRoomUpdateController extends HttpServlet {
	private BookingRoomService service = new BookingRoomService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 取得 Room ID
		Integer bookingId = Integer.parseInt(req.getParameter("bookingId"));
		// 取得 Room 資料
		req.setAttribute("bookingroom", service.getBookingRoom(bookingId));
		// 轉發至 Room 修改頁面
		req.getRequestDispatcher("/WEB-INF/jsp/bookingroom_update.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	
	
}
