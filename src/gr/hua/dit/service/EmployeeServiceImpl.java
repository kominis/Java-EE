package gr.hua.dit.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.hua.dit.dao.EmployeeDAO;
import gr.hua.dit.entity.Customer;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	// inject the employeeDAO
	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	@Transactional
	public void newCustomer(Customer customer) {
		employeeDAO.newCustomer(customer);
	}

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return employeeDAO.getCustomers();
	}

	@Override
	@Transactional
	public Customer getCustomer(int afm) {
		return employeeDAO.getCustomer(afm);
	}

}
