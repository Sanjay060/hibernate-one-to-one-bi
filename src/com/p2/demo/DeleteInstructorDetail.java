package com.p2.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.p2.demo.entity.InstructorDetail;
//To delete only instructor_detail first we want to break the bi-directional link b/w the to entity and then remove//
//change the cascade-type all to other cascade type except remove in instructor-detail.class//
public class DeleteInstructorDetail {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("hibernate-example1");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		try {
			EntityTransaction entityTransaction=entityManager.getTransaction();
			int id=3;
			InstructorDetail i=entityManager.find(InstructorDetail.class, id);
			entityTransaction.begin();
			System.out.println("removing the instructor detail id: "+i);
			i.getInstructor().setInstructorDetail(null);
			entityManager.remove(i);
			System.out.println("removed...");
			entityTransaction.commit();
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
		finally
		{
			entityManager.close();
		}

	}

}
