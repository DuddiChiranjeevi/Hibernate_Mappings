package com.otma.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.otma.entities.Scheme;
import com.otma.helper.SFRegistry;

public class OTMATest {
public static void main(String[] args) {
	SessionFactory sessionFactory=null;
	Session session=null;
	Transaction transaction=null;
	boolean flag=false;
	
	try {
		sessionFactory =SFRegistry.getSessionFactory();
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		
//		Benificer benificer1=new Benificer();
//		benificer1.setFullName("Duddi Chiranjeevi");
//		benificer1.setDob(LocalDate.of(1998, 8, 6));
//		benificer1.setGender("Male");
//		benificer1.setEmailId("chiru@gmail.com");
//		benificer1.setMobileNo("9490642337");
//		benificer1.setAccountNo("6379748984");
//		benificer1.setIfscCode("IDIB000K028");
//		benificer1.setAadharNo(689613313884l);
//		
//		session.persist(benificer1);
//		
//		Benificer benificer2=new Benificer();
//		benificer2.setFullName("Jeevan Kumar D");
//		benificer2.setDob(LocalDate.of(1995, 5, 15));
//		benificer2.setGender("Male");
//		benificer2.setEmailId("jeevan@gmail.com");
//		benificer2.setMobileNo("9642842463");
//		benificer2.setAccountNo("7564842463");
//		benificer2.setIfscCode("IDIB000K028");
//		benificer2.setAadharNo(542463248521l);
//		session.persist(benificer2);
//		
//		
//		Set<Benificer> benificers=new HashSet<>();
//		benificers.add(benificer1);
//		benificers.add(benificer2);
//		
//		
//		Scheme scheme=new Scheme();
//		scheme.setSchemeName("PM-Kisan");
//		scheme.setIntroducedDate(LocalDate.now());
//		scheme.setEligibleAmount(2000);
//		scheme.setStatus("Eligible");
//		scheme.setBenificers(benificers);
//		session.persist(scheme);
	
		Scheme scheme=session.get(Scheme.class, 1);
		System.out.println(scheme);
		
		flag = true;
		
	}catch(Exception e) {
		e.printStackTrace();
		flag=false;
		throw e;
	}finally {
		if( transaction !=null) {
			if(flag) {
				transaction.commit();
			}else {
				transaction.rollback();
			}
		}
		if(session !=null) {
			session.close();
			session=null;
		}
	}
	SFRegistry.closeSessionFactory();
}
}
