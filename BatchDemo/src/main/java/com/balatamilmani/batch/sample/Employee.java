package com.balatamilmani.batch.sample;

import java.util.Date;

public class Employee {

	long empNo;
	String eName;
	String job;
	long managerNo;
	Date hireDate;
	Double sal ;
	
	public long getEmpNo() {
		return empNo;
	}
	public void setEmpNo(long empNo) {
		this.empNo = empNo;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public long getManagerNo() {
		return managerNo;
	}
	public void setManagerNo(long managerNo) {
		this.managerNo = managerNo;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public Double getSal() {
		return sal;
	}
	public void setSal(Double sal) {
		this.sal = sal;
	}

}
