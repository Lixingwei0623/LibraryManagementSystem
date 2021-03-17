package dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnUtil {
	private static String url ="jdbc:mysql://localhost:3306/library?useSSL=false&characterEncoding=utf8&serverTimezone=UTC";
	private static String user="root";
	private static String password ="lixingwei123";
	private static String classname ="com.mysql.jdbc.Driver";
	private static Connection conn = null;
	
	
	// 通过静态块加载数据驱动
		static{
			try {
				Class.forName(classname);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.out.println("傻逼");
			}
		}
		
		// 获取数据库连接
		public static Connection getConn(){
			synchronized (DBConnUtil.class) {
				try {
					if(null == conn || conn.isClosed()) {
						synchronized (DBConnUtil.class) {
							try {
								conn = DriverManager.getConnection(url, user, password);
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			System.out.println(1);
			System.out.println(1);
			System.out.println(conn);
			return conn;
		}
		
		// 关闭连接
		public static void closeConn(ResultSet rs,Statement st,PreparedStatement pst,Connection conn){
			try {
				if(rs != null){
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				try {
					if(st != null){
						st.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					try {
						if(pst != null){
							pst.close();
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}finally{
						try {
							if(conn != null && !conn.isClosed()){
								conn.close();
							}
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				}
			} 
		}
	}