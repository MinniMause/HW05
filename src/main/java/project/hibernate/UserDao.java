package project.hibernate;

import java.util.List;

public interface UserDao {

	User deleteUser(Integer id);

	void deleteUser(User user);

	User findById(Integer id);

	List<User> getAllUsers();

	void updateUser(User user);

}
