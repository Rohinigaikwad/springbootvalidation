package com.onlinetutorialspoint.login;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@RestController
public class LoginController extends WebMvcConfigurerAdapter {

	@Autowired
	private LoginRepository loginRepository;


	@GetMapping("/")
	public String showSignInForm(LoginForm loginForm) {
		return "login";
	}

	@PostMapping("/")
	public String addUser(@Valid LoginForm loginForm, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "login";
		}

		loginRepository.save(loginForm);
		model.addAttribute("users",loginRepository.findAll());
		return "home";
	}

	/*@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("home");
	}

	@GetMapping("/")
	public String showForm(LoginForm loginForm) {
		return "login";
	}

	@PostMapping("/")
	public String validateLoginInfo(Model model, @Valid LoginForm loginForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "login";
		}
		model.addAttribute("user", loginForm.getuserName());
		return "home";
	}*/




}
