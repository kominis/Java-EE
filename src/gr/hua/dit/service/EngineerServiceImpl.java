package gr.hua.dit.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.hua.dit.dao.EngineerDAO;
import gr.hua.dit.entity.Car;

@Service
public class EngineerServiceImpl implements EngineerService {

	// inject the employeeDAO
	@Autowired
	private EngineerDAO engineerDAO;

	@Override
	@Transactional
	public List<Car> getCars() {
		return engineerDAO.getCars();
	}
	
	@Override
	@Transactional
	public Car getCar(String plate) {
		return engineerDAO.getCar(plate);
	}
	
	@Override
	@Transactional
	public void updateCar(Car car) {
		engineerDAO.updateCar(car);
	}

}
