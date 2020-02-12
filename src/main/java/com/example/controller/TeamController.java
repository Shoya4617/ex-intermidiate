package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Team;
import com.example.service.TeamService;

@Controller
@RequestMapping("/")
public class TeamController {
	
	@Autowired
	private TeamService service;
	
	
	@RequestMapping("")
	public String index(Model model) {
		List<Team>teamList = service.showList();
		model.addAttribute("teamList",teamList);

		return "team-index";
	}
	
	@RequestMapping("/teamDetail")
	public String showDetail(Integer id,Model model) {
		Team team = service.findById(id);
		model.addAttribute("team",team);
		System.out.println(team.getHistory());
		return "team-detail";
	}

}
