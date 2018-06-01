package gr.hua.dit.dao;

import java.util.List;

import gr.hua.dit.entity.Car;

public interface EngineerDAO {

	public List<Car> getCars();
	
	public Car getCar(String plate);
	
	public void updateCar(Car car);
	
}
