package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.dinner;
import com.example.demo.repository.dinnerRepository;

@Service
public class dinnerService {


	@Autowired
	private dinnerRepository repository;

	public List<dinner> serchDinner(int genreId,int tasteId) {
		return repository.serchDinner(genreId,tasteId);
	}
}
