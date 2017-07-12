package com.coolapps.bootstrap;
/*
 * This class can be used to initialize any properties or data for the application startup.
 * 
 */

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class SpringBootStrap  implements ApplicationListener<ContextRefreshedEvent>{

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		// TODO Auto-generated method stub
		doInitEvents();
	}

	private void doInitEvents() {
		System.out.println("Startup activites");
		System.out.println("Startup activites:End");
		
		
	}

}
