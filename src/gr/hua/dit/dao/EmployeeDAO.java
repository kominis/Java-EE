package gr.hua.dit.dao;

import java.util.List;

import gr.hua.dit.entity.Customer;

public interface EmployeeDAO {

	public void newCustomer(Customer customer);

	public List<Customer> getCustomers();

	public Customer getCustomer(int afm);

}
