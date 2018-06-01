package gr.hua.dit.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="car")
public class Car implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1995456515275630470L;

	// define fields	
	@Column(name="model")
	private String model;
	
	@Id
	@Column(name="plate")
	private String plate;
	
	@Column(name="fuel_type")
	private String fuelType;
	
	@Column(name="vehicle_condition")
	private String vehicleCondition;
	
	@Column(name="release_year")
	private int releaseYear;
	
	@Column(name="location")
	private String location;
	
	@Column(name="distance")
	private int distance;
	
	@JsonIgnore
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="customer_afm")
	private Customer customer;
	
	// define constructors
	public Car() {}
	
	public Car(String plate, String vehicle_condition, String location) {
		this.plate = plate;
		this.vehicleCondition = vehicle_condition;
		this.location = location;
	}
	
	public Car(String model, String plate, String fuel_type, String vehicle_condition, int release_year, String location) { 
		this.model = model;
		this.plate = plate;
		this.fuelType = fuel_type;
		this.vehicleCondition = vehicle_condition;
		this.releaseYear = release_year;
		this.location = location;
	}

	// define getters and setters
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuel_type) {
		this.fuelType = fuel_type;
	}

	public String getVehicleCondition() {
		return vehicleCondition;
	}

	public void setVehicleCondition(String vehicle_condition) {
		this.vehicleCondition = vehicle_condition;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int release_year) {
		this.releaseYear = release_year;
	}
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}	
}
