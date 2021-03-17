/**   
 * 
 * <p>NameOfProject: LibraryManagementSystem </p> 
 * <p>NameOfFile: IReaderDaoImpl.java </p> 
 * <p>descripsion:  </p>
 * <p>date: 2020年7月28日 </p>
 * @author <a href="mail to: li_xing_wei@qq.com.com" rel="nofollow">lxw</a>
 * @version: v1.0.0
 * @author: 86135li_xingwei 
 */
package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import bean.Book;
import bean.Reader;
import dao.IReaderDao;
import dbutil.DBConnUtil;

/**   
* 
* @ClassName: IReaderDaoImpl.java
* @Description: 该类的功能描述
*
*
*/
public class IReaderDaoImpl implements IReaderDao {
	private Connection conn = DBConnUtil.getConn();

	/**   
	* @Function: IReaderDaoImpl.java
	* @Description: 该函数的功能描述
	*
	* @param:
	*/
	
	public IReaderDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see dao.IReaderDao#login(bean.Reader)
	 */
	@Override
	public ArrayList<Reader> login(Reader reader) {
		String sql = "select uid,account,password,uname,phnumber,sex,picture from reader where account=? and password=?;";
		PreparedStatement pstmt = null;
		ArrayList<Reader> list = null;
		System.out.println("登录中");
		try {
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, reader.getAccount());
			pstmt.setString(2, reader.getPassword());
			ResultSet rs = pstmt.executeQuery();	
			
			list = new ArrayList<Reader>();
			while(rs.next()) {
				int uid = rs.getInt("uid");
				String account=rs.getString("account");
				String password = rs.getString("password");
				String uname = rs.getString("uname");
				String phnumber = rs.getString("phnumber");				
				int sex = rs.getInt("sex");					
				String picture = rs.getString("picture");
				
				Reader reader2=new Reader(uid, account, password, uname, phnumber, sex, picture,false);
				
				list.add(reader2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnUtil.closeConn(null, null, pstmt, null);
		}
		return list;
	}

	/* (non-Javadoc)
	 * @see dao.IReaderDao#adminLogin(bean.Reader)
	 */
	@Override
	public ArrayList<Reader> adminLogin(Reader reader) {
		String sql = "select aid,account,password from administrator where account=? and password=?;";
		PreparedStatement pstmt = null;
		ArrayList<Reader> list = null;
		System.out.println("登录中");
		try {
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, reader.getAccount());
			pstmt.setString(2, reader.getPassword());
			ResultSet rs = pstmt.executeQuery();	
			
			list = new ArrayList<Reader>();
			while(rs.next()) {
				int aid = rs.getInt("aid");
				String account=rs.getString("account");
				String password = rs.getString("password");				
				
				Reader reader2=new Reader(aid, account, password,true);
				
				list.add(reader2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnUtil.closeConn(null, null, pstmt, null);
		}
		return list;
	}

	/* (non-Javadoc)
	 * @see dao.IReaderDao#update(bean.Reader)
	 */
	@Override
	public int update(Reader reader) {
		if (reader==null) {
			return 0;
		}else if (reader.isAdmin()) {
			String sql = "update administrator set password=? where account=?;";
			PreparedStatement pstmt = null;			
			System.out.println("修改中admin用户");
			int i=0;
			try {
				pstmt = conn.prepareStatement(sql); 				
				pstmt.setString(1, reader.getPassword());				
				pstmt.setString(2, reader.getAccount());
				i = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DBConnUtil.closeConn(null, null, pstmt, null);
			}
			return i;
		}else {
			String sql = "update reader set password=?,uname=?,sex=?,phnumber=?,picture=? where account=?;";
			PreparedStatement pstmt = null;			
			System.out.println("修改中普通用户");
			int i=0;
			try {
				pstmt = conn.prepareStatement(sql); 
				
				pstmt.setString(1, reader.getPassword());
				pstmt.setString(2, reader.getUname());
				pstmt.setInt(3, reader.getSex());
				pstmt.setString(4, reader.getPhnumber());
				pstmt.setString(5, reader.getPicture());
				pstmt.setString(6, reader.getAccount());
				i = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DBConnUtil.closeConn(null, null, pstmt, null);
			}
			return i;
		}
		
		
		
	}

	/* (non-Javadoc)
	 * @see dao.IReaderDao#isExit(bean.Reader)
	 */
	@Override
	public boolean isExist(Reader reader) {
		String sql = "select uid from reader where account=?;";
		PreparedStatement pstmt = null;
		int id=-1;
		System.out.println("查询中");
		try {
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, reader.getAccount());			
			ResultSet rs = pstmt.executeQuery();	
			
			while(rs.next()) {
				id = rs.getInt("uid");				
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
	 * @see dao.IReaderDao#insert(bean.Reader)
	 */
	@Override
	public int insert(Reader reader) {
		String sql = "insert into reader(account,password,uname,sex,phnumber,picture) values(?,?,?,?,?,?);";
		PreparedStatement pstmt = null;
		int i=0;
		System.out.println("注册中");
		try {
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, reader.getAccount());
			pstmt.setString(2, reader.getPassword());
			pstmt.setString(3, reader.getUname());
			pstmt.setInt(4, reader.getSex());
			pstmt.setString(5, reader.getPhnumber());
			pstmt.setString(6, reader.getPicture());
			i = pstmt.executeUpdate();			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnUtil.closeConn(null, null, pstmt, null);
		}
		return i;
		
	}

	/* (non-Javadoc)
	 * @see dao.IReaderDao#getAllReader()
	 */
	@Override
	public ArrayList<Reader> getAllReader() {
		String sql = "select uid,account,password,uname,phnumber,sex,picture from reader";
		PreparedStatement pstmt = null;
		ArrayList<Reader> list = null;		
		try {
			pstmt = conn.prepareStatement(sql); 			
			ResultSet rs = pstmt.executeQuery();	
			
			list = new ArrayList<Reader>();
			while(rs.next()) {
				int uid = rs.getInt("uid");
				String account=rs.getString("account");
				String password = rs.getString("password");
				String uname = rs.getString("uname");
				String phnumber = rs.getString("phnumber");				
				int sex = rs.getInt("sex");					
				String picture = rs.getString("picture");
				
				Reader reader2=new Reader(uid, account, password, uname, phnumber, sex, picture,false);
				
				list.add(reader2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnUtil.closeConn(null, null, pstmt, null);
		}
		return list;
	}

	/* (non-Javadoc)
	 * @see dao.IReaderDao#searchReaders(java.lang.String)
	 */
	@Override
	public ArrayList<Reader> searchReaders(String wd) {
		String sql = "select uid,account,password,uname,phnumber,sex,picture from reader where uname like ? or account=?";
		PreparedStatement pstmt = null;
		ArrayList<Reader> list = null;		
		try {
			pstmt = conn.prepareStatement(sql); 	
			pstmt.setString(1, "%"+wd+"%");
			pstmt.setString(2, wd);
			ResultSet rs = pstmt.executeQuery();
			
			list = new ArrayList<Reader>();
			while(rs.next()) {
				int uid = rs.getInt("uid");
				String account=rs.getString("account");
				String password = rs.getString("password");
				String uname = rs.getString("uname");
				String phnumber = rs.getString("phnumber");				
				int sex = rs.getInt("sex");					
				String picture = rs.getString("picture");
				
				Reader reader2=new Reader(uid, account, password, uname, phnumber, sex, picture,false);
				
				list.add(reader2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnUtil.closeConn(null, null, pstmt, null);
		}
		return list;
	}

	/* (non-Javadoc)
	 * @see dao.IReaderDao#delete(int)
	 */
	@Override
	public int delete(int uid) {
		String sql = "delete from reader where uid=?;";
		PreparedStatement pstmt = null;
		int i=0;
		System.out.println("删除中");
		try {
			pstmt = conn.prepareStatement(sql); 			
			pstmt.setInt(1, uid);			
			i = pstmt.executeUpdate();			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnUtil.closeConn(null, null, pstmt, null);
		}
		return i;
	}

}
