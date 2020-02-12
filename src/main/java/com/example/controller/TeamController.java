package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Team;
import com.example.service.TeamService;

/**
 * コントローラークラス
 * @author yamaseki
 *
 */
@Controller
@RequestMapping("/")
public class TeamController {
	
	@Autowired
	private TeamService service;
	
	
	/**
	 * 野球チーム一覧を表示するためのメソッド.
	 * @param model　リクエストスコープ
	 * @return チーム一覧画面
	 */
	@RequestMapping("")
	public String index(Model model) {
		List<Team>teamList = service.showList();
		model.addAttribute("teamList",teamList);

		return "team-index";
	}
	
	/**
	 * チーム詳細画面を表示するためのメソッド.
	 * @param id
	 * @param model リクエストスコープ
	 * @return チーム詳細画面
	 * */
	@RequestMapping("/teamDetail")
	public String showDetail(Integer id,Model model) {
		Team team = service.findById(id);
		model.addAttribute("team",team);
		System.out.println(team.getHistory());
		return "team-detail";
	}

}
