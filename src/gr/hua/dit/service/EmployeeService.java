package gr.hua.dit.service;

import java.util.List;

import gr.hua.dit.entity.Customer;

public interface EmployeeService {

	public void newCustomer(Customer customer);
	
	public List<Customer> getCustomers();
	
	public Customer getCustomer(int afm);
		
}
