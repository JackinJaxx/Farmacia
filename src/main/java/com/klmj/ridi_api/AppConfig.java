package com.klmj.ridi_api;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public JasperReport jasperReport() throws JRException {
        return JasperCompileManager.compileReport(getClass().getClassLoader().getResourceAsStream("jasper/ReporteRIDI.jasper"));
    }
}
