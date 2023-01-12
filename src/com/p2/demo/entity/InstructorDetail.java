package com.p2.demo.entity;

import javax.annotation.processing.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor_detail")
public class InstructorDetail {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="course")
	private String course;
	@Column(name="hobby")
	private String hobby;
	//for bi_direction adding mapped by with annotation//
	//generate getter and setter for Instructor field//
	//here mappedBy "instructorDetail refers to the field in Instructor class//
	@OneToOne(mappedBy = "instructorDetail",cascade=CascadeType.ALL)
	private Instructor instructor;
	
	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	public InstructorDetail() {
		
	}
	
	public InstructorDetail(String course, String hobby) {
		this.course = course;
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", course=" + course + ", hobby=" + hobby + "]";
	}
	
	
}
