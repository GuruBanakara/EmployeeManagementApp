package com.gb.hrManagementApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gb.hrManagementApp.bean.Employee;
import com.gb.hrManagementApp.service.EmailService;
import com.gb.hrManagementApp.service.EmployeeService;

@Component
@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@Autowired
	private EmailService emailService;

	@RequestMapping(value = "/addEmp", method = RequestMethod.GET)
	public ModelAndView showAddEmployeeForm(@ModelAttribute Employee employee) {

		return new ModelAndView("addEmployeeForm", "employee", employee);
	}

	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute Employee employee) {

		service.saveEmployee(employee);
		emailService.sendConfirmationMail(employee);
		return "redirect:/viewEmp";

	}

	@RequestMapping(value = "/viewEmp", method = RequestMethod.GET)
	public ModelAndView viewEmployeeList() {

		List<Employee> list = service.getEmployeeList();
		return new ModelAndView("viewEmpForm", "list", list);
		
	}
	

	@RequestMapping(value = "/editEmp", method = RequestMethod.GET)
	public ModelAndView showEditEmpForm(@RequestParam int employeeId) {

		Employee employee = service.getEmployeeById(employeeId);
		return new ModelAndView("editEmpForm", "employee", employee);

	}

	@RequestMapping(value = "/updateEmployee", method = RequestMethod.POST)
	public String updateEmployee(@ModelAttribute Employee employee) {

		service.updateEmployee(employee);
		return "redirect:/viewEmp";

	}

	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.POST)
	public String deleteEmployee(@RequestParam int employeeId) {

		service.deleteEmployee(employeeId);
		return "redirect:/viewEmp";

	}
}
