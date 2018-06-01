package gr.hua.dit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.entity.ApplicationUser;

@Repository
public class ApplicationUserDAOImpl implements ApplicationUserDAO {

	// inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<ApplicationUser> getEmployees(int rights) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// get and return application user
		return currentSession.createQuery("from ApplicationUser where rights=" + rights, ApplicationUser.class).getResultList();
	}

	@Override
	public List<ApplicationUser> getAdministrators(int rights) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// get and return application user
		return currentSession.createQuery("from ApplicationUser where rights=" + rights, ApplicationUser.class).getResultList();
	}

	@Override
	public List<ApplicationUser> getEngineers(int rights) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// get and return application user
		return currentSession.createQuery("from ApplicationUser where rights=" + rights, ApplicationUser.class).getResultList();
	}

}
