package project.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateProbe {

	public static void main(String[] args) {
		try {
			User user = new User();
			user.setId(4);
			user.setName("Name4");
			user.setEmail("adresse4@yahoo.com");

			Role role = new Role();
			role.setId(2);
			role.setName("Admin");
			user.setRole(role);

			Session session = createSession();
			session.beginTransaction();

			session.save(user);
			session.save(role);

			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.exit(0);
		}

	}

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

}
