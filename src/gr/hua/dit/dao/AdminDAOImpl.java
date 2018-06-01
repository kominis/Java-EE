package gr.hua.dit.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.entity.ApplicationUser;

@Repository
public class AdminDAOImpl implements AdminDAO {

	// inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void createUser(ApplicationUser appUser) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save the application user
		currentSession.save(appUser);
	}

	@Override
	public void deleteUser(int id) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// find the application user
		ApplicationUser appUser = currentSession.get(ApplicationUser.class, id);

		// delete application user
		currentSession.delete(appUser);

	}

	@Override
	public void modifyUser(ApplicationUser appUser) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		

		// modify application user
		currentSession.update(appUser);
	}

	@Override
	public ApplicationUser getUser(int id) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// get and return ApplicationUser
		return currentSession.get(ApplicationUser.class, id); 
	}

}
