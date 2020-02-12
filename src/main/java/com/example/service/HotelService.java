package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Hotel;
import com.example.repository.HotelRepository;


/**
 * ホテルサービスクラス.
 * @author yamaseki
 *
 */
@Service
@Transactional
public class HotelService {

	@Autowired
	private HotelRepository repository;
	
	
	/**
	 * 希望価格以下の価格でホテルを検索するためのメソッド.
	 * @param price 希望価格
	 * @return　ホテル一覧
	 */
	public List<Hotel>searchByLessThanPrice(Integer price){
		List<Hotel>hotelList = repository.findByPrice(price);
		return hotelList;
	}
}
