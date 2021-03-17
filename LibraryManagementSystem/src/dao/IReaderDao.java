/**   
 * 
 * <p>NameOfProject: LibraryManagementSystem </p> 
 * <p>NameOfFile: IReaderDao.java </p> 
 * <p>descripsion:  </p>
 * <p>date: 2020��7��8�� </p>
 * @author <a href="mail to: li_xing_wei@qq.com.com" rel="nofollow">lxw</a>
 * @version: v1.0.0
 * @author: 86135li_xingwei 
 */
package dao;

import java.util.ArrayList;

import bean.Reader;

/**   
* 
* @ClassName: IReaderDao.java
* @Description: ����Ĺ�������
*
*
*/
public interface IReaderDao {
	ArrayList<Reader> login(Reader reader);
	ArrayList<Reader> adminLogin(Reader reader);
	int update(Reader reader);
	boolean isExist(Reader reader);
	int insert(Reader reader);
	ArrayList<Reader> getAllReader();
	
	ArrayList<Reader> searchReaders(String wd);
	int delete(int uid);

}
