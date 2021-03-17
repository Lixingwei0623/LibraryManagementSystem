package control;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.InfoBw;
import bean.Reader;
import dao.impl.IBorrowInfoDaoImpl;

/**
 * Servlet implementation class Borrow
 */
@WebServlet("/borrow")
public class Borrow extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IBorrowInfoDaoImpl iBorrowInfoDaoImpl=new IBorrowInfoDaoImpl();
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bidString = request.getParameter("bid");
		if (bidString!=null&&((Reader)request.getSession().getAttribute("reader"))!=null) {
			int bid=new Integer(bidString);
			int uid=((Reader)request.getSession().getAttribute("reader")).getUid();
			java.util.Date date=new java.util.Date();
			System.out.println(date.getDate());
			Date bwtime=new Date(date.getYear(),date.getMonth(),date.getDate());
			Date retime=new Date(date.getYear()+1,date.getMonth(),date.getDate());
			iBorrowInfoDaoImpl.insert(new InfoBw(0, uid, bid, bwtime, retime, false));
			System.out.println(request.getRequestURL());
			request.getRequestDispatcher("borrowManage").forward(request, response);
		}else if (((Reader)request.getSession().getAttribute("reader"))==null) {
			request.setAttribute("message", "请先登录");
			request.getRequestDispatcher("login").forward(request, response);
		}else {
			request.getRequestDispatcher("index").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
