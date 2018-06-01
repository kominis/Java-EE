package gr.hua.dit.controller;

import static gr.hua.dit.controller.ApplicationUserController.engSuccessLogin;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gr.hua.dit.entity.Car;
import gr.hua.dit.service.EngineerService;

@Controller
@RequestMapping("/engineer")
public class EngineerController {

	// inject the employee service
	@Autowired
	private EngineerService engService;

	@GetMapping("/engineer")
	public String engineerPage(Model model) {
		// check if user logged in
		if (engSuccessLogin == 1) {
			// add page title
			model.addAttribute("pageTitle", "Engineer Home Page");

			return "user/engineer/engineer";
		} else {
			return "redirect:/login/engineerLogin";
		}
	}

	@GetMapping("/listVehicles")
	public String getCars(Model model) {
		// check if user logged in
		if (engSuccessLogin == 1) {
			// add page title
			model.addAttribute("pageTitle", "List Vehicles");

			List<Car> cars = engService.getCars();
			model.addAttribute("cars", cars);

			return "/user/engineer/listCars";
		} else {
			return "redirect:/login/engineerLogin";
		}
	}

	@GetMapping("/findVehicle")
	public String findCarPage(Model model) {
		// check if user logged in
		if (engSuccessLogin == 1) {
			// add page title
			model.addAttribute("pageTitle", "Find Vehicle");
			// add an empty car to jsp page
			Car car = new Car();
			model.addAttribute("car", car);

			return "/user/engineer/findCar";
		} else {
			return "redirect:/login/engineerLogin";
		}
	}

	@GetMapping("/vehicle{plate}")
	public String getCar(@ModelAttribute("car") Car car, @PathVariable("plate") String plate, Model model) {
		// check if user logged in
		if (engSuccessLogin == 1) {
			// set car plate with the input from the jsp
			car.setPlate(car.getPlate());

			// update model attribute
			model.addAttribute("car", car);

			// add page title
			model.addAttribute("pageTitle", "Update Vehicle");

			return "/user/engineer/updateCar";
		} else {
			return "redirect:/login/engineerLogin";
		}
	}

	@PostMapping("/updateVehicle")
	public String updateCar(@ModelAttribute("car") Car car, Model model) {
		// check if user logged in
		if (engSuccessLogin == 1) {
			// get car condition from jsp
			String carCondition = car.getVehicleCondition();

			// get car from DB
			car = engService.getCar(car.getPlate());

			int bonus;
			// calculation car's age
			int carYear = Calendar.getInstance().get(Calendar.YEAR) - car.getReleaseYear();

			// set car condition
			car.setVehicleCondition(carCondition);
			
			// set penalty based on car distance
			int penalty;
			if(car.getDistance() == 0) {
				penalty = 0;
			}else if(car.getDistance() < 10) {
				penalty = 20;
			}else if(car.getDistance() < 30){
				penalty = 30;
			}else {
				penalty = 40;
			}

			// calculation of customer bonus
			if (carYear < 5) {
				if (carCondition.equals("bad")) {
					bonus = 400 - penalty;
				} else if (carCondition.equals("medium")) {
					bonus = 640 - penalty;
				} else {
					bonus = 800 - penalty;
				}
			} else if (carYear < 10) {
				if (carCondition.equals("bad")) {
					bonus = 500 - penalty;
				} else if (carCondition.equals("medium")) {
					bonus = 800 - penalty;
				} else {
					bonus = 1000 - penalty;
				}
			} else if (carYear < 20) {
				if (carCondition.equals("bad")) {
					bonus = 600 - penalty;
				} else if (carCondition.equals("medium")) {
					bonus = 960 - penalty;
				} else {
					bonus = 1200 - penalty;
				}
			} else {
				if (carCondition.equals("bad")) {
					bonus = 500 - penalty;
				} else if (carCondition.equals("medium")) {
					bonus = 800 - penalty;
				} else {
					bonus = 1000 - penalty;
				}
			}

			// set customer bonus
			car.getCustomer().setBonus(bonus);

			// update customer bonus and car condition
			engService.updateCar(car);

			return "redirect:/engineer/findVehicle";
		} else {
			return "redirect:/login/engineerLogin";
		}
	}

}
