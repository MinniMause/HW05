package project.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 */
public class UserDaoImpl implements UserDao {

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

	public User deleteUser(Integer id) {
		Session session = createSession();
		session.beginTransaction();

		User user = session.find(User.class, id);
		session.delete(user);

		session.getTransaction().commit();
		return user;
	}

	@Override
	public void deleteUser(User user) {
		Session session = createSession();
		session.beginTransaction();

		session.delete(user);

		session.getTransaction().commit();

	}

	public User findById(Integer id) {
		Session session = createSession();
		session.beginTransaction();

		User user = session.find(User.class, id);

		session.getTransaction().commit();
		return user;
	}

	public List<User> findByName(String pname) {
		Session session = createSession();
		session.beginTransaction();

		EntityManager em = session.getEntityManagerFactory().createEntityManager();
		TypedQuery<User> query = em.createQuery("SELECT u FROM users u WHERE u.name ='" + pname + "'", User.class);
		List<User> result = query.getResultList();

		session.getTransaction().commit();
		return result;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	public User saveUser(User user, Role role) {
		Session session = createSession();
		session.beginTransaction();
		session.save(user);
		session.save(role);
		session.getTransaction().commit();
		return user;
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub

	}

}
