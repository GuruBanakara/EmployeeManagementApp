package com.gb.hrManagementApp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gb.hrManagementApp.bean.Employee;

@Repository
public class EmployeeDao {

	@Autowired
	private SessionFactory factory;

	public void saveEmployee(Employee employee) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(employee);
		transaction.commit();
		session.close();
	}

	public void deleteEmployee(int employeeId) {
		factory.getCurrentSession().createQuery("delete from Employee where employeeId= " + employeeId).executeUpdate();
	}

	public void updateEmployee(Employee employee) {
		factory.getCurrentSession()
				.createQuery("update Employee set employeeName='" + employee.getEmployeeName() + "' , mailId='"
						+ employee.getMailId() + "' , designation='" + employee.getDesignation() + "' ,salary="
						+ employee.getSalary() + " where employeeId= " + employee.getEmployeeId())
				.executeUpdate();
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Employee> getEmployeeList() {

		return (List<Employee>) factory.getCurrentSession().createCriteria(Employee.class).list();

	}

	public Employee getEmployeeById(int employeeId) {
		return factory.getCurrentSession().get(Employee.class, employeeId);

	}
}
