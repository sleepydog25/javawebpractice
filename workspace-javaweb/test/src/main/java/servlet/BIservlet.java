package servlet;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/servlet/bmi")
public class BIservlet extends HttpServlet{

	
	//store BMI calculation history
	private List<Map<String, Object>> bmiList = new CopyOnWriteArrayList<>();

	
	//for looking up
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		

		
		
		
		//response with the "raw" version
		//resp.getWriter().print(bmiList);
		//response with html elements
				resp.getWriter().print("<html>");
				resp.getWriter().print("<head>");
				resp.getWriter().print("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css\">");
				resp.getWriter().print("</head>");
				resp.getWriter().print("<body style=\"padding: 15px\">");
				resp.getWriter().print("<table class=\"pure-table pure-table-bordered\">");
			
				
				resp.getWriter().print("<thead>");
				resp.getWriter().print("<tr>");
				resp.getWriter().print("<th>Name</th>");
				resp.getWriter().print("<th>Height</th>");
				resp.getWriter().print("<th>Weight</th>");
				resp.getWriter().print("<th>BMI</th>");
				resp.getWriter().print("</tr>");
				resp.getWriter().print("</thead>");
				
				resp.getWriter().print("<tbody>");		
				bmiList.forEach(map ->{
					try {
						resp.getWriter().print("<tr>");
						resp.getWriter().print("<td>" + map.get("name")+"</td>");
						resp.getWriter().print("<td>" + map.get("height")+"</td>");
						resp.getWriter().print("<td>" + map.get("weight")+"</td>");
						resp.getWriter().print("<td>" + map.get("bmi")+"</td>");
						resp.getWriter().print("</tr>");
					} catch(Exception e) {
						
					}
				});
				resp.getWriter().print("</tbody>");
				
				resp.getWriter().print("</table>")
				;
				resp.getWriter().print("<p>");
				resp.getWriter().print("<a href=\"/test/bmi.html\" class=\"pure-button pure-button-primary\">Go back <a>");
				resp.getWriter().print("</body>");
				resp.getWriter().print("</html>");
				
	}
	
	
	// change doGet to doPost, to upgrade network security
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// set encoding
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		
		//get parameter
		String userName = req.getParameter("userName");
		String userHeight = req.getParameter("userHeight");
		String userWeight = req.getParameter("userWeight");
		
		//calculate BMI,turn String to double
		double height = Double.parseDouble(userHeight);
		double weight = Double.parseDouble(userWeight);
		double bmi = weight/Math.pow(height/100, 2);
		
		//declare a Map collection to store user info
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("name", userName);
		map.put("height", height);
		map.put("weight", weight);
		map.put("bmi", bmi);

		//add them to the list
		bmiList.add(map);
		
		//response
		resp.getWriter().print("BMI Result = " + bmi); 

	}

}
