package com.otml.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.otml.entities.Order;
import com.otml.entities.Restaurant;
import com.otml.helper.SFRegistry;

public class OTMLTest {
public static void main(String[] args) {
	SessionFactory sessionFactory=null;
	Session session=null;
	Transaction transaction=null;
	boolean flag=false;
	try {
		sessionFactory =SFRegistry.getSessionFactory();
		session=sessionFactory.openSession();
		transaction =session.beginTransaction();
		
		Order order1=new Order();
		order1.setCustomerName("Duddi Chiranjeevi");
		order1.setMobileNo("9059798193");
		order1.setEmailId("chiru@gmail.com");
		order1.setOrderDate(LocalDate.now());
		order1.setAmount(500);
		session.persist(order1);
		
		Order order2=new Order();
		order2.setCustomerName("Duddi Chiranjeevi");
		order2.setMobileNo("9059798193");
		order2.setEmailId("chiru@gmail.com");
		order2.setOrderDate(LocalDate.now());
		order2.setAmount(500);
		session.persist(order2);
		
		Restaurant restaurant=new Restaurant();
		restaurant.setRestaurantName("Green bawachi");
		restaurant.setAddress("Rx-cross roads, Hyderabad");
		restaurant.setContactNo("900000001");
		restaurant.setEmailId("bawachi.delicious@gmail.com");
		restaurant.setRating(4);
		
		List<Order> orders=new ArrayList<>();
		orders.add(order1);
		orders.add(order2);
		restaurant.setOrders(orders);
		
		session.persist(restaurant);
		
		Restaurant restaurant2=session.get(Restaurant.class, 1);
		System.out.println(restaurant2.getOrders());
		
		flag=true;
	}catch (Throwable t) {
		t.printStackTrace();
		flag=false;
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
