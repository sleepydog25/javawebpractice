package mvc.user.dao;

import java.util.List;

import mvc.user.model.po.Statistics;
import mvc.user.model.po.User;

public interface UserDao {
	int addUser(User user);

	int updateUser(Integer id, User user);

	int deleteUser(Integer id);

	User getUserById(Integer id);

	List<User> findAllUsers();
	
	//性別統計
	List<Statistics> queryGenderStatistics();
	
	//學歷統計
	List<Statistics> queryEducationStatistics();
	
	/*
	 * SQL language -- 性別統計
	 * 
	 * SELECT a.gender_id as id, b.item_name as name, count(*) as count
	 * 
	 * FROM user a, base_data b
	 * 
	 * where a.gender_id = b.item_id and b.group_name = 'Gender'
	 * 
	 * group by a.gender_id, b.item_name
	 * 
	 * -- 學歷統計
	 * 
	 * SELECT a.education_id as id, b.item_name as name, count(*) as count FROM user
	 * a, base_data b where a.education_id = b.item_id and b.group_name =
	 * 'Education' group by a.education_id, b.item_name
	 * 
	 */

}
