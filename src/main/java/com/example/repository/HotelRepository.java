package com.example.repository;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Hotel;


/**
 * ホテル検索用リポジトリ.
 * @author yamaseki
 *
 */

@Repository
public class HotelRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final RowMapper<Hotel>HOTEL_ROW_MAPPER = (rs,i) -> {
		Hotel hotel = new Hotel();
		hotel.setId(rs.getInt("id"));
		hotel.setAreaName(rs.getString("area_name"));
		hotel.setHotelName(rs.getString("hotel_name"));
		hotel.setAddress(rs.getString("address"));
		hotel.setNearestStation(rs.getString("nearest_station"));
		hotel.setPrice(rs.getInt("price"));
		hotel.setParking(rs.getString("parking"));

		return hotel;
	};
	
	
	/**
	 * 希望価格以下の価格でホテルを検索するためのメソッド.
	 * 
	 * @param price 希望価格
	 * @return 検索したホテルの一覧
	 */
	public List<Hotel>findByPrice(Integer price){
		String sql = "select id,area_name,hotel_name,address,nearest_station,price,parking from hotels where price <= :price";
		SqlParameterSource param = new MapSqlParameterSource().addValue("price", price);
		List<Hotel> hotelList = template.query(sql, param, HOTEL_ROW_MAPPER);
		return hotelList;
	}
}
