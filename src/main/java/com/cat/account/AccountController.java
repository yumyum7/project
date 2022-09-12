package com.cat.account;

import javax.validation.Valid;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/account")
@Controller
public class AccountController {

	private final AccountService accountService;
	
	@RequestMapping("/signin")
	public String login() {
		return "login";
	}
	
	@GetMapping("/signup")
	public String signup(AccountCreateForm accountCreateForm) {
		return "signup";
	}
	
	@PostMapping("/signup")
	public String signup(@Valid AccountCreateForm accountCreateForm, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "signup";
		}
		
		if(!accountCreateForm.getAPw1().equals(accountCreateForm.getAPw2())) {
			bindingResult.rejectValue("aPw2", "passwordIncorrect", "비밀번호 확인이 일치하지 않습니다.");
			return "signup";
		}
		
		if(!accountCreateForm.getAEmail1().equals(accountCreateForm.getAEmail2())) {
			bindingResult.rejectValue("aEmail2", "emailIncorrect", "이메일 확인이 일치하지 않습니다.");
			return "signup";
		}
		
		try {
			accountService.create(accountCreateForm.getAName(),
								  accountCreateForm.getAEmail1(),
								  accountCreateForm.getAPw1());
		}catch(DataIntegrityViolationException e) {
			e.printStackTrace();
			bindingResult.reject("signupFailed", "이미 등록된 사용자입니다.");
			return "signup";
		}catch(Exception e) {
			e.printStackTrace();
			bindingResult.reject("signupFailed", e.getMessage());
			return "signup";
		}
		

		
		return "redirect:/";
	}
	
	
	@RequestMapping("/loginsuccess")
	public String loginsuccess() {
		return "loginsuccess";
	}
	
	@RequestMapping("/resetpwd")
	public String resetpwd() {
		return "resetpassword";
	}
	
	@GetMapping("/findpwd")
	public String findpwd() {
		return "findpassword";
	}
	
	@RequestMapping("/myproject")
	public String myproject() {
		return "myproject";
	}
	
	@RequestMapping("/setaccount")
	public String setaccount() {
		return "setting_account_a";
	}
	
	@GetMapping("/setaccountForm")
	public String setaccount_form() {
		return "setting_account_b";
	}
	
	@RequestMapping("/setaddress")
	public String setaddress() {
		return "setting_address_a";
	}
	
	@GetMapping("/setaddressForm")
	public String setaddress_form() {
		return "setting_address_b";
	}
	
	@RequestMapping("/setnotice")
	public String setnotice() {
		return "setting_notice_a";
	}
	
	@GetMapping("/setnotice_form")
	public String setnotice_form() {
		return "setting_notice_b";
	}
	
	@GetMapping("/profile")
	public String profile() {
		return "profile";
	}
}
