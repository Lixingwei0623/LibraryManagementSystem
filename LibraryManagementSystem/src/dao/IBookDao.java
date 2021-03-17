/**   
 * 
 * <p>NameOfProject: LibraryManagementSystem </p> 
 * <p>NameOfFile: IBookDao.java </p> 
 * <p>descripsion:  </p>
 * <p>date: 2020��7��8�� </p>
 * @author <a href="mail to: li_xing_wei@qq.com.com" rel="nofollow">lxw</a>
 * @version: v1.0.0
 * @author: 86135li_xingwei 
 */
package dao;

import java.util.ArrayList;

import bean.Book;

/**   
* 
* @ClassName: IBookDao.java
* @Description: 从数据库取书本信息
*
*
*/
public interface IBookDao {
	ArrayList<Book> getBooksByCategory(String cate);
	ArrayList<Book> getBooksByRecommed();
	boolean isExist(String number);
	int addBook(Book book);
	int updateBook(Book book);
	int deleteBook(int bid);
	ArrayList<Book> getBooksById(int bid);
	ArrayList<Book> getAllBooks();
	ArrayList<Book> searchBooks(String wd);

}
