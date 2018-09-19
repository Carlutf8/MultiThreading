package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ThreadPool {
	
	@Autowired
	private ExecutorService executorService;
	
	public String testThreadPool() throws InterruptedException, ExecutionException 
	{
		long currentTimeMillis = System.currentTimeMillis();
		List<Future<String>> arrayList = new ArrayList<>();
		
		for(int i=1;i<10000;i++) 
		{
			myCallable myCallable = new myCallable(i);
			Future<String> submit = executorService.submit(myCallable);
			arrayList.add(submit);
		}
		for(Future<String> fu:arrayList) 
		{
			System.out.println(fu.get());
		}
		executorService.shutdown();
		long currentTimeMillis1 = System.currentTimeMillis();
		return (currentTimeMillis1-currentTimeMillis)+"-------77777";
		
	}
	
	
	private class myCallable implements Callable<String>
	{

		private int i;
		
		public  myCallable(int i) 
		{
			this.i=i;
		}
		
		@Override
		public String call() throws Exception 
		{
			if(i%2==0) 
			{
				Thread.sleep(10000);
				return "gg"+i;
			}
			return Thread.currentThread().getName()+"+++"+i;
		}
		
	}

}
