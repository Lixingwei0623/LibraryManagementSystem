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
 * Servlet implementation class BookList
 */
@WebServlet("/bookList")
public class BookList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private IBookDaoImpl iBookDaoImpl=new IBookDaoImpl();    
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bid = request.getParameter("bid");
		if (bid!=null&&bid!="") {
			iBookDaoImpl.deleteBook(new Integer(bid));
		}
		ArrayList<Book> books=iBookDaoImpl.getAllBooks();
		request.setAttribute("url", "bookList");		
		request.setAttribute("books", books);
		request.getRequestDispatcher("WEB-INF/content/bookList.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
