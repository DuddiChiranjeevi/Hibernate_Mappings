package com.otmm.test;

import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.otmm.entities.Project;
import com.otmm.entities.Vendor;
import com.otmm.helper.SFRegistry;

public class OTMMTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;

		try {
			sessionFactory = SFRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
//		
//		Project project1=new Project();
//		project1.setProjectName("Building contract");
//		project1.setDescription("House construction at Tirupathi");
//		project1.setDuration(12);
//		project1.setEstimatedAmount(250000);
//		session.persist(project1);
//		
//		Project project2=new Project();
//		project2.setProjectName("Road contract");
//		project2.setDescription("Chottoor to puttur By-pass Road");
//		project2.setDuration(4);
//		project2.setEstimatedAmount(450000);
//		
//		session.persist(project2);
//		
//		
//		Vendor vendor=new Vendor();
//		vendor.setVendorName("J C Constructions");
//		vendor.setEstabelishedDate(LocalDate.now().minusYears(25));
//		vendor.setMobileNo("810000004");
//		vendor.setEmailId("jcconstructors@gmail.com");
//		
//		Map<String, Project> allocatedProjects=new HashMap<>();
//		allocatedProjects.put("BC001", project1);
//		allocatedProjects.put("RC002", project2);
//		vendor.setAllocatedProjects(allocatedProjects);
//		
//		session.persist(vendor);

			Vendor vendor = session.get(Vendor.class, 1);
			Map<String, Project> data = vendor.getAllocatedProjects();
			Project project = data.get("RC002");
			System.out.println(project);

			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
			throw e;
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
				} else {
					transaction.rollback();
				}
			}
			if (session != null) {
				session.close();
				session = null;
			}
		}
		SFRegistry.closeSessionFactory();
	}
}
