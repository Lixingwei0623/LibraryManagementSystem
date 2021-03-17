package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.InfoBw;
import bean.Reader;
import dao.impl.IBorrowInfoDaoImpl;

/**
 * Servlet implementation class BorrowManage
 */
@WebServlet("/borrowManage")
public class BorrowManage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IBorrowInfoDaoImpl iBorrowInfoDaoImpl=new IBorrowInfoDaoImpl();
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Reader r=(Reader)request.getSession().getAttribute("reader");
		String bridRString = request.getParameter("bridR");
		String bridCString = request.getParameter("bridC");
		if (r==null) {
			request.setAttribute("url", "login");
			request.setAttribute("message", "请先登录");
			request.getRequestDispatcher("login").forward(request, response);
		}else {
			if (bridCString!=null&&bridCString!="") {
				int bridC=new Integer(bridCString);
				iBorrowInfoDaoImpl.continueBw(bridC);
			}
			if (bridRString!=null&&bridRString!="") {
				System.out.println(Integer.valueOf(bridRString));
				int bridR=Integer.valueOf(bridRString);
				System.out.println("草泥马");
				System.out.println(bridR);
				iBorrowInfoDaoImpl.returnBw(bridR);
			}
			if (!r.isAdmin()) {
				ArrayList<InfoBw> infosBw=iBorrowInfoDaoImpl.serachByReader(r.getUid());
				request.setAttribute("infosBw", infosBw);
				request.setAttribute("url", "borrowManage");
				request.getRequestDispatcher("WEB-INF/content/borrowManage.jsp").forward(request, response);
			}else {
				ArrayList<InfoBw> infosBw=iBorrowInfoDaoImpl.getAll();
				request.setAttribute("infosBw", infosBw);
				request.setAttribute("url", "borrowManage");
				request.getRequestDispatcher("WEB-INF/content/borrowManage.jsp").forward(request, response);
			}		
			
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
