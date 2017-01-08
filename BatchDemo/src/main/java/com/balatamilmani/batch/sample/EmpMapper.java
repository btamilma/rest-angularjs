package com.balatamilmani.batch.sample;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmpMapper implements RowMapper<Employee>{

	public Employee mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		Employee employee = new Employee();
		employee.setEmpNo(rs.getLong("empno"));
		employee.seteName(rs.getString("ename"));
		employee.setJob(rs.getString("job"));
		return employee;
	}

}
