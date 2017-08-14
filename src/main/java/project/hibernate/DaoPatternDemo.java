package project.hibernate;

public class DaoPatternDemo {
	public static void main(String[] args) {

		UserDao userDao = new UserDaoImpl();
		// print all users
		for (User users : userDao.getAllUsers()) {
			System.out.println("User : " + users.getId() + ", Name : " + users.getName());
		}

		// update user
		User user = userDao.getAllUsers().get(0);
		user.setName("Michael");
		userDao.updateUser(user);

		// get the user
		userDao.findById(0);
		System.out.println("User:" + user.getId() + ", Name : " + user.getName());

	}
}
