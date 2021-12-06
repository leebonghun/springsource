package com.company.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.domain.SampleDTO;

import lombok.extern.log4j.Log4j2;

/**
 * Handles requests for the application home page.
 */
@Log4j2
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	
	@ResponseBody
	@GetMapping(value="/sample2",produces= {MediaType.APPLICATION_JSON_VALUE})
	public SampleDTO sampleJson() {
		log.info("sample2");
		
		SampleDTO sample = new SampleDTO();
		sample.setFirstName("hong");
		sample.setLastName("dong");
		return sample;
	}
	@ResponseBody
	@GetMapping(value="/list2",produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<SampleDTO> sampleJsonList() {
		log.info("list2");
		
		List<SampleDTO> list = new ArrayList<SampleDTO>();
		
		for(int i=0; i<10;i++) {
			SampleDTO sample = new SampleDTO();
			sample.setMno(i+"");
			sample.setFirstName("hong");
			sample.setLastName("dong");
			list.add(sample);
		
		}
		return list;
	}
	
	
}
