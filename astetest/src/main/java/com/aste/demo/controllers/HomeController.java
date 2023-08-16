package com.aste.demo.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aste.demo.models.Email;
import com.aste.demo.services.EmailService;

@Controller
@RequestMapping("/mail")
public class HomeController {

	@Autowired
	private EmailService emailService;
	

	@PostMapping("/sendmail")
	public String sendMail(@ModelAttribute Email email ,HttpSession session) {
		
		emailService.sendMail(email);
		session.setAttribute("message", "Email Send Successfully");
		return "redirect:/";

	}

}
