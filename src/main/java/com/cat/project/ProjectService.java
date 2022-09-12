package com.cat.project;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import com.cat.project.img.Image;

import org.springframework.stereotype.Service;

import com.cat.DataNotFoundException;
import com.cat.project.entity.Project;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProjectService {
	private final ProjectRepository projectRepository;
	
	public List<Project> getList(){
		return this.projectRepository.findAll();
	}
	
	public List<Project> searchkw(String kw){
		return this.projectRepository.findAllByKeyword(kw);
	}

	
	public List<Project> getCateList(String pCate){
		return this.projectRepository.findAllByCate(pCate);
	}
	
	public Project getProject(Long pId) {
		Optional<Project> project = this.projectRepository.findById(pId);
		if(project.isPresent()) {
			return project.get();
		}else {
			throw new DataNotFoundException("project not found");
		}
	}
	
	public void create(String pCate, String pName, String pDesc, 
			BigDecimal pGoal, LocalDate pSdate, LocalDate pEdate, String pCreator, Image imgId)
	{
		Project p = new Project();
		p.setPCate(pCate);
		p.setPName(pName);
        p.setPDesc(pDesc);
        p.setPGoal(pGoal);
        p.setPSdate(pSdate);
        p.setPEdate(pEdate);
        p.setPCreator(pCreator);
        p.setImgIdR(imgId);
        this.projectRepository.save(p);
	}
}
