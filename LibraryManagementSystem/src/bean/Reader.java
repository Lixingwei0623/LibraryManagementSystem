/**   
 * 
 * <p>NameOfProject: LibraryManagementSystem </p> 
 * <p>NameOfFile: Reader.java </p> 
 * <p>descripsion:  </p>
 * <p>date: 2020��7��8�� </p>
 * @author <a href="mail to: li_xing_wei@qq.com.com" rel="nofollow">lxw</a>
 * @version: v1.0.0
 * @author: 86135li_xingwei 
 */
package bean;

import java.util.Date;

/**   
* 
* @ClassName: Reader.java
* @Description: 
*
*
*/
public class Reader {
	private int uid;//Id
	private String account;//账号
	private String password;//密码
	private String uname;//姓名
	private String phnumber;//电话号码
	private int sex;//性别  0为女，1为男	
	private String picture;//封面图片路径
	private boolean isAdmin;
	/**   
	* @Function: Reader.java
	* @Description: 该函数的功能描述
	*
	* @param:@param account
	* @param:@param password
	*/
	public Reader(String account, String password) {
		super();
		this.account = account;
		this.password = password;
	}


	/**   
	* @Function: Reader.java
	* @Description: 该函数的功能描述
	*
	* @param:@param account
	* @param:@param password
	* @param:@param isAdmin
	*/
	public Reader(String account, String password, boolean isAdmin) {
		super();
		this.account = account;
		this.password = password;
		this.isAdmin = isAdmin;
	}


	/**   
	* @Function: Reader.java
	* @Description: 该函数的功能描述
	*
	* @param:@param uid
	* @param:@param account
	* @param:@param password
	*/
	public Reader(int uid, String account, String password) {
		super();
		this.uid = uid;
		this.account = account;
		this.password = password;
	}


	/**   
	* @Function: Reader.java
	* @Description: 该函数的功能描述
	*
	* @param:@param uid
	* @param:@param account
	* @param:@param password
	* @param:@param isAdmin
	*/
	public Reader(int uid, String account, String password, boolean isAdmin) {
		super();
		this.uid = uid;
		this.account = account;
		this.password = password;
		this.isAdmin = isAdmin;
	}


	/**   
	* @Function: Reader.java
	* @Description: 该函数的功能描述
	*
	* @param:@param uid
	* @param:@param account
	* @param:@param password
	* @param:@param uname
	* @param:@param phnumber
	* @param:@param sex
	* @param:@param picture
	*/
	public Reader(int uid, String account, String password, String uname, String phnumber, int sex, String picture) {
		super();
		this.uid = uid;
		this.account = account;
		this.password = password;
		this.uname = uname;
		this.phnumber = phnumber;
		this.sex = sex;
		this.picture = picture;
	}


	/**   
	* @Function: Reader.java
	* @Description: 该函数的功能描述
	*
	* @param:@param uid
	* @param:@param account
	* @param:@param password
	* @param:@param uname
	* @param:@param phnumber
	* @param:@param sex
	* @param:@param picture
	* @param:@param isAdmin
	*/
	public Reader(int uid, String account, String password, String uname, String phnumber, int sex, String picture,
			boolean isAdmin) {
		super();
		this.uid = uid;
		this.account = account;
		this.password = password;
		this.uname = uname;
		this.phnumber = phnumber;
		this.sex = sex;
		this.picture = picture;
		this.isAdmin = isAdmin;
	}


	public int getUid() {
		return uid;
	}


	public void setUid(int uid) {
		this.uid = uid;
	}


	public String getAccount() {
		return account;
	}


	public void setAccount(String account) {
		this.account = account;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getUname() {
		return uname;
	}


	public void setUname(String uname) {
		this.uname = uname;
	}


	public String getPhnumber() {
		return phnumber;
	}


	public void setPhnumber(String phnumber) {
		this.phnumber = phnumber;
	}


	public int getSex() {
		return sex;
	}


	public void setSex(int sex) {
		this.sex = sex;
	}


	public String getPicture() {
		return picture;
	}


	public void setPicture(String picture) {
		this.picture = picture;
	}


	

	
	public boolean isAdmin() {
		return isAdmin;
	}


	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}


	public Reader() {
		// TODO Auto-generated constructor stub
	}

}
