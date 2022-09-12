package com.cat.project.update;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cat.project.ProjectService;
import com.cat.project.entity.Project;

import lombok.RequiredArgsConstructor;

@RequestMapping("/project/update")
@RequiredArgsConstructor
@Controller
public class UpdateController {

	private final ProjectService projectService;
	private final UpdateService updateService;
	
	@RequestMapping(value="/{pId}")
	public String projectUpdate(Model model, @PathVariable("pId") Long pId){
		Project project = this.projectService.getProject(pId);
		model.addAttribute("project", project);
		return "project_update";
	}

	@PostMapping("/create/{pId}")
	public String createUpdate(Model model, @PathVariable("pId") Long pId, @RequestParam String uText) {
		Project project = this.projectService.getProject(pId);
		this.updateService.create(project, uText);
		return String.format("redirect:/project/update/%s", pId);
	}
}
