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

@WebServlet("/servlet/bmr")
public class bmrServlet extends HttpServlet{
	
	//store BMR calculation history
	private List<Map<String, Object>> bmrList = new CopyOnWriteArrayList<>();

	
	//for looking up
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String deleteId = req.getParameter("deleteId");
		System.out.print(deleteId);
		if(deleteId != null) {
			int id = Integer.parseInt(deleteId);
			
			bmrList.remove(id);
		}
		//delete id
		
		
		//handle data
		//by using "setAttribute" send bmrList into req 
		// In order to send bmrList into jsp
		req.setAttribute("bmrList", bmrList);
		
		//link to jsp, you don't need to put html code into the servlet(model 2)
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/bmr_list.jsp");
		rd.forward(req, resp);
		
		//response with the "raw" version
		//resp.getWriter().print(bmrList);
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
				resp.getWriter().print("<th>Age</th>");
				resp.getWriter().print("<th>Sex<th>");
				resp.getWriter().print("<th>BMR</th>");
				resp.getWriter().print("</tr>");
				resp.getWriter().print("</thead>");
				
				resp.getWriter().print("<tbody>");		
				bmrList.forEach(map ->{
					try {
						resp.getWriter().print("<tr>");
						resp.getWriter().print("<td>" + map.get("name")+"</td>");
						resp.getWriter().print("<td>" + map.get("height")+"</td>");
						resp.getWriter().print("<td>" + map.get("weight")+"</td>");
						resp.getWriter().print("<td>" + map.get("Age")+"</td>");
						resp.getWriter().print("<td>" + map.get("Sex")+"</td>");
						resp.getWriter().print("<td>" + map.get("bmr")+"</td>");
						resp.getWriter().print("</tr>");
					} catch(Exception e) {
						
					}
				});
				resp.getWriter().print("</tbody>");
				
				resp.getWriter().print("</table>")
				;
				resp.getWriter().print("<p>");
				resp.getWriter().print("<a href=\"/test/bmr.html\" class=\"pure-button pure-button-primary\">Go back <a>");
				resp.getWriter().print("</body>");
				resp.getWriter().print("</html>");
				
	}

		
		

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// send encoding
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		
		//get parameter
		String userName = req.getParameter("userName");
		String userHeight = req.getParameter("userHeight");
		String userWeight = req.getParameter("userWeight");
		String userAge = req.getParameter("userAge");
		String userSex = req.getParameter("userSex");
		
		
		//calculate BMI,turn String to double
		double bmr = 0;
		double height = Double.parseDouble(userHeight);
		double weight = Double.parseDouble(userWeight);
		double age = Double.parseDouble(userAge);
		switch(userSex) {
			case"Female":
				bmr =  665+(9.6*weight)+(1.8+height)-(4.7*age);
				break;
			case"Male" :
				bmr = 66+(13.7*weight)+(5+height)-(6.8*age);
				break;
			default:
				System.out.println("Something Wrong");
		
		}
		
		//declare a Map collection to store user info
				Map<String, Object> map = new LinkedHashMap<>();
				map.put("name", userName);
				map.put("Sex", userSex);
				map.put("Age", userAge);
				map.put("height", height);
				map.put("weight",weight);
				map.put("bmr", bmr);

				//add them to the list
				bmrList.add(map);
		//response 
		resp.getWriter().print("BMR Result = " + bmr);
	}

}
