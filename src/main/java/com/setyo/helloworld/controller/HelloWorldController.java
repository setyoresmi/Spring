package com.setyo.helloworld.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.setyo.helloworld.model.HelloWorldBean;

@RestController
public class HelloWorldController {
	/*get string*/
	@RequestMapping(method=RequestMethod.GET,path="/helloworld")
	public String getHelloWorld() {
		return "Hello World";
	}
	
	/*get object*/
	@GetMapping(path="/helloworldbean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean();
	}
	
	/*get object using parameter {message}*/
	@GetMapping(path="/helloworldbean/{message}")
	public HelloWorldBean helloWorldBean(@PathVariable String message) {
		return new HelloWorldBean(message);
	}
	
	/*get string using header*/
	@RequestMapping(value="/helloworld",	headers={"key1=val1","key2=val2"},method=RequestMethod.GET)
	public String getHelloWithHeaders() {
		return "Get hello with headers";
	}	
	
	/*post string*/
	@RequestMapping(value="/hello/post",method=RequestMethod.POST)
	public String postHelloWorld() {
		return "Post some hello";
	}
	
	/*posting string using postmapping*/
	@PostMapping("/post")
	public @ResponseBody ResponseEntity<String> post(){
		return new ResponseEntity<String>("Post Response",HttpStatus.OK);
	}
	
}
