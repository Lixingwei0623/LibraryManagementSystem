package control;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Book;
import bean.Reader;
import dao.impl.IReaderDaoImpl;

/**
 * Servlet implementation class AddReader
 */
@WebServlet("/addReader")
public class AddReader extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IReaderDaoImpl iReaderDaoImpl=new IReaderDaoImpl();   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account = request.getParameter("account");
		String password = request.getParameter("password");		
		String uname = request.getParameter("uname");
		String option = request.getParameter("optionsRadiosinline");
		String phnumber = request.getParameter("phnumber");		
		String picture = request.getParameter("picture");
		if (account==null||account=="") {
			System.out.println("傻逼");
			request.setAttribute("url", "addReader");		
			request.getRequestDispatcher("WEB-INF/content/addReader.jsp").forward(request, response);
		}else if (iReaderDaoImpl.isExist(new Reader(account, password))) {
			request.setAttribute("url", "addReader");	
			request.setAttribute("infoAdd", "Exist");	
			request.getRequestDispatcher("WEB-INF/content/addReader.jsp").forward(request, response);
		}else {
			int sex=new Integer(option.equals("option1")?1:0);
			Reader reader=new Reader(0, account, password, uname, phnumber, sex, picture);
			iReaderDaoImpl.insert(reader);
			request.setAttribute("url", "addReader");	
			request.setAttribute("infoAdd", "Yes");	
			request.getRequestDispatcher("WEB-INF/content/addReader.jsp").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
