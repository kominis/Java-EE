package gr.hua.dit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.entity.Customer;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	// inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void newCustomer(Customer customer) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save new customer
		currentSession.save(customer);
		currentSession.save(customer.getCars().get(customer.getCars().size() - 1));

	}

	@Override
	public List<Customer> getCustomers() {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		return currentSession.createQuery("from Customer",Customer.class).getResultList();
	}

	@Override
	public Customer getCustomer(int afm) {
		 // get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		return currentSession.get(Customer.class, afm);
	}

}
