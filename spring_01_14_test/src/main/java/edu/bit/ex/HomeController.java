package edu.bit.ex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.bit.circle.Circle;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping("/circle")
	public String circle() {
		logger.info("circle");
		
		return "circle";
	}
	
	@RequestMapping("/circleArea")
	public String circleArea(Circle circle) {
		logger.info("circleArea");
		
		return "circleArea";
	}
	
}
