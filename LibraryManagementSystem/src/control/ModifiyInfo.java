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
 * Servlet implementation class ModifiyInfo
 */
@WebServlet("/modifiyInfo")
public class ModifiyInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IReaderDaoImpl iReaderDaoImpl=new IReaderDaoImpl();   
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("uname");
		String sex = request.getParameter("optionsRadiosinline");
		String phnumber = request.getParameter("phnumber");
		if (name==null) {
			request.setAttribute("url", "personalCenter");
			request.setAttribute("modifymessage", "info");
			request.getRequestDispatcher("WEB-INF/content/modfiyPersonal.jsp").forward(request, response);
		}else if (name.equals("")||phnumber.equals("")) {
			request.setAttribute("url", "personalCenter");
			request.setAttribute("resultInfo", "No");
			request.setAttribute("modifymessage", "info");
			request.getRequestDispatcher("WEB-INF/content/modfiyPersonal.jsp").forward(request, response);
		}else if (((Reader)request.getSession().getAttribute("reader"))!=null){
			request.setAttribute("url", "personalCenter");
			request.setAttribute("resultInfo", "Yes");
			((Reader)request.getSession().getAttribute("reader")).setUname(name);
			((Reader)request.getSession().getAttribute("reader")).setSex(sex.equals("option1")?1:0);			
			((Reader)request.getSession().getAttribute("reader")).setPhnumber(phnumber);
			iReaderDaoImpl.update((Reader)request.getSession().getAttribute("reader"));
			request.getRequestDispatcher("WEB-INF/content/personalCenter.jsp").forward(request, response);
		}else {
			request.setAttribute("url", "personalCenter");
			request.setAttribute("modifymessage", "info");
			request.getRequestDispatcher("WEB-INF/content/modfiyPersonal.jsp").forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
