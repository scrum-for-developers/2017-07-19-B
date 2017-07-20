package de.codecentric.psd.worblehat.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.codecentric.psd.worblehat.web.StartupMonitor;

/**
 * Controller for Navigation
 */
@Controller
public class NavigationController {

	public String version = "";

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(ModelMap modelMap) {
		modelMap.addAttribute("version", "Version: " + StartupMonitor.PROPERTIES_MAP.get("info.version"));

		return "home";
	}

}
