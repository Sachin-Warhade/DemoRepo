package com.cdac.main;

import org.hibernate.cfg.Configuration;

public class AppMain {

	public static void main(String[] args) {
		
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		

	}

}
