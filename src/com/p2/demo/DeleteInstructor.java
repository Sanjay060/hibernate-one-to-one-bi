package com.p2.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.p2.demo.entity.InstructorDetail;

public class DeleteInstructor {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("hibernate-example1");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		try
		{
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			int id=2;
			InstructorDetail i=entityManager.find(InstructorDetail.class, id);
			System.out.println("InstructorDetail: "+i);
			System.out.println("Instructor: "+i.getInstructor());
			//deleting the instructor_detail entity it also delete the instructor entity//
			entityManager.remove(i);
			entityTransaction.commit();
			System.out.println(i);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			entityManagerFactory.close();
		}

	}

}
