/**   
 * 
 * <p>NameOfProject: LibraryManagementSystem </p> 
 * <p>NameOfFile: IBorrowInfoDaoImpl.java </p> 
 * <p>descripsion:  </p>
 * <p>date: 2020年8月4日 </p>
 * @author <a href="mail to: li_xing_wei@qq.com.com" rel="nofollow">lxw</a>
 * @version: v1.0.0
 * @author: 86135li_xingwei 
 */
package dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sound.midi.MidiDevice.Info;

import bean.Book;
import bean.InfoBw;
import dao.IBorrowInfoDao;
import dbutil.DBConnUtil;

/**   
* 
* @ClassName: IBorrowInfoDaoImpl.java
* @Description: 该类的功能描述
*
*
*/
public class IBorrowInfoDaoImpl implements IBorrowInfoDao {
	private Connection conn = DBConnUtil.getConn();

	/**   
	* @Function: IBorrowInfoDaoImpl.java
	* @Description: 该函数的功能描述
	*
	* @param:
	*/
	public IBorrowInfoDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see dao.IBorrowInfoDao#insert(bean.InfoBw)
	 */
	@Override
	public int insert(InfoBw infoBw) {
		String sql = "insert into borrowinfo(uid,bid,bwtime,retime,flag) values(?,?,?,?,?);";
		PreparedStatement pstmt = null;
		int i=0;
		System.out.println("借阅中");
		try {
			pstmt = conn.prepareStatement(sql); 
			pstmt.setInt(1, infoBw.getUid());
			pstmt.setInt(2, infoBw.getBid());
			pstmt.setDate(3, infoBw.getBwtime());
			pstmt.setDate(4, infoBw.getRetime());
			pstmt.setInt(5, infoBw.isFlag()?1:0);			
			i = pstmt.executeUpdate();			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnUtil.closeConn(null, null, pstmt, null);
		}
		return i;
	}

	/* (non-Javadoc)
	 * @see dao.IBorrowInfoDao#serachByReader(int)
	 */
	@Override
	public ArrayList<InfoBw> serachByReader(int uid) {
		String sql = "select bname,uname,category, brid,borrowinfo.bid,borrowinfo.uid, bwtime, retime, flag from borrowinfo,book,reader where borrowinfo.bid=book.bid&&borrowinfo.uid=reader.uid&&borrowinfo.uid=?;";
		PreparedStatement pstmt = null;
		ArrayList<InfoBw> list = null;
		try {
			pstmt = conn.prepareStatement(sql); 
			pstmt.setInt(1, uid);
			ResultSet rs = pstmt.executeQuery();	
			
			list = new ArrayList<InfoBw>();
			while(rs.next()) {
				
				String bname = rs.getString("bname");
				String uname = rs.getString("uname");
							
				String category = rs.getString("category");
				int brid = rs.getInt("brid");
				int bid = rs.getInt("bid");
//				int uid = rs.getInt("uid");
				Date bwtime = rs.getDate("bwtime");
				Date retime = rs.getDate("retime");				
				int flag = rs.getInt("flag");				
				
				
				InfoBw info=new InfoBw(brid, uid, bid, bwtime, retime, flag==1?true:false, uname, bname, category);
				
				list.add(info);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnUtil.closeConn(null, null, pstmt, null);
		}
		return list;
	}

	/* (non-Javadoc)
	 * @see dao.IBorrowInfoDao#serachByBook(int)
	 */
	@Override
	public ArrayList<InfoBw> serachByBook(int bid) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see dao.IBorrowInfoDao#getAll()
	 */
	@Override
	public ArrayList<InfoBw> getAll() {
		String sql = "select bname,uname,category, brid,borrowinfo.bid,borrowinfo.uid, bwtime, retime, flag from borrowinfo,book,reader where borrowinfo.bid=book.bid&&borrowinfo.uid=reader.uid;";
		PreparedStatement pstmt = null;
		ArrayList<InfoBw> list = null;
		try {
			pstmt = conn.prepareStatement(sql); 			
			ResultSet rs = pstmt.executeQuery();	
			
			list = new ArrayList<InfoBw>();
			while(rs.next()) {
				
				String bname = rs.getString("bname");
				String uname = rs.getString("uname");
							
				String category = rs.getString("category");
				int brid = rs.getInt("brid");
				int bid = rs.getInt("bid");
				int uid = rs.getInt("uid");
				Date bwtime = rs.getDate("bwtime");
				Date retime = rs.getDate("retime");				
				int flag = rs.getInt("flag");				
				
				
				InfoBw info=new InfoBw(brid, uid, bid, bwtime, retime, flag==1?true:false, uname, bname, category);
				
				list.add(info);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnUtil.closeConn(null, null, pstmt, null);
		}
		return list;
	}

	/* (non-Javadoc)
	 * @see dao.IBorrowInfoDao#continueBw(int)
	 */
	@Override
	public int continueBw(int brid) {
		String sql1 = "select retime from borrowinfo where brid=?";
		PreparedStatement pstmt = null;			
		Date retime=null;
		int i=0;
		try {
			pstmt = conn.prepareStatement(sql1); 							
			pstmt.setInt(1, brid);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {					
				retime = rs.getDate("retime");		
				retime.setMonth(retime.getMonth()+1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnUtil.closeConn(null, null, pstmt, null);
		}
		String sql2 = "update borrowinfo set retime=? where brid=?;";
		pstmt = null;			
		System.out.println("续借");	
		
		try {			
			pstmt = conn.prepareStatement(sql2); 				
			pstmt.setDate(1, retime);				
			pstmt.setInt(2, brid);
			i = i+pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnUtil.closeConn(null, null, pstmt, null);
		}
		return i;
	}

	/* (non-Javadoc)
	 * @see dao.IBorrowInfoDao#returnBw(int)
	 */
	@Override
	public int returnBw(int brid) {
		String sql = "update borrowinfo set flag=? where brid=?;";
		PreparedStatement pstmt = null;			
		System.out.println("还书");
		int i=0;
		try {
			pstmt = conn.prepareStatement(sql); 				
			pstmt.setInt(1, 1);				
			pstmt.setInt(2, brid);
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnUtil.closeConn(null, null, pstmt, null);
		}
		return i;
	}

}
