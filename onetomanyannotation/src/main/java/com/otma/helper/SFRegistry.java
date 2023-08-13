package com.otma.helper;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SFRegistry {

	private static SessionFactory sessionFactory;
	static {
		try {
			Configuration configuration=new Configuration().configure("hibernate.cfg.xml");
			System.out.println(configuration.getProperty("driverClassname"));
			sessionFactory=configuration.buildSessionFactory();
		}catch(Throwable t) {
			t.printStackTrace();
			throw t;
		}
		
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static void closeSessionFactory() {
		if(sessionFactory !=null) {
			sessionFactory.close();
			sessionFactory=null;
		}
		return ;
	}
}
