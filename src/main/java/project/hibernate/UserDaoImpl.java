package project.hibernate;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

	// list is working as a database
	List<User> users;

	public UserDaoImpl() {
		users = new ArrayList<User>();
		User user1 = new User();
//		user1.setId(4);
//		user1.setName("Name4");
//		user1.setEmail("adresse4@yahoo.com");

		User user2 = new User();
		User user3 = new User();

		users.add(user1);
		users.add(user2);
		users.add(user3);
	}

	@Override
	public void deleteUser(User user) {
		users.remove(user.getId());
		System.out.println("User " + user.getId() + ", deleted from database");
	}

	@Override
	public List<User> getAllUsers() {
		return users;
	}

	@Override
	public User getUser(int userId) {
		return users.get(userId);
	}

	@Override
	public void updateUser(User user) {
		users.get(user.getId()).setName(user.getName());
		System.out.println("user " + user.getId() + ", updated in the database");
	}

}
