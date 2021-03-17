/**   
 * 
 * <p>NameOfProject: LibraryManagementSystem </p> 
 * <p>NameOfFile: Book.java </p> 
 * <p>descripsion:  </p>
 * <p>date: 2020年7月8日 </p>
 * @author <a href="mail to: li_xing_wei@qq.com.com" rel="nofollow">lxw</a>
 * @version: v1.0.0
 * @author: 86135li_xingwei 
 */
package bean;

import java.sql.Date;

/**   
* 
* @ClassName: Book.java
* @Description: 该类的功能描述
*
*
*/
public class Book {
	
	private int bid;//Id
	private String number;//书号
	private String bname;//书名
	private String author;//作者
	private String publisher;//出版社
	private String category;//分类
	private String intro;//简介
	private Date pubtime;//出版时间
	private int recommed;//是否推荐  0为不推荐，1为推荐
	private int num;//数量
	private String picture;//封面图片路径

	/**   
	* @Function: Book.java
	* @Description: 该函数的功能描述
	*
	* @param:
	*/
	public Book() {
		// TODO Auto-generated constructor stub
	}
	

	/**   
	* @Function: Book.java
	* @Description: 该函数的功能描述
	*
	* @param:@param bid
	* @param:@param number
	* @param:@param bname
	* @param:@param author
	* @param:@param publisher
	* @param:@param category
	* @param:@param intro
	* @param:@param pubtime
	* @param:@param recommed
	* @param:@param num
	* @param:@param picture
	*/
	public Book(int bid, String number, String bname, String author, String publisher, String category, String intro,
			Date pubtime, int recommed, int num, String picture) {		
		this.bid = bid;
		this.number = number;
		this.bname = bname;
		this.author = author;
		this.publisher = publisher;
		this.category = category;
		this.intro = intro;
		this.pubtime = pubtime;
		this.recommed = recommed;
		this.num = num;
		this.picture = picture;
	}


	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getIntro() {
		return intro;
	}
	
	public void setIntro(String intro) {
		this.intro = intro;
	}

	public Date getPubtime() {
		return pubtime;
	}

	public void setPubtime(Date pubtime) {
		this.pubtime = pubtime;
	}

	public int getRecommed() {
		return recommed;
	}

	public void setRecommed(int recommed) {
		this.recommed = recommed;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

}
