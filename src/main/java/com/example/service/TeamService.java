package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Team;
import com.example.repository.TeamRepository;


/**
 * チーム情報を操作するサービスクラス.
 * @author yamaseki
 *
 */
@Service
@Transactional
public class TeamService {
	
	@Autowired
	private TeamRepository repository;
	
	
	/**
	 * レポジトリの全件検索を行うためのメソッド,
	 * @return 野球チーム全件リスト
	 */
	public List<Team> showList(){
		List<Team> teamList = repository.findAll();
		return teamList;
	}
	
	/**
	 * レポジトリのid検索を行うためのメソッド.
	 * @param id ID
	 * @return 野球チーム情報
	 */
	public Team findById(Integer id) {
		Team team = repository.findById(id);
		return team;
	}

}
