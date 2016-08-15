package com.cabinet.AnXin_file.loadinit;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.cabinet.AnXin_file.service.LoginService;

public class Loadinit implements ApplicationListener<ContextRefreshedEvent> {

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		LoginService.loadinit();
		
		System.out.println("loadinit");
	}	
	
}
