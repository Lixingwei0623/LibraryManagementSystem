package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Book;
import bean.Reader;
import dao.impl.IReaderDaoImpl;

/**
 * Servlet implementation class ReaderList
 */
@WebServlet("/readerList")
public class ReaderList extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IReaderDaoImpl iReaderDaoImpl=new IReaderDaoImpl();   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String wd = request.getParameter("wd");
		String uidString = request.getParameter("uid");
		if (uidString!=null) {
			int uid=new Integer(uidString);
			iReaderDaoImpl.delete(uid);
		}		
		if (wd==null||wd=="") {
			ArrayList<Reader> readers=iReaderDaoImpl.getAllReader();
			request.setAttribute("readers", readers);
			request.setAttribute("url", "readerList");		
			request.getRequestDispatcher("WEB-INF/content/readerList.jsp").forward(request, response);
		}else {
			ArrayList<Reader> readers=iReaderDaoImpl.searchReaders(wd);
			request.setAttribute("readers", readers);
			request.setAttribute("url", "readerList");
			request.getRequestDispatcher("WEB-INF/content/readerList.jsp").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
