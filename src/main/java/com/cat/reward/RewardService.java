package com.cat.reward;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RewardService {
	private final RewardRepository rewardRepository;
	
	public void create(String rwName, String rwDesc, BigDecimal rwMin,
			BigDecimal rwMax)
	{
		Reward r = new Reward();
		r.setRwName(rwName);
		r.setRwDesc(rwDesc);
		r.setRwMin(rwMin);
		r.setRwMax(rwMax);
		this.rewardRepository.save(r);
	}
}
