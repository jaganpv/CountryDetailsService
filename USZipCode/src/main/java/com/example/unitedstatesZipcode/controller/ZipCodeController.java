package com.example.unitedstatesZipcode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/")
public class ZipCodeController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/getCountryDetail/{countrycode}/{zipcode}")
	public ResponseEntity<String> getZipCodeDetails(@PathVariable String countrycode,@PathVariable String zipcode){
		return ResponseEntity.ok(restTemplate.getForObject("https://api.zippopotam.us/"+countrycode+"/"+zipcode,String.class));
	}
}
