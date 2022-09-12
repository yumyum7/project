package com.cat.reward;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@RequestMapping("/reward")
@RequiredArgsConstructor
@Controller
public class RewardController {
	private final RewardService rewardService;
	
	@GetMapping("/create")
	public String reward(RewardForm rewardForm) {
		return "reward_form";
	}
	
	@PostMapping("/create")
	public String reward(
			@Valid RewardForm rewardForm, BindingResult bindingResult
	) {
			if (bindingResult.hasErrors()) {
				return "reward_form";
			}
		    // TODO 질문을 저장한다.
			this.rewardService.create(
				rewardForm.getRwName(),
				rewardForm.getRwDesc(),
				rewardForm.getRwMin(), 
				rewardForm.getRwMax()
			);
		return "redirect:/project/list"; // 질문 저장후 질문목록으로 이동
	}
}
