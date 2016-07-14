package com.ttnd.reap.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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

	// @Autowired
	// private HttpSession httpSession;

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public String home(HttpSession httpSession) {
		EmployeeDetails employeeDetails = (EmployeeDetails) httpSession.getAttribute("employeeDetails");
		if (employeeDetails == null) {
			return "login";
		}
		return "reap_home";
	}

	/*
	 * @RequestMapping(value = "/login", method = RequestMethod.GET) public
	 * String login(HttpSession session) { return "login"; }
	 */

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("email_id") String email_id, @RequestParam("password") String password,
			HttpSession httpSession, ModelMap model) {
		EmployeeDetails employeeDetails;
		try {
			int id = Integer.parseInt(email_id);
			employeeDetails = service.findEmployeeById(id, password);
		} catch (NumberFormatException numberFormatException) {
			employeeDetails = service.findEmployeeByEmail(email_id, password);
		}
		if (employeeDetails == null) {
			ModelAndView modelAndView = new ModelAndView("login");
			modelAndView.addObject("msg", "flop");
//			modelAndView.addAttribute("msg", "Invalid Credentials!");
			return modelAndView;
		}
		httpSession.setAttribute("employeeDetails", employeeDetails);
		return new ModelAndView("reap_Home");
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register(HttpSession httpSession) {
		EmployeeDetails employeeDetails = (EmployeeDetails) httpSession.getAttribute("employeeDetails");
		if (employeeDetails == null) {
			return new ModelAndView("register", "employeeDetails", new EmployeeDetails());
		}
		return new ModelAndView("reap_home");
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@ModelAttribute EmployeeDetails employeeDetails, Model model, HttpSession httpSession) {
		service.save(employeeDetails);
		httpSession.setAttribute("employeeDetails", employeeDetails);
		return "reap_home";
	}

	@RequestMapping(value = "/badges")
	public String badges() {

		return "myBadges";
	}
}
