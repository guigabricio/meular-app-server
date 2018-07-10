package com.gabricio.meular.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.gabricio.meular.dto.WrapperDto;

@RestController
public class MyController {

	@Autowired
	WrapperDto wrapperDto;

}
