package com.gb.hrManagementApp.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.gb.hrManagementApp.bean.Employee;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private Configuration configuration;

	public void sendConfirmationMail(Employee employee) {

		MimeMessage mimeMessage = javaMailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
		try {
			helper.setTo(employee.getMailId());
			helper.setSubject("Congratulations! have a nice journey with AG Technologies");
			Map<String, String> model = new HashMap<String, String>();
			model.put("employeeName", employee.getEmployeeName());
			model.put("designation", employee.getDesignation());
			Template template = configuration.getTemplate("joiningConfirmation.ftl");
			String text = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);

			helper.setText(text, true);

			javaMailSender.send(mimeMessage);
		} catch (MessagingException | IOException | TemplateException e) {
			e.printStackTrace();
		}

	}
}
