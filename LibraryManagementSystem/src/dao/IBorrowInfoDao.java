/**   
 * 
 * <p>NameOfProject: LibraryManagementSystem </p> 
 * <p>NameOfFile: IBorrowInfoDao.java </p> 
 * <p>descripsion:  </p>
 * <p>date: 2020年7月8日 </p>
 * @author <a href="mail to: li_xing_wei@qq.com.com" rel="nofollow">lxw</a>
 * @version: v1.0.0
 * @author: 86135li_xingwei 
 */
package dao;

import java.util.ArrayList;

import bean.InfoBw;

/**   
* 
* @ClassName: IBorrowInfoDao.java
* @Description: 该类的功能描述
*
*
*/
public interface IBorrowInfoDao {
	int insert(InfoBw infoBw);
	ArrayList<InfoBw> serachByReader(int uid);
	ArrayList<InfoBw> serachByBook(int bid);
	ArrayList<InfoBw> getAll();
	int continueBw(int brid);
	int returnBw(int brid);

}
