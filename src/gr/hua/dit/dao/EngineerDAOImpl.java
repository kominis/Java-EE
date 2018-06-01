package gr.hua.dit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.entity.Car;

@Repository
public class EngineerDAOImpl implements EngineerDAO {

	// inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Car> getCars() {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		return currentSession.createQuery("from Car", Car.class).getResultList();
	}
	
	@Override
	public Car getCar(String plate) {
		 // get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		return currentSession.get(Car.class, plate);
	}
	
	@Override
	public void updateCar(Car car) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// update vehicle condition and customer bonus
		currentSession.update(car);
		currentSession.update(car.getCustomer());
	}

}
