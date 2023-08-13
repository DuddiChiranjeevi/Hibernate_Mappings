package com.otma.test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.otma.entities.Course;
import com.otma.entities.Student;
import com.otma.helper.SFRegistry;

public class OTMAnnoTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		try {
			sessionFactory = SFRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
////
////			Student student1 = Student.of().studentName("Chiranjeevi").gender("Male").dob(LocalDate.of(1998, 8, 6))
////					.emailId("chiru@gmail.com").mobileNo("7095793613").build();
////
////			session.persist(student1);
////			System.out.println("Student no :" + student1.getStudentId());
////
////			Student student2 = Student.of().studentName("Rakesh").gender("Male").dob(LocalDate.of(1997, 11, 26))
////					.emailId("chiru@gmail.com").mobileNo("7095793613").build();
////
////			session.persist(student2);
////			System.out.println("Student no :" + student2.getStudentId());
//
//			Student student1=session.get(Student.class, 1);
//			Student student2=session.get(Student.class, 2);
//			
//			Set<Student> students=new HashSet<>();
//			students.add(student1);
//			students.add(student2);
//			Course course=Course.of().courseName("Java").duration(90).fee(8000).students(students).build();
//			
//			session.persist(course);
//			System.out.println("Course Id: "+course.getCourseId());
			
			Student student=new Student();
			student.setStudentName("chiranjeei");
			student.setMobileNo("9059798193");
			student.setDob(LocalDate.of(1998, 8, 6));
			student.setEmailId("chiru@gmail.com");
			student.setGender("Male");

			Set<Student> students=new HashSet<>();
			students.add(student);
					
					
			Course course=Course.of().courseName("Spring framework").duration(8).fee(8000).students(students).build();
			
			session.persist(course);
			System.out.println("Course Id: "+course.getCourseId());
			
			student.setCourses(course);
			session.persist(student);
			System.out.println("Student Id:"+student.getStudentId());
			
			
//			Student student=session.get(Student.class, 1);
//			System.out.println(student.getStudentName());
			
//			Course course=session.get(Course.class, 1);
//			System.out.println(course);
//			Set<Student> students=course.getStudents();
//			System.out.println("Class Name : "+students.getClass().getName());
//			
//		students.forEach(System.out::println);
			
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
