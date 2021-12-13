package com.ecab.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@Entity
@Table(name = "EMPLOYEZ")
//@Component
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = Employez.class)
public class Employez implements Serializable {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@Id
	private Long id;

	@Column(name = "empName")
	private String empName;

	@Column(name = "empId")
	private String empId;

	 
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", empId=" + empId + "]";
	}

}
