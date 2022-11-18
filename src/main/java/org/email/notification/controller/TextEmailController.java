package org.email.notification.controller;
/*
 * @Author Debu Paul
 */

import org.email.notification.model.EmailTemplate;
import org.email.notification.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

import javax.mail.MessagingException;
import java.io.IOException;

@RestController
@RequestMapping("/v1/notification")
@Slf4j

public class TextEmailController {

	@Autowired
	private EmailService emailService;

	@PostMapping(value="/textemail",consumes = "application/json", produces = "application/json")
	public String sendEmail(@RequestBody EmailTemplate emailTemplate) throws Exception {

			log.info("Sending Simple Text Email....");
			emailService.sendTextEmail(emailTemplate);
			return "Email Sent!";

	}
	
	
	@PostMapping(value="/attachemail",consumes = "multipart/form-data")
	public String sendEmailWithAttachment(@RequestPart(value = "file") MultipartFile file) throws MessagingException, IOException {

			log.info("Sending Attachment Email....");
			emailService.sendEmailWithAttachment(file);
			return "Email Sent!";

	}
}
