package nashtech.ass.phuochg.coffeeshop.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import nashtech.ass.phuochg.coffeeshop.entities.Account;
import nashtech.ass.phuochg.coffeeshop.entities.Information;

@RestController
public class RegisterController {
	
	@GetMapping("/register")
	public String showSignUpForm(Model model) {
		model.addAttribute("user", new Account());
		model.addAttribute("infor", new Information());
		return "signup_form";
			
	}

}
