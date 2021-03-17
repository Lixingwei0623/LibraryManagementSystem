package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Reader;
import dao.impl.IReaderDaoImpl;

/**
 * Servlet implementation class ModifyPsw
 */
@WebServlet("/modifyPsw")
public class ModifyPsw extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IReaderDaoImpl iReaderDaoImpl=new IReaderDaoImpl();   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pwd1 = request.getParameter("password1");
		String pwd2 = request.getParameter("password2");
		if (pwd1==null||pwd1.equals("")) {
			request.setAttribute("url", "personalCenter");
			request.setAttribute("modifymessage", "psw");
			request.getRequestDispatcher("WEB-INF/content/modfiyPersonal.jsp").forward(request, response);			
		}else if (pwd1.equals(((Reader)request.getSession().getAttribute("reader")).getPassword())) {
			request.setAttribute("url", "personalCenter");
			request.setAttribute("result", "Yes");
			((Reader)request.getSession().getAttribute("reader")).setPassword(pwd2);
			iReaderDaoImpl.update((Reader)request.getSession().getAttribute("reader"));
			request.getRequestDispatcher("WEB-INF/content/personalCenter.jsp").forward(request, response);
		}else {
			request.setAttribute("url", "personalCenter");
			request.setAttribute("result", "No");
			request.setAttribute("modifymessage", "psw");
			request.getRequestDispatcher("WEB-INF/content/modfiyPersonal.jsp").forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
