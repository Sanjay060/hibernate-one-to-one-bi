package com.p2.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.p2.demo.entity.Instructor;
import com.p2.demo.entity.InstructorDetail;

public class CreateInstructor {
	public static void main(String[]args)
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("hibernate-example1");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		try
		{
			EntityTransaction entityTransaction=entityManager.getTransaction();
			Instructor i1=new Instructor("sanjay" ,"c","c338068@gmail.com");
			InstructorDetail i2=new InstructorDetail("java","film");
			i1.setInstructorDetail(i2);
			entityTransaction.begin();
			entityManager.persist(i1);
			entityTransaction.commit();
			System.out.println("done...");
			}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			entityManager.close();
		}
	}

}
