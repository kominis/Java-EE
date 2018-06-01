package gr.hua.dit.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="customer")
public class Customer implements Serializable {



	/**
	 * 
	 */
	private static final long serialVersionUID = 6313938148729275830L;

	// define fields
	@Id
	@Column(name="afm")
	private int afm;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="bonus")
	private int bonus;
	
	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY, mappedBy="customer", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	private List<Car> cars;
	
	// define constructors
	public Customer() {}
	
	public Customer(int afm, String lName, String fName) {
		this.afm = afm;
		this.lastName = lName;
		this.firstName = fName;
	}

	// define getters and setters
	public int getAfm() {
		return afm;
	}

	public void setAfm(int afm) {
		this.afm = afm;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public int getBonus() {
		return bonus;
	}
	
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	
	// add convenience methods for bi-directional relation
	public void addCar(Car car) {
		if(cars == null) {
			cars = new ArrayList<>();
		}
		cars.add(car);
		car.setCustomer(this);
	}
	
}
