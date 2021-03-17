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
 * Servlet implementation class ModifiyBook
 */
@WebServlet("/modifiyBook")
public class ModifiyBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IBookDaoImpl iBookDaoImpl=new IBookDaoImpl();
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bidString = request.getParameter("bid");
		if (bidString==null||bidString=="") {
			String number = request.getParameter("number");
			System.out.println(number+"好家伙");
			if (number==null||number=="") {
				request.getRequestDispatcher("index").forward(request, response);
			}else {
				String bname = request.getParameter("bname");		
				String author = request.getParameter("author");
				String publisher = request.getParameter("publisher");
				String category = request.getParameter("category");		
				String intro = request.getParameter("intro");
				String year=request.getParameter("year");
				String month=request.getParameter("month");
				String day=request.getParameter("date");
				String numString=request.getParameter("num");
				bidString=request.getParameter("bid2");
				String picture=request.getParameter("picture");
				String option=request.getParameter("optionsRadiosinline");
				
				Date date=new Date(new Integer(year)-1900, new Integer(month)-1, new Integer(day));
				int num=new Integer(numString);
				int recommed=new Integer(option.equals("option1")?1:0);
				Book book=new Book(new Integer(bidString), number, bname, author, publisher, category, intro, date, recommed, num, "picture");
				iBookDaoImpl.updateBook(book);				
				request.setAttribute("infoUpdate", "Yes");	
				request.getRequestDispatcher("bookList").forward(request, response);
			}
			
			
		}else {
			int bid=new Integer(bidString);
			Book book=iBookDaoImpl.getBooksById(bid).get(0);
			request.setAttribute("book", book);
			request.getRequestDispatcher("WEB-INF/content/modifiyBook.jsp").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
