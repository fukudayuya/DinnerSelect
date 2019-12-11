package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.dinner;
import com.example.demo.service.dinnerService;

@RequestMapping("/dinner")
@Controller
public class topController {

	@Autowired
	private dinnerService service;

	@RequestMapping("/top")
	public String topPage() {
		return "topPage";
	}

	@RequestMapping("/start")
	public String startchoice(dinnerForm form,Model model) {

		int genreId = form.getFoodGenreId();
		int tasteId = form.getFoodTasteId();


		//どちらかが選択されていない場合
		if(genreId == 0 || tasteId == 0) {
			return "topPage";

		//ジャンルは全ジャンルで味はお任せの場合
		}else if(genreId == 4 && tasteId == 3) {
			genreId = (int)(Math.floor(Math.random()*3 + 1));
			tasteId = (int)(Math.floor(Math.random()*2 + 1));
			List<dinner> dinnerList = service.serchDinner(genreId,tasteId);
			//ランダムで値が取れなかった場合、再度取ってくる
			while(dinnerList.size() == 0) {
				dinnerList = service.serchDinner(genreId,tasteId);
			}
			model.addAttribute("dinnerList",dinnerList);

		//ジャンルはお任せ,味は指定
		}else if(genreId == 4 && tasteId <= 2){
			genreId = (int)(Math.floor(Math.random()*3 + 1));
			List<dinner> dinnerList = service.serchDinner(genreId,tasteId);
			while(dinnerList.size() == 0) {
				dinnerList = service.serchDinner(genreId,tasteId);
			}
			model.addAttribute("dinnerList",dinnerList);

		//ジャンル指定、味はお任せ
		}else if(genreId <= 3 && tasteId == 3) {
			tasteId = (int)(Math.floor(Math.random()*2 + 1));
			List<dinner> dinnerList = service.serchDinner(genreId,tasteId);
			while(dinnerList.size() == 0) {
				dinnerList = service.serchDinner(genreId,tasteId);
			}
			model.addAttribute("dinnerList",dinnerList);

		//ジャンル指定、味も指定
		}else {
			List<dinner> dinnerList = service.serchDinner(genreId,tasteId);
			while(dinnerList.size() == 0) {
				dinnerList = service.serchDinner(genreId,tasteId);
			}
			model.addAttribute("dinnerList",dinnerList);
		}

		return "choice";
	}


}
