/**   
 * 
 * <p>NameOfProject: LibraryManagementSystem </p> 
 * <p>NameOfFile: InfoBw.java </p> 
 * <p>descripsion:  </p>
 * <p>date: 2020��7��8�� </p>
 * @author <a href="mail to: li_xing_wei@qq.com.com" rel="nofollow">lxw</a>
 * @version: v1.0.0
 * @author: 86135li_xingwei 
 */
package bean;

import java.sql.Date;

/**   
* 
* @ClassName: InfoBw.java
* @Description: ����Ĺ�������
*
*
*/
public class InfoBw {
	
	int brid;
	int uid;
	int bid;
	Date bwtime;
	Date retime;
	boolean flag;
	String uname;
	String bname;
	String category;

	/**   
	* @Function: InfoBw.java
	* @Description: 
	*
	* @param:
	*/
	public InfoBw() {
		// TODO Auto-generated constructor stub
	}

	/**   
	* @Function: InfoBw.java
	* @Description: 该函数的功能描述
	*
	* @param:@param brid
	* @param:@param uid
	* @param:@param bid
	* @param:@param bwtime
	* @param:@param retime
	* @param:@param flag
	*/
	public InfoBw(int brid, int uid, int bid, Date bwtime, Date retime, boolean flag) {
		super();
		this.brid = brid;
		this.uid = uid;
		this.bid = bid;
		this.bwtime = bwtime;
		this.retime = retime;
		this.flag = flag;
	}
	

	/**   
	* @Function: InfoBw.java
	* @Description: 该函数的功能描述
	*
	* @param:@param brid
	* @param:@param uid
	* @param:@param bid
	* @param:@param bwtime
	* @param:@param retime
	* @param:@param flag
	* @param:@param uname
	* @param:@param bname
	* @param:@param category
	*/
	public InfoBw(int brid, int uid, int bid, Date bwtime, Date retime, boolean flag, String uname, String bname,
			String category) {
		super();
		this.brid = brid;
		this.uid = uid;
		this.bid = bid;
		this.bwtime = bwtime;
		this.retime = retime;
		this.flag = flag;
		this.uname = uname;
		this.bname = bname;
		this.category = category;
	}

	public int getBrid() {
		return brid;
	}

	public void setBrid(int brid) {
		this.brid = brid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public Date getBwtime() {
		return bwtime;
	}

	public void setBwtime(Date bwtime) {
		this.bwtime = bwtime;
	}

	public Date getRetime() {
		return retime;
	}

	public void setRetime(Date retime) {
		this.retime = retime;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
