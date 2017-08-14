package project.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class CreateUsers {

	public CreateUsers() {
		createUsers();

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

	public void createUsers() {
		
		
//		Role r1 = new Role();
//		r1.setId(83);
//		r1.setName("SuperPuper");
//
//		 Role r2 = new Role();
//		 r2.setId(84);
//		 r2.setName("Sternkoch");
//
//		User user01 = new User();
//	    User user02 = new User();
//
//		user01.setId(30);
//		user01.setName("Name1");
//		user01.setEmail("a1@yahoo.com");
//		user01.setRole(r1);
//
//		 user02.setId(31);
//		 user02.setName("Name2");
//		 user02.setEmail("a2@yahoo.com");
//		 user02.setRole(r2);

		Session session = createSession();
		session.beginTransaction();
		User user = (User)session.load(User.class, 17);
		System.out.println(user.getId() + " " + user.getName());
		session.delete(user);
//		session.save(user01);
//	    session.save(user02);
		session.getTransaction().commit();
		System.out.println("Done");

	}
	

}
