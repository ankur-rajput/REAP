package com.ttnd.reap.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ttnd.reap.pojo.BadgeTransaction;
import com.ttnd.reap.pojo.EmployeeDetails;
import com.ttnd.reap.pojo.ReceivedBadges;
import com.ttnd.reap.pojo.RemainingBadges;
import com.ttnd.reap.service.IBadgeTransactionService;
import com.ttnd.reap.service.IService;

@Controller
// @RequestMapping("/")
public class HomeController {

	@Autowired
	private IService service;

	@Autowired
	private IBadgeTransactionService badgeTransactionService;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ModelAndView root(HttpSession httpSession) {
		EmployeeDetails employeeDetails = (EmployeeDetails) httpSession.getAttribute("employeeDetails");
		ModelAndView modelAndView = new ModelAndView();
		if (employeeDetails == null) {
			modelAndView.setViewName("login");
			return modelAndView;
		}
		modelAndView.setViewName("redirect:/home");
		return modelAndView;
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home(HttpSession httpSession) {
		EmployeeDetails employeeDetails = (EmployeeDetails) httpSession.getAttribute("employeeDetails");
		ModelAndView modelAndView = new ModelAndView();
		if (employeeDetails == null) {
			modelAndView.setViewName("redirect:/login");
			return modelAndView;
		}
		modelAndView.addObject("badgeTransaction", new BadgeTransaction());
		modelAndView.addObject("receivedBadges", service.getReceivedBadgesOfEmployee(employeeDetails));
		modelAndView.addObject("remainingBadges", service.getRemainingBadgesOfEmployee(employeeDetails));
		modelAndView.addObject("wallOfFame", badgeTransactionService.wallOfFame());
		modelAndView.setViewName("home");
		return modelAndView;
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public ModelAndView login(HttpSession httpSession) {
		EmployeeDetails employeeDetails = (EmployeeDetails) httpSession.getAttribute("employeeDetails");
		ModelAndView modelAndView = new ModelAndView();
		if (employeeDetails == null) {
			modelAndView.setViewName("login");
			return modelAndView;
		}
		modelAndView.setViewName("redirect:/home");
		return modelAndView;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("email_id") String email_id, @RequestParam("password") String password,
			HttpSession httpSession) {
		EmployeeDetails employeeDetails = (EmployeeDetails) httpSession.getAttribute("employeeDetails");
		ModelAndView modelAndView = new ModelAndView();
		if (employeeDetails != null) {
			httpSession.setAttribute("employeeDetails", employeeDetails);
			modelAndView.addObject("badgeTransaction", new BadgeTransaction());
			modelAndView.addObject("receivedBadges", service.getReceivedBadgesOfEmployee(employeeDetails));
			modelAndView.addObject("remainingBadges", service.getRemainingBadgesOfEmployee(employeeDetails));
			modelAndView.setViewName("redirect:/home");
			return modelAndView;
		}
		try {
			int id = Integer.parseInt(email_id);
			employeeDetails = service.findEmployeeById(id, password);
		} catch (NumberFormatException numberFormatException) {
			employeeDetails = service.findEmployeeByEmail(email_id, password);
		}
		if (employeeDetails == null) {
			modelAndView.setViewName("login");
			modelAndView.addObject("msg", "Invalid Credentials!");
			return modelAndView;
		}
		httpSession.setAttribute("employeeDetails", employeeDetails);
		modelAndView.addObject("badgeTransaction", new BadgeTransaction());
		modelAndView.addObject("receivedBadges", service.getReceivedBadgesOfEmployee(employeeDetails));
		modelAndView.addObject("remainingBadges", service.getRemainingBadgesOfEmployee(employeeDetails));
		modelAndView.setViewName("redirect:/home");
		return modelAndView;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register(HttpSession httpSession) {
		EmployeeDetails employeeDetails = (EmployeeDetails) httpSession.getAttribute("employeeDetails");
		ModelAndView modelAndView = new ModelAndView();
		if (employeeDetails == null) {
			modelAndView.addObject("employeeDetails", new EmployeeDetails());
			modelAndView.setViewName("register");
			return modelAndView;
		}
		modelAndView.addObject("badgeTransaction", new BadgeTransaction());
		modelAndView.addObject("receivedBadges", service.getReceivedBadgesOfEmployee(employeeDetails));
		modelAndView.addObject("remainingBadges", service.getRemainingBadgesOfEmployee(employeeDetails));
		modelAndView.setViewName("redirect:/home");
		return modelAndView;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView register(@ModelAttribute EmployeeDetails employeeDetails, HttpSession httpSession) {
		ModelAndView modelAndView = new ModelAndView();
		EmployeeDetails employeeDetailsSession = (EmployeeDetails) httpSession.getAttribute("employeeDetails");
		if (employeeDetailsSession != null) {
			httpSession.setAttribute("employeeDetails", employeeDetails);
			modelAndView.addObject("badgeTransaction", new BadgeTransaction());
			modelAndView.addObject("receivedBadges", service.getReceivedBadgesOfEmployee(employeeDetails));
			modelAndView.addObject("remainingBadges", service.getRemainingBadgesOfEmployee(employeeDetails));
			modelAndView.setViewName("redirect:/home");
			return modelAndView;
		}

		int success = service.save(employeeDetails);
		if (success == 1) {
			httpSession.setAttribute("employeeDetails", employeeDetails);

			modelAndView.addObject("badgeTransaction", new BadgeTransaction());
			modelAndView.addObject("receivedBadges", service.getReceivedBadgesOfEmployee(employeeDetails));
			modelAndView.addObject("remainingBadges", service.getRemainingBadgesOfEmployee(employeeDetails));
			modelAndView.setViewName("redirect:/home");
			return modelAndView;
		} else {
			if (success == -1)
				modelAndView.addObject("msg", "This email already exists!! Please choose another one");
			else
				modelAndView.addObject("msg", "Something went wrong! Please try again.");

			modelAndView.setViewName("register");
			return modelAndView;
		}

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession httpSession) {
		httpSession.invalidate();
		return "redirect:/login";
	}

	@RequestMapping(value = "/badges", method = RequestMethod.GET)
	public ModelAndView badges(HttpSession httpSession) {
		EmployeeDetails employeeDetails = (EmployeeDetails) httpSession.getAttribute("employeeDetails");
		ModelAndView modelAndView = new ModelAndView();
		if (employeeDetails == null) {
			modelAndView.setViewName("login");
			modelAndView.addObject("msg", "Please login first!!!!");
			return modelAndView;
		}
		modelAndView.setViewName("myBadges");
		ReceivedBadges receivedBadges = service.getReceivedBadgesOfEmployee(employeeDetails);
		modelAndView.addObject("receivedBadges", receivedBadges);
		return modelAndView;
	}

	@RequestMapping(value = { "/karma" }, method = RequestMethod.GET)
	public ModelAndView karma(HttpSession httpSession) {
		EmployeeDetails employeeDetails = (EmployeeDetails) httpSession.getAttribute("employeeDetails");
		ModelAndView modelAndView = new ModelAndView();
		if (employeeDetails == null) {
			modelAndView.addObject("msg", "Please login first!!!");
			modelAndView.setViewName("redirect:/login");
			return modelAndView;
		}
		modelAndView.addObject("badgeTransaction", new BadgeTransaction());
		modelAndView.addObject("receivedBadges", service.getReceivedBadgesOfEmployee(employeeDetails));
		modelAndView.addObject("remainingBadges", service.getRemainingBadgesOfEmployee(employeeDetails));
		modelAndView.setViewName("redirect:/home");
		return modelAndView;
	}

	@RequestMapping(value = "/karma", method = RequestMethod.POST)
	public ModelAndView recognizeKarma(@ModelAttribute BadgeTransaction badgeTransaction, HttpSession httpSession) {
		EmployeeDetails employeeDetails = (EmployeeDetails) httpSession.getAttribute("employeeDetails");
		ModelAndView modelAndView = new ModelAndView();
		if (employeeDetails == null) {
			modelAndView.addObject("msg", "Please login first!!!");
			modelAndView.setViewName("redirect:/login");
		}
		badgeTransaction.setSenderId(employeeDetails.getId());
		badgeTransaction.setDate(new Date());

		int success = badgeTransactionService.recognizeKarma(badgeTransaction);

		ReceivedBadges receivedBadges = service.getReceivedBadgesOfEmployee(employeeDetails);
		modelAndView.addObject("receivedBadges", receivedBadges);
		RemainingBadges remainingBadges = service.getRemainingBadgesOfEmployee(employeeDetails);
		modelAndView.addObject("remainingBadges", remainingBadges);
		modelAndView.addObject("successMessage", success);
		modelAndView.setViewName("redirect:/home");
		return modelAndView;
	}
}
