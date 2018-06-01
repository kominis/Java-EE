package gr.hua.dit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gr.hua.dit.entity.ApplicationUser;
import gr.hua.dit.service.ApplicationUserService;

@Controller
@RequestMapping("/login")
public class ApplicationUserController {

	// check if the application user logged in successfully
	// 1 is for success login and 0 is for failed login
	// if one user has successLogin 1 the others have 0
	// so that we can prevent users from entering to other users pages
	public static int adminSuccessLogin = 1; // administrator
	public static int empSuccessLogin = 1;   // employee
	public static int engSuccessLogin = 1;   // engineer

	@Autowired
	private ApplicationUserService appUserService;

	@GetMapping("/loginAs")
	public String getHomePage(Model model) {
		model.addAttribute("pageTitle", "Home Page");
		return "login/loginAs";
	}

	@GetMapping("/adminLogin")
	public String getAdminLoginPage(Model model) {
		model.addAttribute("pageTitle", "Administrator Login");

		ApplicationUser appUser = new ApplicationUser();
		model.addAttribute("appUser", appUser);
		
		// set successLogin for employee and engineer 0
		empSuccessLogin = 0;
		engSuccessLogin = 0;

		// display error message if the administrator failed login
		if (adminSuccessLogin == 0) {
			model.addAttribute("errorMessage", "Invalid username or password");
		}
		
		// set successLogin 1
		adminSuccessLogin = 1;
		empSuccessLogin = 1;
		engSuccessLogin = 1;

		return "login/adminLogin";
	}

	@GetMapping("/employeeLogin")
	public String getEmployeeLoginPage(Model model) {
		model.addAttribute("pageTitle", "Employee Login");

		ApplicationUser appUser = new ApplicationUser();
		model.addAttribute("appUser", appUser);
		
		// set successLogin for administrator and engineer 0
		adminSuccessLogin = 0;		
		engSuccessLogin = 0;

		// display error message if the employee failed login
		if (empSuccessLogin == 0) {
			model.addAttribute("errorMessage", "Invalid username or password");
		}
		
		// set successLogin 1
		adminSuccessLogin = 1;		
		engSuccessLogin = 1;
		empSuccessLogin = 1;

		return "login/employeeLogin";
	}

	@GetMapping("/engineerLogin")
	public String getEngineerLoginPage(Model model) {
		model.addAttribute("pageTitle", "Engineer Login");

		ApplicationUser appUser = new ApplicationUser();
		model.addAttribute("appUser", appUser);
		
		// set successLogin for administrator and employee 0
		adminSuccessLogin = 0;
		empSuccessLogin = 0;
		

		// display error message if the engineer failed login
		if (engSuccessLogin == 0) {
			model.addAttribute("errorMessage", "Invalid username or password");
		}
		
		// set successLogin 1
		adminSuccessLogin = 1;
		empSuccessLogin = 1;
		engSuccessLogin = 1;

		return "login/engineerLogin";
	}

	@PostMapping("/checkAdminLogin")
	public String adminLogin(@ModelAttribute("appUser") ApplicationUser appUser, Model model) {

		// get the administrators from service
		List<ApplicationUser> admins = appUserService.getAdministrators(1);

		// check if administrator exists
		try {
			for (ApplicationUser admin : admins) {
				if (appUser.getUsername().equals(admin.getUsername())
						&& appUser.getPassword().equals(admin.getPassword())) {
					adminSuccessLogin = 1;
					empSuccessLogin = 0;
					engSuccessLogin = 0;
					appUser.setId(admin.getId());
					appUser.setRights(admin.getRights());
					return "redirect:/admin/administrator";
				}
			}
			adminSuccessLogin = 0;
			return "redirect:/login/adminLogin";
		} catch (NullPointerException ex) {
			adminSuccessLogin = 0;
			return "redirect:/login/adminLogin";
		}
	}

	@PostMapping("/checkEmployeeLogin")
	public String employeeLogin(@ModelAttribute("appUser") ApplicationUser appUser, Model model) {
		// get the employees from dao
		List<ApplicationUser> employees = appUserService.getAdministrators(2);

		// check if employee exists
		try {
			for (ApplicationUser employee : employees) {
				if (appUser.getUsername().equals(employee.getUsername())
						&& appUser.getPassword().equals(employee.getPassword())) {
					empSuccessLogin = 1;
					adminSuccessLogin = 0;		
					engSuccessLogin = 0;
					appUser.setId(employee.getId());
					appUser.setRights(employee.getRights());
					return "redirect:/employee/employee";
				}
			}
			empSuccessLogin = 0;
			return "redirect:/login/employeeLogin";
		} catch (NullPointerException ex) {
			empSuccessLogin = 0;
			return "redirect:/login/employeeLogin";
		}
	}

	@PostMapping("/checkEngineerLogin")
	public String engineerLogin(@ModelAttribute("appUser") ApplicationUser appUser, Model model) {
		// get the engineers from dao
		List<ApplicationUser> engineers = appUserService.getAdministrators(3);

		// check if engineer exists
		try {
			for (ApplicationUser engineer : engineers) {
				if (appUser.getUsername().equals(engineer.getUsername())
						&& appUser.getPassword().equals(engineer.getPassword())) {
					engSuccessLogin = 1;
					adminSuccessLogin = 0;
					empSuccessLogin = 0;
					appUser.setId(engineer.getId());
					appUser.setRights(engineer.getRights());
					return "redirect:/engineer/engineer";
				}
			}
			engSuccessLogin = 0;
			return "redirect:/login/engineerLogin";
		} catch (NullPointerException ex) {
			engSuccessLogin = 0;
			return "redirect:/login/engineerLogin";
		}
	}
}
