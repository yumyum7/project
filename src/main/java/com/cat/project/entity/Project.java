package com.cat.project.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.cat.project.img.Image;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long pId;
	
	@Column(nullable = false, updatable = true, length = 64)
	private String pName;
	
//	@ManyToOne
//	@JoinColumn(nullable = false, name = "account", referencedColumnName = "aId")
//	private Account account;
	
	@Column(nullable = false, columnDefinition = "TEXT")
	private String  pCreator;
	
    @Column(nullable = false, updatable = true, 
    		columnDefinition = "TEXT")
	private String pDesc;
    
    @Column(nullable = false, updatable = true, length = 64)
	private String pCate;

    @Column(nullable = false, updatable = true)
	private BigDecimal  pGoal;
	
//    @ColumnDefault("0") 
//    @Column(nullable = false, updatable = true)
//	private BigDecimal  pPled;

//    @ColumnDefault("0") 
//    @Column(nullable = false)
//	private Integer pIns;
    
    
	private  LocalDate pSdate;
	
    
	private  LocalDate pEdate;
	
	
//	@OneToOne
//	@JoinColumn(nullable = false, name = "projectStatus",referencedColumnName = "psId")
//	private ProjectStatus projectStatus; 
	
	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
	private List<ProjectUpdate> projectUpdateList;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="Image",referencedColumnName = "imgId")
	private Image imgIdR;
}