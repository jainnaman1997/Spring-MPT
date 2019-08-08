package com.cg.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sessions")
public class Session {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="name", length=20)
	private String name;
	
	@Column(name="duration", length=2)
	private int duration;
	
	@Column(name="faculty", length=20)
	private String faculty;
	
	@Column(name="modes", length=3)
	private String mode;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public Session() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Session(int id, String name, int duration, String faculty, String mode) {
		super();
		this.id = id;
		this.name = name;
		this.duration = duration;
		this.faculty = faculty;
		this.mode = mode;
	}

	@Override
	public String toString() {
		return "Session [id=" + id + ", name=" + name + ", duration=" + duration + ", faculty=" + faculty + ", mode="
				+ mode + "]";
	}
	
	
	
	
}
