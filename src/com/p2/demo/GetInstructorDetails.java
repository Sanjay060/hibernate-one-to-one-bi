package com.p2.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.p2.demo.entity.InstructorDetail;

public class GetInstructorDetails {
	public static void main(String[]args)
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("hibernate-example1");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		try {
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			int id=10;
			InstructorDetail instructorDetail=entityManager.find(InstructorDetail.class, id);
			System.out.println("Instructor_Detail: "+instructorDetail);
			System.out.println("Instructor: "+instructorDetail.getInstructor());
			entityTransaction.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			entityManager.close();
		}
	}

}
