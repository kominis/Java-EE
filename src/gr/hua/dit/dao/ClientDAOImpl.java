package gr.hua.dit.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.entity.Car;
import gr.hua.dit.entity.Customer;

@Repository
public class ClientDAOImpl implements ClientDAO {

	// inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveClient(Customer customer) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save new customer
		currentSession.save(customer);
		currentSession.save(customer.getCars().get(customer.getCars().size() - 1));

	}
	
	@Override
	public Car getCar(String plate) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		return currentSession.get(Car.class, plate);
	}

}
