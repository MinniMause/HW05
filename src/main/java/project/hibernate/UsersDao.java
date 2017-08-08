package project.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Methods : -createSession(); -findById(); -deleteUser();
 */
public class UsersDao {

	private static Session createSession() {
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

	public User findById(Integer id) {
		Session session = createSession();
		session.beginTransaction();

		User user = session.find(User.class, id);

		session.getTransaction().commit();
		return user;
	}

	public User deleteUser(Integer id) {
		Session session = createSession();
		session.beginTransaction();

		User user = session.find(User.class, id);
		session.delete(user);

		session.getTransaction().commit();
		return user;
	}

	public User saveUser(User user, Role role) {
		Session session = createSession();
		session.beginTransaction();
		session.save(user);
		session.save(role);
		session.getTransaction().commit();
		return user;
	}

}
