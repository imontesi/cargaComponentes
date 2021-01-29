package es.lacaixa.inu.batch.batchcomponentes.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import es.lacaixa.inu.batch.batchcomponentes.bo.Proceso;
import es.lacaixa.inu.batch.batchcomponentes.service.IReportService;

@Service("emailService")
public class EmailServiceImpl implements IReportService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmailServiceImpl.class);

	@Autowired
	private JavaMailSender emailSender;

	@Autowired
	private VelocityEngine velocityEngine;
	
	@Value("${mail.from}")
	private String from;
	
	@Value("${mail.to}")
	private String[] to;
	
	@Value("${mail.cc}")
	private String[] cc;
	
	@Value("${mail.subject}")
	private String subject;

	@Override
	public void report(Proceso proceso) {
		LOGGER.info("Enviando email");

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("ficheros", proceso.getFicheros());
		model.put("detalles", proceso.getLineasKo());
		String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "email.vm", "UTF-8", model);

		LOGGER.debug(text);

		MimeMessage mimeMessage = emailSender.createMimeMessage();

		try{
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setFrom(from);
			mimeMessageHelper.setTo(to);
			if(cc != null && cc.length>0){
				mimeMessageHelper.setCc(cc);
			}
			mimeMessageHelper.setSubject(subject);
			mimeMessageHelper.setText(text, true);

			emailSender.send(mimeMessage);
		}
		catch (Exception e) {
			LOGGER.error("Error enviando mail", e);
		}

	}

}
