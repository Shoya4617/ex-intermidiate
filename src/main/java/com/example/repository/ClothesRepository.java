package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Clothes;


/**
 * 衣類検索アプリのリポジトリ.
 * @author yamaseki
 *
 */
@Repository
public class ClothesRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final RowMapper<Clothes>CLOTHES_ROW_MAPPER = (rs,i) -> {
		Clothes clothes = new Clothes();
		clothes.setId(rs.getInt("id"));
		clothes.setCategory(rs.getString("category"));
		clothes.setGenre(rs.getString("genre"));
		clothes.setGender(rs.getInt("gender"));
		clothes.setColor(rs.getString("color"));
		clothes.setPrice(rs.getInt("price"));
		clothes.setSize(rs.getString("size"));

		return clothes;
	};
	
	
	/**
	 * 性別と色で衣類検索を行うためのメソッド.
	 * @param gender 性別
	 * @param color　検索したい衣服の色
	 * @return 検索された衣類のリスト
	 */
	public List<Clothes>findByGenderAndColor(Integer gender,String color){
		String sql = "select id,category,genre,gender,color,price,size from clothes where gender = :gender AND color = :color order by id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("gender", gender).addValue("color",color);
		List<Clothes> clothesList = template.query(sql, param,CLOTHES_ROW_MAPPER);
		return clothesList;
	}

}
