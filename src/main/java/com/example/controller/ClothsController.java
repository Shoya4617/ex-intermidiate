package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Clothes;
import com.example.service.ClothesService;

/**
 * 衣類検索アプリコントローラークラス.
 * @author yamaseki
 *
 */
@Controller
@RequestMapping("/cloths")
public class ClothsController {
	
	@Autowired
	private ClothesService service;
	
	
	/**
	 * メイン画面へ遷移するためのメソッド.
	 * @return clothes.htmlへ遷移する
	 */
	@RequestMapping("")
	public String index() {
		return "clothes";
	}
	
	
	
	/**
	 * 衣類検索を行うためのメソッド.
	 * @param gender 検索したい衣類が男性用か女性用か
	 * @param color 検索したい衣類の色
	 * @param model リクエストパラメーター
	 * @return メイン画面へ戻る
	 */
	@RequestMapping("/search")
	public String search(Integer gender,String color,Model model) {
		List<Clothes>clothesList = service.searchByGenderAndColor(gender, color, model);
		 if(clothesList.isEmpty()) {
			 model.addAttribute("resultZero","検索結果はゼロです");
			 System.out.println(clothesList);
		 }
		 System.out.println(clothesList);
		model.addAttribute("clothesList",clothesList);
		return index();
	}

}
