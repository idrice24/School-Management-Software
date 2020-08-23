package com.idrice24.services;

import com.idrice24.entities.Reportlist;
import com.idrice24.repositories.ReportlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Product service implement.
 */
@Service
public class ReportlistServiceImp implements ReportlistService {

    private ReportlistRepository reportlistRepository;

    @Autowired
    public void setReportlistRepository(ReportlistRepository reportlistRepository) {
        this.reportlistRepository = reportlistRepository;
    }

     @Override
    public Iterable<Reportlist> listAllReportlists() {
        return reportlistRepository.findAll();
    }
	

}
