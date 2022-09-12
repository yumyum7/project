package com.cat.investor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/invest")
@Controller
public class InvestorController {

	@RequestMapping("/or")
	public String invest() {
		return "project_invest";
	}
	
	@RequestMapping("/pledged")
	public String pledged() {
		return "pledged";
	}
	
	@RequestMapping("/complete")
	public String complete() {
		return "complete";
	}
}
