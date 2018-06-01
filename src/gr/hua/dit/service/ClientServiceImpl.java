package gr.hua.dit.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.hua.dit.dao.ClientDAO;
import gr.hua.dit.entity.Car;
import gr.hua.dit.entity.Customer;

@Service
public class ClientServiceImpl implements ClientService {

	// inject the ClientDAO
	@Autowired
	private ClientDAO clientDAO;
	
	@Override
	@Transactional
	public void saveClient(Customer customer) {
		clientDAO.saveClient(customer);
	}
	
	@Override
	@Transactional
	public Car getCar(String plate) {
		return clientDAO.getCar(plate);
	}
}
