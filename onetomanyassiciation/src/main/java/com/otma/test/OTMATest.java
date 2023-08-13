package com.otma.test;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.otma.entities.Course;
import com.otma.entities.Student;
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
			
			Student student1=new Student();
			student1.setFullName("Chiranjeevi");
			student1.setAge(LocalDate.of(1998, 8, 6));
			student1.setGender("Male");
			student1.setMobileNo("9059798193");
			student1.setEmailId("Chiru@gmail.com");
			session.persist(student1);
			Student student2=new Student();
			student2.setFullName("Praveen");
			student2.setAge(LocalDate.of(1998, 12, 13));
			student2.setGender("Male");
			student2.setMobileNo("8148675718");
			student2.setEmailId("praveen@gmail.com");
//			
//			session.persist(student2);
//			Set< Student> students=new HashSet<>();
//			students.add(student1);
//			students.add(student2);
//			
//			
//			
//			Course course=new Course();
//			course.setCourseName("Java");
//			course.setStartingDate(LocalDate.now());
//			course.setDurationInMonths(6);
//			course.setFee(10000);
//			course.setTrainerName("Sriman P");
//			course.setInstituteName("Durga Soft");
//			course.setContactNo("9022456745");
//			course.setStudents(students);
//			
//			session.persist(course);	
			
			
			Course course=session.get(Course.class, 1);
			course.getStudents().forEach(System.out::println);
			/*
			Another side Mapping relation
			*/
			
//			Course course2=new Course();
//			course2.setCourseName("Microservices");
//			course2.setStartingDate(LocalDate.now().plusDays(5));
//			course2.setDurationInMonths(3);
//			course2.setFee(4000);
//			course2.setInstituteName("DurgaSoft");
//			course2.setTrainerName("Sriman P");
//			course2.setContactNo("94432222");
//			
//			session.persist(course);
//			
//			Student student=new Student();
//			student.setFullName("Sai kumar");
//			student.setAge(LocalDate.of(1998, 10, 06));
//			student.setGender("Male");
//			student.setEmailId("sai@gmail.com");
//			student.setMobileNo("9162542483");
//			student.setCourse(course);
//			session.persist(student);
			
//			Student student=session.get(Student.class, 1);
//			System.out.println(student);
//			System.out.println("Get course datails: "+student.getCourse());
//			
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
