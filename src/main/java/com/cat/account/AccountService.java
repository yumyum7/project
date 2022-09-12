package com.cat.account;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cat.account.entity.Account;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AccountService {

	private final AccountRepository accountRepository;
	private final PasswordEncoder passwordEncoder;
	
	public Account create(String aPw, String aEmail, String aName) {
		Account account = new Account();
		account.setAName(aName);
		account.setAEmail(aEmail);
		account.setAPw(passwordEncoder.encode(aPw));
		this.accountRepository.save(account);
		return account;
	}
	
}
