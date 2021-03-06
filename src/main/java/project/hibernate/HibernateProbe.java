package project.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateProbe {

	public static void main(String[] args) {

		User user01 = new User();
		User user02 = new User();
		User user03 = new User();

		Role r1 = new Role();
		r1.setId(40);
		r1.setName("SuperAdmin");

		Role r2 = new Role();
		r2.setId(22);
		r2.setName("SysAdmin");

		user01.setId(1);
		user01.setName("Name1");
		user01.setEmail("a1@yahoo.com");
		user01.setRole(r1);

		user02.setId(2);
		user02.setName("Name2");
		user02.setEmail("a2@yahoo.com");
		user02.setRole(r2);

		user03.setId(18);
		user03.setName("Name18");
		user03.setEmail("a18@yahoo.com");
		user03.setRole(r2);

		UserDaoImpl usersDao = new UserDaoImpl();

		User user1 = usersDao.findById(3);
		System.out.println(user1.getId() + " " + user1.getName());

		List<User> results = usersDao.findByName("Name1");
		System.out.println("Begin :");
		for (User user : results) {
			System.out.println(user.getId() + " " + user.getName() + " " + user.getEmail());
		}
		System.out.println("end");

		User user3 = usersDao.saveUser(user03, r2);
		System.out.println(user3.getId() + " " + user3.getName() + " " + "  saved .");

		User deletedUser = usersDao.deleteUser(4);
		System.out.println(deletedUser.getId() + " " + deletedUser.getName() + " from tabel");

	}

	public static Session createSession() {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		configuration.addAnnotatedClass(User.class);
		configuration.addAnnotatedClass(Role.class);

		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);
		Session session = factory.getCurrentSession();
		return session;

	}

}
