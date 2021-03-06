package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Team;


/**
 * 野球チームリポジトリ.
 * 
 * @author yamaseki
 *
 */
@Repository
public class TeamRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Team>TEAM_ROW_MAPPER = (rs,i) -> {
		Team team = new Team();
		team.setId(rs.getInt("id"));
		team.setTeamName(rs.getString("team_name"));
		team.setLeagueName(rs.getString("league_name"));
		team.setHeadQuarters(rs.getString("headquarters"));
		team.setInauguration(rs.getString("inauguration"));
		team.setHistory(rs.getString("history"));
		return team;
	};
	
	
	/**
	 * 全件検索のためのメソッド.
	 * @return チームリスト
	 */
	public List<Team> findAll(){
		String sql = "SELECT id,team_name,league_name,headquarters,inauguration,history FROM teams";
		List <Team> teamList = template.query(sql, TEAM_ROW_MAPPER);
		return teamList;
	}
	
	/**
	 * ID検索のためのメソッド.
	 * @return チーム情報
	 * @param id
	 */
	public Team findById(Integer id) {
		String sql = "SELECT id,team_name,league_name,headquarters,inauguration,history FROM teams WHERE id = :id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		Team team = template.queryForObject(sql, param, TEAM_ROW_MAPPER);
		return team;
	}
	
}
