package gr.hua.dit.service;

import gr.hua.dit.entity.Car;
import gr.hua.dit.entity.Customer;

public interface ClientService {

	void saveClient(Customer customer);

	public Car getCar(String plate);

}
