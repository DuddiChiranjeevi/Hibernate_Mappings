package com.mtm.test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.mtm.entities.Employee;
import com.mtm.entities.Project;
import com.mtm.helper.PFRegistry;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

public class MTMJAnnoTest {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		boolean flag = false;
		try {

			entityManagerFactory = PFRegistry.getEmfEntityManagerFactory();
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();

//			Employee employee1=Employee.of().empName("Saikumar").dob(LocalDate.of(1998, 8, 6)).gender("Male").emailId("chiru@gmail.com").mobileNo("9059798193").designation("application developer").build();
//			Employee employee2=Employee.of().empName("Mani").dob(LocalDate.of(1997, 8, 6)).gender("Male").emailId("rakesh@gmail.com").mobileNo("7095793613").designation("application developer").build();
//			
//			entityManager.persist(employee1);
//			System.out.println("Employee id: "+employee1.getEmpId());
//			
//			entityManager.persist(employee2);
//			System.out.println("Employee id: "+employee2.getEmpId());
//			
//			entityManager.persist(employee1);
//			Set<Employee> employees= new HashSet<>();
//			employees.add(employee1);
//			employees.add(employee2);
//			
//			Project project=Project.of().projectName("Ih core").duration(12).description("Ih core integerations ").statedDate(LocalDate.now()).employees(employees).build();
//	
//		entityManager.persist(project);
//		
//		System.out.println("Project no : "+project.getProjectId());

			Project project = entityManager.find(Project.class, 1);
			project.getEmployees().forEach(System.out::println);

			Project project2 = Project.of().projectName("Integiration hub").statedDate(LocalDate.now())
					.description("Integirating all the application with IH").duration(24).build();
			Project project3 = Project.of().projectName("MDM").statedDate(LocalDate.now())
					.description("MDM").duration(14).build();
			
			entityManager.persist(project2);
			System.out.println("Project  no: "+project2.getProjectId());
			entityManager.persist(project3);
			System.out.println("Project  no: "+project3.getProjectId());
			
			Set<Project> projects=new HashSet<>();
			projects.add(project3);
			projects.add(project2);
			
			Employee employee=Employee.of().empName("Ramana").dob(LocalDate.of(1998, 8, 6)).gender("Male").emailId("ramana@gmail.com").mobileNo("9059798193").designation("application developer").projects(projects).build();
			entityManager.persist(employee);
			
			System.out.println("Employee id: "+employee.getEmpId());
			
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
			throw e;
		} finally {
			if (entityTransaction != null) {
				if (flag) {
					entityTransaction.commit();
				} else {
					entityTransaction.rollback();
				}

			}
			if (entityManager != null) {
				entityManager.close();
				entityManager = null;
			}
		}
		PFRegistry.closeEntityManagerFactory();
	}
}
