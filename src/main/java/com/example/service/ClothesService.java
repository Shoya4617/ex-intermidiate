package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.example.domain.Clothes;
import com.example.repository.ClothesRepository;



/**
 * 衣類検索アプリサービスクラス.
 * @author yamaseki
 *
 */
@Service
@Transactional
public class ClothesService {
	
	@Autowired
	ClothesRepository repository;
	
	
	/**
	 * 性別と色から衣類を検索するメソッド.
	 * @param gender 検索したい衣類が男性ものか女性ものか
	 * @param color 検索したい衣類の色
	 * @return 検索した衣類のリスト
	 */
	public List<Clothes>searchByGenderAndColor(Integer gender,String color,Model model){
		 List<Clothes>clothesList = repository.findByGenderAndColor(gender, color);

		 return clothesList;
	}

}
