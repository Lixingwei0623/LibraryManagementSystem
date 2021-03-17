package control;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Book;
import dao.impl.IBookDaoImpl;

/**
 * Servlet implementation class AddBook
 */
@WebServlet("/addBook")
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IBookDaoImpl iBookDaoImpl=new IBookDaoImpl();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String number = request.getParameter("number");
		String bname = request.getParameter("bname");		
		String author = request.getParameter("author");
		String publisher = request.getParameter("publisher");
		String category = request.getParameter("category");		
		String intro = request.getParameter("intro");
		String year=request.getParameter("year");
		String month=request.getParameter("month");
		String numString=request.getParameter("num");	
		
		String option= request.getParameter("optionsRadiosinline");
		System.out.println(number);
		if (number==null||number=="") {
			System.out.println("傻逼");
			request.setAttribute("url", "addBook");		
			request.getRequestDispatcher("WEB-INF/content/addBook.jsp").forward(request, response);
		}else if (iBookDaoImpl.isExist(number)) {
			request.setAttribute("url", "addBook");	
			request.setAttribute("infoAdd", "Exist");	
			request.getRequestDispatcher("WEB-INF/content/addBook.jsp").forward(request, response);
		}else {
			Date date=new Date(new Integer(year)-1900, new Integer(month), 1);
			int num=new Integer(numString);
			int recommed=new Integer(option.equals("option1")?1:0);
			Book book=new Book(0, number, bname, author, publisher, category, intro, date, recommed, num, "img/books/book.png");
			iBookDaoImpl.addBook(book);
			request.setAttribute("url", "addBook");	
			request.setAttribute("infoAdd", "Yes");	
			request.getRequestDispatcher("WEB-INF/content/addBook.jsp").forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
