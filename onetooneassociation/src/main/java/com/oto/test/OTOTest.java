package com.oto.test;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.oto.entities.Bill;
import com.oto.entities.ItemizedBill;
import com.oto.helper.SFRegistry;

public class OTOTest {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory=null;
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		try {
			sessionFactory =SFRegistry.getSessionFactory();
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			
			Bill bill=new Bill();
			
			 bill.setBillName("Realme c 25 mobile bill");
			 bill.setBillGenratedDate(LocalDate.now());
			 bill.setCustomerName("Chiranjeevi");
			 bill.setMobileNo("9059798193");
			 bill.setDueDate(LocalDate.now().plusDays(5));
			 bill.setBillAmount("1000");
			 
			 session.persist(bill);
			
			ItemizedBill itemizedBill=new ItemizedBill();
			itemizedBill.setVoiceCall(100);
			itemizedBill.setInternationalVoiceCall(1000);
			itemizedBill.setRommingVoice(150);
			itemizedBill.setMessage(100);
			itemizedBill.setPreviousDueAmount(250);
			itemizedBill.setBill(bill);
			session.persist(itemizedBill);
			
			ItemizedBill itemizedBill1=session.get(ItemizedBill.class, 1);
			System.out.println(itemizedBill1);
			
			flag=true;
		}catch(Exception e) {
			flag=false;
			e.printStackTrace();
			throw e;
		}finally {
			if(transaction !=null) {
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
