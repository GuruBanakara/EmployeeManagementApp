package com.gb.hrManagementApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gb.hrManagementApp.bean.Employee;
import com.gb.hrManagementApp.dao.EmployeeDao;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@javax.transaction.Transactional
	public void deleteEmployee(int employeeId) {
		employeeDao.deleteEmployee(employeeId);
	}

	@javax.transaction.Transactional
	public void updateEmployee(Employee employee) {
		employeeDao.updateEmployee(employee);
	}

	public List<Employee> getEmployeeList() {
		return employeeDao.getEmployeeList();

	}

	public Employee getEmployeeById(int employeeId) {
		return employeeDao.getEmployeeById(employeeId);

	}

	public void saveEmployee(Employee employee) {
		employeeDao.saveEmployee(employee);
	}

}
