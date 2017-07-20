package de.codecentric.psd.worblehat.web.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ModelMap;

import de.codecentric.psd.worblehat.web.StartupMonitor;

public class NavigationControllerTest {

	private ModelMap modelMap;

	@Before
	public void setUp() throws Exception {
		modelMap = new ModelMap();
	}

	@Test
	public void shouldNavigateToHome() throws Exception {

		StartupMonitor.PROPERTIES_MAP = new HashMap<>();
		
		StartupMonitor.PROPERTIES_MAP.put("info.version", "Version: 1.2.3");

		modelMap.addAttribute("version", "Version: " + StartupMonitor.PROPERTIES_MAP.get("info.version"));
		String navigateTo = new NavigationController().home(modelMap);

		assertThat(navigateTo, is("home"));
	}
}