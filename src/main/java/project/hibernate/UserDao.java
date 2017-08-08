package project.hibernate;

import java.util.List;

public interface UserDao {
	public List<User> getAllUsers();

	public User getUser(int userId);

	public void updateUser(User user);

	public void deleteUser(User user);

}
