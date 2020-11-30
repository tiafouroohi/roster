package com.tia.roster.models;

import java.util.Date;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable=false)
    private Long id;
    private String firstName;
    private String lastName;
    private String age;
    private Date createdAt;
    private Date updatedAt;
    @OneToOne(mappedBy="student",cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private Contact contact;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="dorm_id")
    private Dorm dorm;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "class_student", 
        joinColumns = @JoinColumn(name = "student_id"), 
        inverseJoinColumns = @JoinColumn(name = "class_id")
    )
    private List<Class> classes;
    
    
    public Student() {
        
    }
   
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}


	
    public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Dorm getDorm() {
		return dorm;
	}

	public void setDorm(Dorm dorm) {
		this.dorm = dorm;
	}



    // ...
    // getters and setters removed for brevity
    // ...
}