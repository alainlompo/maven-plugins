package org.hypernovae.apis.overlayspoc.web.controllers;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/two")
public class DependantTwoController {
	
	private static int counter = 0;
	private static final String VIEW_INDEX = "index";
	private static final String VIEW_INDEX2 = "index2";
	private static final String VIEW_INDEX3 = "index3";
	
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(DependantTwoController.class);

	@RequestMapping(value = "/dep2", method = RequestMethod.GET)
	public String welcome(ModelMap model) {

		model.addAttribute("message", "Welcome");
		model.addAttribute("counter", ++counter);
		logger.debug("Welcome from dependant Two ");
		logger.debug("[welcome] counter : {}", counter);

		// Spring uses InternalResourceViewResolver and return back index.jsp
		return VIEW_INDEX;

	}

	@RequestMapping(value = "/dep21/{name}", method = RequestMethod.GET)
	public String welcomeName(@PathVariable String name, ModelMap model) {

		model.addAttribute("message", "Welcome " + name);
		model.addAttribute("counter", ++counter);
		logger.debug("Welcome from dependant two " + name);
		logger.debug("[welcomeName] counter : {}", counter);
		return VIEW_INDEX;
	}
	
	@RequestMapping(value = "/dep22/dosquare/{number}", method = RequestMethod.GET)
	public String doSquare(@PathVariable String number, ModelMap model) {

		model.addAttribute("message", "Welcome anonymous...");
		model.addAttribute("counter", ++counter);
		logger.debug("Welcome from dependant two. We will compute the square of " + number);
		logger.debug("[welcome...] counter : {}", counter);
		int intNum = Integer.parseInt(number);
		int square = intNum*intNum;
		logger.debug("The square of " + number + " is " + square);
		
		return VIEW_INDEX2;
	}
	
	@RequestMapping(value = "/dep23", method = RequestMethod.GET)
	public String doSomething(ModelMap model) {		
		logger.debug("Welcome from dependant two. this ressource is directly owned....");
		
		return VIEW_INDEX3;
	}
}
