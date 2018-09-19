package com.example.demo.collenter;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.ThreadPool;

@RestController()
public class TestCollenter {

	@Autowired
	private ThreadPool tp;
	
	@RequestMapping("/test")
	public String test() throws InterruptedException, ExecutionException 
	{
		return tp.testThreadPool();
	}
}
