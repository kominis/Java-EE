package gr.hua.dit.dao;

import gr.hua.dit.entity.Car;
import gr.hua.dit.entity.Customer;

public interface ClientDAO {

	public void saveClient(Customer customer);

	public Car getCar(String plate);
	
}
