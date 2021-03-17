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
 * Servlet implementation class Logout
 */
@WebServlet("/logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;       
	private IBookDaoImpl iBookDaoImpl=new IBookDaoImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setAttribute("reader", null);
		ArrayList<Book> books=iBookDaoImpl.getBooksByRecommed();
		for (int i = 0; i < books.size(); i++) {
			System.out.println(books.get(i).getBname());
		}
		request.setAttribute("url", "index");
		request.setAttribute("books", books);
		request.getRequestDispatcher("WEB-INF/content/index.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
