package com.api.engsoftwaremodulo2.controller;

import java.util.List;

import org.apache.naming.factory.SendMailFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.api.engsoftwaremodulo2.exception.ConstraintException;
import com.api.engsoftwaremodulo2.model.Contrato;
import com.api.engsoftwaremodulo2.service.implementation.EmailServiceImpl;

@Controller
@RequestMapping("/email")
public class EmailController {

	@Autowired
	private EmailServiceImpl emailServiceImpl;
	
	@Autowired
	JavaMailSender mailSender;
	
	@GetMapping("/send-email")
	public ResponseEntity<String> EnviarEmail()
	{
		List<Contrato> contratoPendente = emailServiceImpl.contratosPendentes();
		
		for(Contrato contrato : contratoPendente)
		{
			String emailInquilno = contrato.getInquilino().getEmail();
			String nomeInquilino = contrato.getInquilino().getNome();
			double valorContrato = contrato.getValor_aluguel();
			
			SimpleMailMessage message = new SimpleMailMessage();
			message.setText(nomeInquilino+" você tem um contrato pendete no valor de "+valorContrato);
			message.setTo(emailInquilno);
			message.setFrom("joana.projeto.engenharia@gmail.com");
			
			try {
				mailSender.send(message);
				return ResponseEntity.ok().body("Email Enviado com Sucesso");
			}catch (Exception e) {
				return ResponseEntity.ok().body("Erro ao enviar um email");
	        }
		}
		return null;
	}
	
}
