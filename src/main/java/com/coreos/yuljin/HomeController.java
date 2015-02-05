package com.coreos.yuljin;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws UnknownHostException 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws UnknownHostException {
		logger.info("Welcome home !! The client locale is {}.", locale);
		
		InetAddress inetAddress = InetAddress.getLocalHost();
		String hostName = inetAddress.getHostName();
		String ipAddress = inetAddress.getHostAddress();
		
		model.addAttribute("hostName", hostName);
		model.addAttribute("ipAddress", ipAddress);
		
		return "home";
	}
	
}
