package gr.hua.dit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gr.hua.dit.entity.ApplicationUser;
import gr.hua.dit.service.AdminService;
import static gr.hua.dit.controller.ApplicationUserController.adminSuccessLogin;

@Controller
@RequestMapping("/admin")
public class AdministratorController {

	// inject the admin service
	@Autowired
	private AdminService adminService;

	@GetMapping("/administrator")
	public String adminPage(Model model) {
		// check if user logged in
		if (adminSuccessLogin == 1) {
			// add page title
			model.addAttribute("pageTitle", "Administrator Home Page");

			return "user/admin/administrator";
		} else {
			return "redirect:/login/adminLogin";
		}
	}

	@GetMapping("/createUser")
	public String createUserPage(Model model) {
		// check if user logged in
		if (adminSuccessLogin == 1) {
			// create model attribute to get form data
			ApplicationUser appUser = new ApplicationUser();
			model.addAttribute("appUser", appUser);

			// add page title
			model.addAttribute("pageTitle", "Create New User");

			return "user/admin/createUser";
		} else {
			return "redirect:/login/adminLogin";
		}
	}

	@PostMapping("/saveNewUser")
	public String saveNewUser(@ModelAttribute("appUser") ApplicationUser appUser) {
		// check if user logged in
		if (adminSuccessLogin == 1) {
			// save the appUser using the service
			adminService.createUser(appUser);

			return "redirect:/admin/createUser";
		} else {
			return "login/adminLogin";
		}
	}

	@GetMapping("/deleteUser")
	public String deleteUserPage(Model model) {
		// check if user logged in
		if (adminSuccessLogin == 1) {
			// create model attribute to get form data
			ApplicationUser appUser = new ApplicationUser();
			model.addAttribute("appUser", appUser);

			// add page title
			model.addAttribute("pageTitle", "Delete User");

			return "user/admin/deleteUser";
		} else {
			return "redirect:/login/adminLogin";
		}
	}

	@PostMapping("/deleteuser")
	public String deleteUser(@ModelAttribute("appUser") ApplicationUser appUser) {
		// check if user logged in
		if (adminSuccessLogin == 1) {

			// delete the application user
			adminService.deleteUser(appUser.getId());

			return "redirect:/admin/deleteUser";
		} else {
			return "redirect:/login/adminLogin";
		}
	}

	// UNDER CONSTRUCTION COME BACK LATER
	@GetMapping("/findUser")
	public String findUserPage(Model model) {

		// check if user logged in
		if (adminSuccessLogin == 1) {
			// create model attribute to get form data
			ApplicationUser appUser = new ApplicationUser();

			model.addAttribute("appUser", appUser);

			// add page title
			model.addAttribute("pageTitle", "Find User");

			return "user/admin/findUser";
		} else {
			return "redirect:/login/adminLogin";
		}
	}

	@GetMapping("/user")
	public String findUserId(Model model, @ModelAttribute("appUser") ApplicationUser appUser) {
		// check if user logged in
		if (adminSuccessLogin == 1) {

			// get application user from DB
			appUser = adminService.getUser(appUser.getId());

			// update model attribute
			model.addAttribute("appUser", appUser);

			// add page title
			model.addAttribute("pageTitle", "Update User");

			return "user/admin/modifyUser";
		} else {
			return "redirect:/login/adminLogin";
		}
	}

	@PostMapping("/saveModifiedUser")
	public String saveModifiedUser(@ModelAttribute("appUser") ApplicationUser appUser) {
		// check if user logged in
		if (adminSuccessLogin == 1) {

			// update application user
			adminService.modifyUser(appUser);

			return "redirect:/admin/findUser";
		} else {
			return "login/adminLogin";
		}
	}
}