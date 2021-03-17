/**   
 * 
 * <p>NameOfProject: LibraryManagementSystem </p> 
 * <p>NameOfFile: IBookDaoImpl.java </p> 
 * <p>descripsion:  </p>
 * <p>date: 2020年7月26日 </p>
 * @author <a href="mail to: li_xing_wei@qq.com.com" rel="nofollow">lxw</a>
 * @version: v1.0.0
 * @author: 86135li_xingwei 
 */
package dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

import org.apache.catalina.User;

import java.sql.PreparedStatement;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import bean.Book;
import dao.IBookDao;
import dbutil.DBConnUtil;

/**   
* 
* @ClassName: IBookDaoImpl.java
* @Description: 该类的功能描述
*
*
*/
public class IBookDaoImpl implements IBookDao {
	private Connection conn = DBConnUtil.getConn();

	/**   
	* @Function: IBookDaoImpl.java
	* @Description: 该函数的功能描述
	*
	* @param:
	*/
	public IBookDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see dao.IBookDao#getBooksByCategory(java.lang.String)
	 */
	@Override
	public ArrayList<Book> getBooksByCategory(String cate) {
		String sql = "select bid,number,bname,author,publisher,category,intro,pubtime,recommed,num,picture from book where category=?;";
		PreparedStatement pstmt = null;
		ArrayList<Book> list = null;
		try {
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, cate);
			ResultSet rs = pstmt.executeQuery();	
			
			list = new ArrayList<Book>();
			while(rs.next()) {
				int bid = rs.getInt("bid");
				String number=rs.getString("number");
				String bname = rs.getString("bname");
				String author = rs.getString("author");
				String publisher = rs.getString("publisher");
				String category = rs.getString("category");
				String intro = rs.getString("intro");
				Date pubtime = rs.getDate("pubtime");
				int recommed = rs.getInt("recommed");
				int num = rs.getInt("num");				
				String picture = rs.getString("picture");
				
				Book book=new Book(bid, number, bname, author, publisher, category, intro, pubtime, recommed, num, picture);
				
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnUtil.closeConn(null, null, pstmt, null);
		}
		return list;
	}
	public static void main(String[] args) {
		IBookDaoImpl iBookDaoImpl=new IBookDaoImpl();
		ArrayList<Book> list= iBookDaoImpl.getBooksByRecommed();
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getBname());
		}
	}

	/* (non-Javadoc)
	 * @see dao.IBookDao#getBooksByRecommed()
	 */
	@Override
	public ArrayList<Book> getBooksByRecommed() {
		String sql = "select bid,number,bname,author,publisher,category,intro,pubtime,num,picture from book where recommed=1;";
		PreparedStatement pstmt = null;
		ArrayList<Book> list = null;
		try {
			System.out.println(conn);
			pstmt = conn.prepareStatement(sql); 
			ResultSet rs = pstmt.executeQuery();			
			list = new ArrayList<Book>();
			while(rs.next()) {
				int bid = rs.getInt("bid");
				String number=rs.getString("number");
				String bname = rs.getString("bname");
				String author = rs.getString("author");
				String publisher = rs.getString("publisher");
				String category = rs.getString("category");
				String intro = rs.getString("intro");
				Date pubtime = rs.getDate("pubtime");
				System.out.println(pubtime.getDate());
				int num = rs.getInt("num");				
				String picture = rs.getString("picture");
				
				Book book=new Book(bid, number, bname, author, publisher, category, intro, pubtime, 1, num, picture);
				
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnUtil.closeConn(null, null, pstmt, null);
		}
		return list;
	}

	/* (non-Javadoc)
	 * @see dao.IBookDao#isExist(java.lang.String)
	 */
	@Override
	public boolean isExist(String number) {
		String sql = "select bid from book where number=?;";
		PreparedStatement pstmt = null;
		int id=-1;
		System.out.println("查询中");
		try {
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, number);			
			ResultSet rs = pstmt.executeQuery();	
			
			while(rs.next()) {
				id = rs.getInt("bid");				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnUtil.closeConn(null, null, pstmt, null);
		}
		if (id==-1) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see dao.IBookDao#addBook(bean.Book)
	 */
	@Override
	public int addBook(Book book) {
		String sql = "insert into book(number,bname,author,publisher,category,intro,pubtime,recommed,num,picture) values(?,?,?,?,?,?,?,?,?,?);";
		PreparedStatement pstmt = null;
		int i=0;
		System.out.println("注册中");
		try {
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, book.getNumber());
			pstmt.setString(2, book.getBname());
			pstmt.setString(3, book.getAuthor());
			pstmt.setString(4, book.getPublisher());
			pstmt.setString(5, book.getCategory());
			pstmt.setString(6, book.getIntro());
			pstmt.setDate(7, book.getPubtime());
			pstmt.setInt(8, book.getRecommed());
			pstmt.setInt(9, book.getNum());
			pstmt.setString(10, book.getPicture());
			i = pstmt.executeUpdate();			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnUtil.closeConn(null, null, pstmt, null);
		}
		return i;
	}

	/* (non-Javadoc)
	 * @see dao.IBookDao#getBooksById(int)
	 */
	@Override
	public ArrayList<Book> getBooksById(int bid) {
		String sql = "select bid,number,bname,author,publisher,category,intro,pubtime,recommed,num,picture from book where bid=?;";
		PreparedStatement pstmt = null;
		ArrayList<Book> list = null;
		try {
			pstmt = conn.prepareStatement(sql); 
			pstmt.setInt(1, bid);
			ResultSet rs = pstmt.executeQuery();	
			
			list = new ArrayList<Book>();
			while(rs.next()) {
				int id = rs.getInt("bid");
				String number=rs.getString("number");
				String bname = rs.getString("bname");
				String author = rs.getString("author");
				String publisher = rs.getString("publisher");
				String category = rs.getString("category");
				String intro = rs.getString("intro");
				Date pubtime = rs.getDate("pubtime");
				int recommed = rs.getInt("recommed");
				int num = rs.getInt("num");				
				String picture = rs.getString("picture");
				
				Book book=new Book(id, number, bname, author, publisher, category, intro, pubtime, recommed, num, picture);
				
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnUtil.closeConn(null, null, pstmt, null);
		}
		return list;
	}

	/* (non-Javadoc)
	 * @see dao.IBookDao#getAllBooks()
	 */
	@Override
	public ArrayList<Book> getAllBooks() {
		String sql = "select bid,number,bname,author,publisher,category,intro,pubtime,recommed,num,picture from book";
		PreparedStatement pstmt = null;
		ArrayList<Book> list = null;
		try {
			System.out.println(conn);
			pstmt = conn.prepareStatement(sql); 
			ResultSet rs = pstmt.executeQuery();			
			list = new ArrayList<Book>();
			while(rs.next()) {
				int bid = rs.getInt("bid");
				String number=rs.getString("number");
				String bname = rs.getString("bname");
				String author = rs.getString("author");
				String publisher = rs.getString("publisher");
				String category = rs.getString("category");
				String intro = rs.getString("intro");
				Date pubtime = rs.getDate("pubtime");
				int recommed = rs.getInt("recommed");	
				int num = rs.getInt("num");				
				String picture = rs.getString("picture");
				
				Book book=new Book(bid, number, bname, author, publisher, category, intro, pubtime, recommed, num, picture);
				
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnUtil.closeConn(null, null, pstmt, null);
		}
		return list;
	}

	/* (non-Javadoc)
	 * @see dao.IBookDao#updateBook(bean.Book)
	 */
	@Override
	public int updateBook(Book book) {
		String sql = "update book set number=?,bname=?,author=?,publisher=?,category=?,intro=?,pubtime=?,recommed=?,num=? where bid=?;";
		PreparedStatement pstmt = null;
		int i=0;
		System.out.println("修改中");
		try {
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, book.getNumber());
			pstmt.setString(2, book.getBname());
			pstmt.setString(3, book.getAuthor());
			pstmt.setString(4, book.getPublisher());
			pstmt.setString(5, book.getCategory());
			pstmt.setString(6, book.getIntro());
			pstmt.setDate(7, book.getPubtime());
			pstmt.setInt(8, book.getRecommed());
			pstmt.setInt(9, book.getNum());
			pstmt.setInt(10, book.getBid());
			System.out.println(book.getBname());
			i = pstmt.executeUpdate();			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnUtil.closeConn(null, null, pstmt, null);
		}
		return i;
	}

	/* (non-Javadoc)
	 * @see dao.IBookDao#deleteBook(int)
	 */
	@Override
	public int deleteBook(int bid) {
		String sql = "delete from book where bid=?;";
		PreparedStatement pstmt = null;
		int i=0;
		System.out.println("删除中");
		try {
			pstmt = conn.prepareStatement(sql); 			
			pstmt.setInt(1, bid);			
			i = pstmt.executeUpdate();			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnUtil.closeConn(null, null, pstmt, null);
		}
		return i;
	}

	/* (non-Javadoc)
	 * @see dao.IBookDao#searchBooks(java.lang.String)
	 */
	@Override
	public ArrayList<Book> searchBooks(String wd) {
		String sql = "select bid,number,bname,author,publisher,category,intro,pubtime,recommed,num,picture from book where bname like ? or author like ? or number=?;";
		PreparedStatement pstmt = null;
		ArrayList<Book> list = null;
		try {
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, "%"+wd+"%");
			pstmt.setString(2, "%"+wd+"%");
			pstmt.setString(3, wd);
			ResultSet rs = pstmt.executeQuery();	
			
			list = new ArrayList<Book>();
			while(rs.next()) {
				int id = rs.getInt("bid");
				String number=rs.getString("number");
				String bname = rs.getString("bname");
				String author = rs.getString("author");
				String publisher = rs.getString("publisher");
				String category = rs.getString("category");
				String intro = rs.getString("intro");
				Date pubtime = rs.getDate("pubtime");
				int recommed = rs.getInt("recommed");
				int num = rs.getInt("num");				
				String picture = rs.getString("picture");
				
				Book book=new Book(id, number, bname, author, publisher, category, intro, pubtime, recommed, num, picture);
				
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnUtil.closeConn(null, null, pstmt, null);
		}
		return list;
	}
	

}
