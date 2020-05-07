package pl.wb.demo.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	@GetMapping("/")
	public String showHome() {
		
		return "home";
	}
	
	// add request mapping for /managers

	@GetMapping("/managers")
	public String showLeaders() {
		
		return "managers";
	}
	
	// add request mapping for /admin
	
	@GetMapping("/admin")
	public String showSystems() {
		
		return "admin";
	}
	
}










