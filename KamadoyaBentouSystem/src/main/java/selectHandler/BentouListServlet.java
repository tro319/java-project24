package selectHandler;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bentouSysModel.BentouClass;
import sysDB.BentouDAOClass;

@WebServlet("/bentouList")


public class BentouListServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		
		
		// BentouDAOClassから、インスタンス作成。
		
		BentouDAOClass bentouDAO = new BentouDAOClass();
		
		// ユーザーが選択した、弁当の種類を取得。
		
		String selectedKind = request.getParameter("kind");
		
		System.out.println("選択された弁当種類: " + selectedKind);
		
		
		try {
			
			// BentouDAOClassのインスタンスのフィールドから、全ての弁当データを取得するメソッドを呼び出す。
			
			List<BentouClass> allRsBentous = bentouDAO.getAllBentous();
			
			// ユーザーが弁当の種類を選択していたら、全ての弁当のデータを持っている、フィールドに絞り込みをかける。
			
			if (selectedKind != null && !selectedKind.isEmpty()) {
				allRsBentous = allRsBentous.stream().filter(g -> g.getKind().equalsIgnoreCase(selectedKind)).collect(Collectors.toList());
			}
			
			// JSPに、データをセットする。
			
			request.setAttribute("allRsBentous", allRsBentous);
			request.setAttribute("selectedKind", selectedKind);
			
		} catch (SQLException e) {
			
			request.setAttribute("errorMessage", "データの取得中に、エラーが発生しました。");
			e.printStackTrace();
			
		}
		
		
		// JSPに、フォワード。
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("bentouList.jsp");
		dispatcher.forward(request, response);
		
		
	}
	

}

