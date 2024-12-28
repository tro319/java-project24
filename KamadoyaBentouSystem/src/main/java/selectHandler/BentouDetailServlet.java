package selectHandler;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bentouSysModel.BentouClass;
import sysDB.BentouDAOClass;


@WebServlet("/bentouDetail")


public class BentouDetailServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
		BentouDAOClass bentouDAO = new BentouDAOClass();
		
		
		String bentouIdParam = request.getParameter("id");
		
		try {
			
			int bentouId = Integer.parseInt(bentouIdParam);
			
			BentouClass selectedBentou = bentouDAO.getBentouById(bentouId);
			
			if (selectedBentou != null) {
				request.setAttribute("selectedBentou", selectedBentou);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("bentouDetail.jsp");
				dispatcher.forward(request, response);
			} else {
				response.sendError(HttpServletResponse.SC_NOT_FOUND, "指定された弁当は存在しません。");
			}
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
			
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "弁当詳細データの取得中にエラーが発生しました。");
		}
		
		
		
		
	}
}