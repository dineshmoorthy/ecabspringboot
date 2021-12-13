package com.ecab.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEZ")
public class Employez implements Serializable {

	@Column(name = "id")
	@Id
	Integer id;

	private String empname;

	private String empid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmpName() {
		return empname;
	}

	public void setEmpName(String empName) {
		this.empname = empName;
	}

	public String getEmpId() {
		return empid;
	}

	public void setEmpId(String empId) {
		this.empid = empId;
	}

	@Override
	public String toString() {
		return "Employez [id=" + id + ", empName=" + empname + ", empId=" + empid + "]";
	}

}
