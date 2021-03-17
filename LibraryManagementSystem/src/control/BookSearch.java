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
 * Servlet implementation class BookSearch
 */
@WebServlet("/bookSearch")
public class BookSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IBookDaoImpl iBookDaoImpl=new IBookDaoImpl();
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String wd = request.getParameter("wd");
		if (wd==null||wd=="") {
			request.setAttribute("url", "bookSearch");		
			request.getRequestDispatcher("WEB-INF/content/bookSearch.jsp").forward(request, response);
		}else {
			ArrayList<Book> books=iBookDaoImpl.searchBooks(wd);
			request.setAttribute("books", books);
			request.setAttribute("url", "bookSearch");
			request.getRequestDispatcher("WEB-INF/content/bookSearch.jsp").forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
