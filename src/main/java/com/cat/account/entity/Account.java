package com.cat.account.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long aId;
	
	@Column(nullable = false, columnDefinition = "TEXT")
	private String aPw;
	
	@Column(nullable = false, length = 64, unique = true)
	private String aEmail;
	
	@Column(nullable = false, unique = true, columnDefinition = "TEXT")
	private String aName;
	
	//기본값 2: member, 1: admin은 따로 지정해야 함
	private String aRole = "2";
}