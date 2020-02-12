package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Hotel;
import com.example.service.HotelService;


/**
 * ホテルコントローラー.
 * @author yamaseki
 *
 */
@Controller
@RequestMapping("/hotel")
public class HotelController {
	
	@Autowired
	private HotelService service;
	
	
	/**
	 * メインページへ遷移するためのメソッド.
	 * @return
	 */
	@RequestMapping("")
	public String index() {
		return "hotel";
	}
	
	
	/**
	 * ホテルを価格で検索するためのメソッド.
	 * @param price 検索したいホテルの価格
	 * @param model リクエストパラメーター
	 * @return メインページへ遷移する
	 */
	@RequestMapping("/search")
	public String searchByLessThanPrice(Integer price,Model model) {
		if(price==null) {
			price=100000000;
		}
		
		List<Hotel>hotelList = service.searchByLessThanPrice(price);
		model.addAttribute("hotelList",hotelList);
		System.out.println(hotelList);
		return index();
	}
}
