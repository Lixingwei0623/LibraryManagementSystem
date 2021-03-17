package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Book;
import dao.impl.IBookDaoImpl;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IBookDaoImpl iBookDaoImpl=new IBookDaoImpl();    
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String category = request.getParameter("cate");
		if (category==null||category.equals("recom")) {
			ArrayList<Book> books=iBookDaoImpl.getBooksByRecommed();
			System.out.println(category);
			request.setAttribute("cate", "recom");
			request.setAttribute("url", "index");
			request.setAttribute("books", books);
			request.getRequestDispatcher("WEB-INF/content/index.jsp").forward(request, response);
		}else {
			ArrayList<Book> books=iBookDaoImpl.getBooksByCategory(category);
			System.out.println(category);
			
			request.setAttribute("cate", category);
			request.setAttribute("url", "index");
			request.setAttribute("books", books);
			request.getRequestDispatcher("WEB-INF/content/index.jsp").forward(request, response);
		}
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
