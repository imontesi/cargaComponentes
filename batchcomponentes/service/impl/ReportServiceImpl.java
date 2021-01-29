package es.lacaixa.inu.batch.batchcomponentes.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.lacaixa.inu.batch.batchcomponentes.bo.Proceso;
import es.lacaixa.inu.batch.batchcomponentes.service.IReportService;

@Service("reportService")
public class ReportServiceImpl implements IReportService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReportServiceImpl.class);
	
	@Autowired IReportService emailService;

	@Override
	public void report(Proceso proceso) {
		LOGGER.info("Realizando reporting del proceso: {}", proceso);
		emailService.report(proceso);
	}

}
