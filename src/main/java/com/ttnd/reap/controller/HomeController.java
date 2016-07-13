package com.ttnd.reap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ttnd.reap.pojo.EmployeeDetails;
import com.ttnd.reap.service.IService;

@Controller
// @RequestMapping("/")
public class HomeController {

	@Autowired
	private IService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	// @RequestMapping(method = RequestMethod.GET)
	public String home() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("email_id") String email_id, @RequestParam("password") String password) {
		System.out.println(email_id);
		System.out.println(password);
		EmployeeDetails employeeDetails;
		try {
			int id = Integer.parseInt(email_id);
			employeeDetails = service.findEmployeeById(id, password);
		} catch (NumberFormatException numberFormatException) {
			employeeDetails = service.findEmployeeByEmail(email_id, password);
		}
		System.out.println(employeeDetails);
		if (employeeDetails == null) {
			return new ModelAndView("login");
		} else {
			return new ModelAndView("reap_home");
		}
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register() {
		return new ModelAndView("register", "employeeDetails", new EmployeeDetails());
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@ModelAttribute EmployeeDetails employeeDetails, Model model) {
		service.save(employeeDetails);
		System.out.println(employeeDetails.getId());
		System.out.println(employeeDetails.getPassword());
		System.out.println(employeeDetails.getEmail());

		return "home";
	}
}
