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
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IReaderDaoImpl iReaderDaoImpl=new IReaderDaoImpl();   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account = request.getParameter("account");
		String pwd = request.getParameter("password1");		
		String name = request.getParameter("name");
		String phnumber = request.getParameter("phnumber");
		String option= request.getParameter("optionsRadiosinline");
		if (account==null||account=="") {
			request.setAttribute("url", "register");
			request.getRequestDispatcher("WEB-INF/content/register.jsp").forward(request, response);
		}else if (iReaderDaoImpl.isExist(new Reader(account, "123456"))) {
			request.setAttribute("url", "register");
			request.setAttribute("infoRegister", "Exist");
			request.getRequestDispatcher("WEB-INF/content/register.jsp").forward(request, response);
		}else {
			iReaderDaoImpl.insert(new Reader(0, account, pwd, name, phnumber, option.equals("option1")?1:0, "user.png", false));
			ArrayList<Reader> readers= iReaderDaoImpl.login(new Reader(account, pwd,false));
			if (readers.size()==0) {
				System.out.println("注册登录失败，请重新注册");
				request.setAttribute("infoLogin", "注册登录失败，请重新注册");
				request.setAttribute("url", "register");
				request.getRequestDispatcher("WEB-INF/content/register.jsp").forward(request, response);
				
			}else {
				System.out.println("成功");
				request.getSession().setAttribute("reader", readers.get(0));				
				request.getRequestDispatcher("index").forward(request, response);
				
			}
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
