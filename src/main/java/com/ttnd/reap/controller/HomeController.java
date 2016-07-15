package com.ttnd.reap.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ttnd.reap.pojo.BadgeTransaction;
import com.ttnd.reap.pojo.EmployeeDetails;
import com.ttnd.reap.pojo.ReceivedBadges;
import com.ttnd.reap.service.IService;

@Controller
// @RequestMapping("/")
public class HomeController {

	@Autowired
	private IService service;

	// @Autowired
	// private HttpSession httpSession;

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public ModelAndView home(HttpSession httpSession) {
		EmployeeDetails employeeDetails = (EmployeeDetails) httpSession.getAttribute("employeeDetails");
		if (employeeDetails == null) {
			return new ModelAndView("login");
		}
		return new ModelAndView("reap_home", "badgeTransaction", new BadgeTransaction());
	}

	/*
	 * @RequestMapping(value = "/login", method = RequestMethod.GET) public
	 * String login(HttpSession session) { return "login"; }
	 */

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("email_id") String email_id, @RequestParam("password") String password,
			HttpSession httpSession) {
		EmployeeDetails employeeDetails;
		try {
			int id = Integer.parseInt(email_id);
			employeeDetails = service.findEmployeeById(id, password);
		} catch (NumberFormatException numberFormatException) {
			employeeDetails = service.findEmployeeByEmail(email_id, password);
		}
		if (employeeDetails == null) {
			ModelAndView modelAndView = new ModelAndView("login");
			modelAndView.addObject("msg", "Invalid Credentials!");
			// System.out.println(modelAndView.getModel().get("msg"));
			return modelAndView;
		}
		httpSession.setAttribute("employeeDetails", employeeDetails);
		return new ModelAndView("reap_home");
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
	public ModelAndView badges(HttpSession httpSession) {
		EmployeeDetails employeeDetails = (EmployeeDetails) httpSession.getAttribute("employeeDetails");
		ModelAndView modelAndView=new ModelAndView();
		if (employeeDetails == null) {
			modelAndView.setViewName("login");
			modelAndView.addObject("msg", "Please login first!!!!");
			return modelAndView;
		}
		modelAndView.setViewName("myBadges");
		ReceivedBadges receivedBadges = service.getReceivedBadgesOfEmployee(employeeDetails);
		modelAndView.addObject("receivedBadges", receivedBadges);
		return new ModelAndView("myBadges");
	}
}
