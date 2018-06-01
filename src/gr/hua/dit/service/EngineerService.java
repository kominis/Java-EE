package gr.hua.dit.service;

import java.util.List;

import gr.hua.dit.entity.Car;

public interface EngineerService {

	public List<Car> getCars();
	
	public Car getCar(String plate);
	
	public void updateCar(Car car);
	
}
