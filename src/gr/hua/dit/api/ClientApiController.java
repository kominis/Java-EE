package gr.hua.dit.api;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gr.hua.dit.entity.Car;
import gr.hua.dit.entity.Customer;
import gr.hua.dit.service.ClientService;
import gr.hua.dit.service.EmployeeService;

@RestController
@RequestMapping("/api/client")
public class ClientApiController {

	@Autowired
	private ClientService clientService;

	@Autowired
	private EmployeeService empService;

	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	public Customer createCustomer(@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("afm") int afm,
			@RequestParam("location") String location, @RequestParam("plate") String plate,
			@RequestParam("condition") String condition, @RequestParam("releaseYear") int releaseYear) {
		// create a new customer if doesn't exist
		Customer customer = empService.getCustomer(afm);
		if (customer != null) {
			return customer;
		} else {
			customer = new Customer(afm, lastName, firstName);
			Car car = new Car(plate, condition, location);
			car.setReleaseYear(releaseYear);
			// calculate random distance(km)
			Random rand = new Random();
			int distance = rand.nextInt(110) - 1;
			car.setDistance(distance);
			customer.setBonus(-1);
			customer.addCar(car);
			// if distance > 100 the customer doesn't get saved to DB
			if (distance <= 100) {
				clientService.saveClient(customer);
				return customer;
			} else {
				// return null customer
				Customer nullCustomer = new Customer();
				return nullCustomer;
			}
		}

	}

	@RequestMapping(value = "/car/{plate}", method = RequestMethod.GET, produces = "application/json")
	public Car getCar(@PathVariable("plate") String plate) {
		// search to DB for the given plate
		Car car = clientService.getCar(plate);
		// returns car information if the bonus has been calculated
		// returns null if the car doestn't exist or if the bonus hasn't been calculated
		if(car != null) {
			if (car.getCustomer().getBonus() == -1) {
				Car nullCar = new Car();
				return nullCar;
			} else {
				return car;
			}
		}
		return car;
	}
}
