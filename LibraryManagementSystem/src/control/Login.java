package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Reader;
import dao.impl.IReaderDaoImpl;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;   
	private IReaderDaoImpl iReaderDaoImpl=new IReaderDaoImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String n = request.getParameter("name");
		String pwd = request.getParameter("password");
		String option= request.getParameter("optionsRadiosinline");
		System.out.println(n+pwd+option);
		if(option==null||option=="") {
			request.setAttribute("url", "login");
			request.getRequestDispatcher("WEB-INF/content/login.jsp").forward(request, response);
		}else if (option.equals("option1")) {
			System.out.println("读者");
			ArrayList<Reader> readers= iReaderDaoImpl.login(new Reader(n, pwd,false));
			if (readers.size()==0) {
				System.out.println("账号或密码错误，请重新登录");
				request.setAttribute("infoLogin", "账号或密码错误，请重新登录");
				request.setAttribute("url", "login");
				request.getRequestDispatcher("WEB-INF/content/login.jsp").forward(request, response);
				
			}else {
				System.out.println("成功");
				request.getSession().setAttribute("reader", readers.get(0));
				request.getSession().setAttribute("isAdmin", false);
				request.getRequestDispatcher("index").forward(request, response);
				
			}
		}else if (option.equals("option2")) {
			ArrayList<Reader> readers= iReaderDaoImpl.adminLogin(new Reader(n, pwd,true));
			if (readers.size()==0) {
				System.out.println("账号或密码错误，请重新登录");
				request.setAttribute("infoLogin", "账号或密码错误，请重新登录");
				request.setAttribute("url", "login");
				request.getRequestDispatcher("WEB-INF/content/login.jsp").forward(request, response);
				
			}else {
				System.out.println("成功");
				request.getSession().setAttribute("reader", readers.get(0));
				request.getSession().setAttribute("isAdmin", true);
				request.getRequestDispatcher("index").forward(request, response);
				
			}			
		}else {			
			request.setAttribute("url", "login");
			request.getRequestDispatcher("WEB-INF/content/login.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
