package com.nepnep.wiki.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nepnep.wiki.common.URLs;
import com.nepnep.wiki.exception.ApiException;
import com.nepnep.wiki.exception.ErrorCode;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(URLs.USER)
@Slf4j
public class UserController {

	
	@GetMapping("/list")
	public String getUsers(){		
		
		
		log.debug("");
		log.trace("");
		log.info("");
		log.error("");
		log.warn("");
		
		
		throw new ApiException(ErrorCode.USER_NOT_FOUND);
//		return "s";
	}
	
}
