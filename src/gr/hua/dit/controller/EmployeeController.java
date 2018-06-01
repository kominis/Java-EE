package gr.hua.dit.controller;

import static gr.hua.dit.controller.ApplicationUserController.empSuccessLogin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gr.hua.dit.entity.Car;
import gr.hua.dit.entity.Customer;
import gr.hua.dit.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	// inject the employee service
	@Autowired
	private EmployeeService empService;

	@GetMapping("/employee")
	public String adminPagePage(Model model) {
		// check if user logged in
		if (empSuccessLogin == 1) {
			// add page title
			model.addAttribute("pageTitle", "Employee Home Page");

			return "user/employee/employee";
		} else {
			return "redirect:/login/employeeLogin";
		}
	}

	@GetMapping("/newCustomer")
	public String newCustomer(Model model) {
		// check if user logged in
		if (empSuccessLogin == 1) {
			// create model attribute to get form data
			Customer customer = new Customer();
			Car car = new Car();
			customer.addCar(car);
			model.addAttribute("customer", customer);

			// add page title
			model.addAttribute("pageTitle", "Add New Customer");

			return "user/employee/newCustomer";
		} else {
			return "redirect:/login/employeeLogin";
		}
	}

	@PostMapping("/saveNewCustomer")
	public String saveNewCustomer(@ModelAttribute("customer") Customer customer, HttpServletRequest request) {
		// check if user logged in
		if (empSuccessLogin == 1) {
			String model = request.getParameter("model");
			String licensePlate = request.getParameter("licensePlate");
			String fuelType = request.getParameter("fuelType");
			String vehicleCondition = "N/A";
			String location = request.getParameter("location");
			int releaseYear = Integer.valueOf(request.getParameter("releaseYear"));
			Car car = new Car(model, licensePlate, fuelType, vehicleCondition, releaseYear, location);
			customer.addCar(car);
			customer.setBonus(-1);

			// save new customer and car using the service
			empService.newCustomer(customer);

			return "redirect:/employee/newCustomer";
		} else {
			return "redirect:/login/employeeLogin";
		}
	}

	@GetMapping("/listCustomers")
	public String getCustomers(Model model) {
		// check if user logged in
		if (empSuccessLogin == 1) {
			// create model attribute to get form data
			List<Customer> customers = empService.getCustomers();
			model.addAttribute("customers", customers);

			// add page title
			model.addAttribute("pageTitle", "All Customers");

			return "user/employee/listCustomers";
		} else {
			return "redirect:/login/employeeLogin";
		}
	}
}
