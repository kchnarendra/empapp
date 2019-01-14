package com.prime.employee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="employee")
public class EmployeeDTO {

	@Id
	@Column(name="eid")
	@NotNull(message="* Eid sholuld not be Null")
	private Integer eid;
	
	@Column(name="name")
	@NotEmpty(message="* Name is mandatory")
	private String name;
	
	@Column(name="salary")
	@NotNull(message="* Salary should not be Null")
	private Double salary;
	
	

	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
}
