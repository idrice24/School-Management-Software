package com.idrice24.controllers;

/* import com.hendisantika.springbootmysqlreport.domain.studlist;
import com.hendisantika.springbootmysqlreport.repository.studlistRepository;
 */
import com.idrice24.entities.Studlist;
import com.idrice24.repositories.StudlistRepository;

import com.idrice24.entities.Worker;
import com.idrice24.repositories.WorkerRepository;
import com.idrice24.entities.Examtt;
import com.idrice24.repositories.ExamttRepository;

import com.idrice24.entities.Reportlist;
import com.idrice24.repositories.ReportlistRepository;

import com.idrice24.entities.Teachlist;
import com.idrice24.services.TeachlistService;
import com.idrice24.services.ReportlistService;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-mysql-report
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 25/02/18
 * Time: 19.17
 * To change this template use File | Settings | File Templates.
 */

@RestController
@RequestMapping("/report")
public class PdfController {

//    private Logger logger = LogManager.getLogManager(PdfController.class);

    @Autowired
    ApplicationContext context;

    @Autowired
    StudlistRepository studlistRepository;
    ReportlistRepository reportlistRepository;
    ReportlistService reportlistService;
    ExamttRepository examttRepository;
    WorkerRepository workerRepository;
    /*
    @Autowired
    TeachlistService teachlistService;
    */
    
   /*printting studeent list in pdf */

    @GetMapping(path = "/pdf/stud")
    @ResponseBody
//    public void getPdf(@PathVariable String jrxml, HttpServletResponse response) throws Exception {
    public void getPdfstud(HttpServletResponse response) throws Exception {
        //Get JRXML template from resources folder
//        Resource resource = context.getResource("classpath:reports/" + jrxml + ".jrxml");
        Resource resource = context.getResource("classpath:reports/studlist.jrxml");
        //Compile to jasperReport
        InputStream inputStream = resource.getInputStream();
        JasperReport report = JasperCompileManager.compileReport(inputStream);
        //Parameters Set
        Map<String, Object> params = new HashMap<>();

        List<Studlist> studlists = (List<Studlist>) studlistRepository.findAll();

        //Data source Set
        JRDataSource dataSource = new JRBeanCollectionDataSource(studlists);
        params.put("datasource", dataSource);

        //Make jasperPrint
        JasperPrint jasperPrint = JasperFillManager.fillReport(report, params, dataSource);
        //Media Type
        response.setContentType(MediaType.APPLICATION_PDF_VALUE);
        //Export PDF Stream
        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
    }
    
//     @PostMapping(path = "/pdf/teach" )
//     @ResponseBody
// //    public void getPdf(@PathVariable String jrxml, HttpServletResponse response) throws Exception {
//     public void getPdfteach(HttpServletResponse response) throws Exception {
//         //Get JRXML template from resources folder
// //        Resource resource = context.getResource("classpath:reports/" + jrxml + ".jrxml");
//         Resource resource = context.getResource("classpath:reports/teacherlist.jrxml");
//         //Compile to jasperReport
//         InputStream inputStream = resource.getInputStream();
//         JasperReport report = JasperCompileManager.compileReport(inputStream);
//         //Parameters Set
//         Map<String, Object> params = new HashMap<>();

//         List<Teachlist> teachlists = (List<Teachlist>) teachlistService.listAllTeachlists();

//         //Data source Set
//         JRDataSource dataSource = new JRBeanCollectionDataSource(teachlists);
//         params.put("datasource", dataSource);

//         //Make jasperPrint
//         JasperPrint jasperPrint = JasperFillManager.fillReport(report, params, dataSource);
//         //Media Type
//         response.setContentType(MediaType.APPLICATION_PDF_VALUE);
//         //Export PDF Stream
//         JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
//     }

@GetMapping(path = "/pdf/repor")
    @ResponseBody
//    public void getPdf(@PathVariable String jrxml, HttpServletResponse response) throws Exception {
    public void getPdfrepor(HttpServletResponse response) throws Exception {
        //Get JRXML template from resources folder
//        Resource resource = context.getResource("classpath:reports/" + jrxml + ".jrxml");
        Resource resource = context.getResource("classpath:reports/transcrip.jrxml");
        //Compile to jasperReport
        InputStream inputStream = resource.getInputStream();
        JasperReport report = JasperCompileManager.compileReport(inputStream);
        //Parameters Set
        Map<String, Object> params = new HashMap<>();

        List<Reportlist> reportlist = (List<Reportlist>) reportlistRepository.findAll();
        System.out.println(reportlist);
    }

        /*//Data source Set
        JRDataSource dataSource = new JRBeanCollectionDataSource(reportlist);
        params.put("datasource", dataSource);

        //Make jasperPrint
        JasperPrint jasperPrint = JasperFillManager.fillReport(report, params, dataSource);
        //Media Type
        response.setContentType(MediaType.APPLICATION_PDF_VALUE);
        //Export PDF Stream
        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
    }*/
    


    @GetMapping(path = "/pdf/examt")
    @ResponseBody
//    public void getPdf(@PathVariable String jrxml, HttpServletResponse response) throws Exception {
    public void getPdfexamt(HttpServletResponse response) throws Exception {
        //Get JRXML template from resources folder
//        Resource resource = context.getResource("classpath:reports/" + jrxml + ".jrxml");
        Resource resource = context.getResource("classpath:reports/examt.jrxml");
        //Compile to jasperReport
        InputStream inputStream = resource.getInputStream();
        JasperReport report = JasperCompileManager.compileReport(inputStream);
        //Parameters Set
        Map<String, Object> params = new HashMap<>();

        List<Examtt> examtts = (List<Examtt>) examttRepository.findAll();

        //Data source Set
        JRDataSource dataSource = new JRBeanCollectionDataSource(examtts);
        params.put("datasource", dataSource);

        //Make jasperPrint
        JasperPrint jasperPrint = JasperFillManager.fillReport(report, params, dataSource);
        //Media Type
        response.setContentType(MediaType.APPLICATION_PDF_VALUE);
        //Export PDF Stream
        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
    }


    @GetMapping(path = "/pdf/proj")
    @ResponseBody
//    public void getPdf(@PathVariable String jrxml, HttpServletResponse response) throws Exception {
    public void getPdfproj(HttpServletResponse response) throws Exception {
        //Get JRXML template from resources folder
//        Resource resource = context.getResource("classpath:reports/" + jrxml + ".jrxml");
        Resource resource = context.getResource("classpath:reports/worker.jrxml");
        //Compile to jasperReport
        InputStream inputStream = resource.getInputStream();
        JasperReport report = JasperCompileManager.compileReport(inputStream);
        //Parameters Set
        Map<String, Object> params = new HashMap<>();

        List<Worker> workers = (List<Worker>) workerRepository.findAll();

        //Data source Set
        JRDataSource dataSource = new JRBeanCollectionDataSource(workers);
        params.put("datasource", dataSource);

        //Make jasperPrint
        JasperPrint jasperPrint = JasperFillManager.fillReport(report, params, dataSource);
        //Media Type
        response.setContentType(MediaType.APPLICATION_PDF_VALUE);
        //Export PDF Stream
        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
    }



























    @GetMapping(path = "/excel")
    @ResponseBody
    public void getExcel(HttpServletResponse response) throws Exception {
        //Get JRXML template from resources folder
//        Resource resource = context.getResource("classpath:reports/" + jrxml + ".jrxml");
        InputStream jasperStream = this.getClass().getResourceAsStream("/reports/studlist.jrxml");
        JasperDesign design = JRXmlLoader.load(jasperStream);
        JasperReport report = JasperCompileManager.compileReport(design);

        Map<String, Object> params = new HashMap<>();

        List<Studlist> studlists = (List<Studlist>) studlistRepository.findAll();

        //Data source Set
        JRDataSource dataSource = new JRBeanCollectionDataSource(studlists);

        Resource resource = context.getResource("classpath:reports/studlist.xlsx");
        params.put("datasource", dataSource);

        //Make jasperPrint
        JasperPrint jasperPrint = JasperFillManager.fillReport(report, params, dataSource);
        response.setContentType("application/x-xlsx");
        response.setHeader("Content-Disposition", "inline: filename: studlist.xlsx");

        //Compile to jasperReport
        InputStream inputStream = resource.getInputStream();
        JasperReport report2 = JasperCompileManager.compileReport(inputStream);
        //Parameters Set

        final OutputStream ops = response.getOutputStream();

        //Media Type
//        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        //Export Excel Stream
        JRXlsExporter xls = new JRXlsExporter();
        xls.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        xls.setParameter(JRExporterParameter.OUTPUT_STREAM, ops);
    }

    @GetMapping(path = "/excel2")
    @ResponseBody
    private void getDownloadReportXlsx(HttpServletRequest request, HttpServletResponse response) {
        try {
            //uncomment this codes if u are want to use servlet output stream
            ServletOutputStream servletOutputStream = response.getOutputStream();

            Map<String, Object> params = new HashMap<>();

            List<Studlist> studlists = (List<Studlist>) studlistRepository.findAll();

            //Data source Set
            JRDataSource dataSource = new JRBeanCollectionDataSource(studlists);
            params.put("datasource", dataSource);

            //get real path for report
            InputStream jasperStream = this.getClass().getResourceAsStream("/reports/studlist.jrxml");
            JasperDesign design = JRXmlLoader.load(jasperStream);
            JasperReport report = JasperCompileManager.compileReport(design);

            JasperPrint jasperPrint = JasperFillManager.fillReport(report, params, dataSource);

            JRXlsxExporter xlsxExporter = new JRXlsxExporter();
            ByteArrayOutputStream os = new ByteArrayOutputStream();

            xlsxExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            xlsxExporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, "studlist.xls");

            //uncomment this codes if u are want to use servlet output stream
//        xlsxExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, servletOutputStream);

            xlsxExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, os);
//        xlsxExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
//        xlsxExporter.setExporterOutput(new SimpleOutputStreamExporterOutput("studlist.xlsx"));
//        xlsxExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(os));
            xlsxExporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.TRUE);
            xlsxExporter.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
            xlsxExporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
            xlsxExporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
//        xlsxExporter.exportReport();


            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setHeader("Content-Disposition", "attachment; filename=studlist.xls");

            //uncomment this codes if u are want to use servlet output stream
//        servletOutputStream.write(os.toByteArray());

            response.getOutputStream().write(os.toByteArray());
            response.getOutputStream().flush();
            response.getOutputStream().close();
            response.flushBuffer();
        } catch (JRException ex) {
            System.out.println("Error : " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("IOException " + ex.getMessage());
        }
    }

    @GetMapping(path = "/excel3")
    @ResponseBody
    private void getDownloadReportXls(HttpServletResponse response) {
        try {
            //get real path for report
            InputStream jasperStream = this.getClass().getResourceAsStream("/reports/studlist.jrxml");
            JasperDesign design = JRXmlLoader.load(jasperStream);
            JasperReport report = JasperCompileManager.compileReport(design);

            Map<String, Object> params = new HashMap<>();
            List<Studlist> studlists = (List<Studlist>) studlistRepository.findAll();

            //Data source Set
            JRDataSource dataSource = new JRBeanCollectionDataSource(studlists);
            params.put("datasource", dataSource);

            JasperPrint jasperPrint = JasperFillManager.fillReport(report, params, dataSource);
            response.setContentType("application/x-xls");
            response.setHeader("Content-Disposition", "attachment; filename=studlist.xls");

            final OutputStream ops = response.getOutputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

            JRXlsExporter xlsExporter = new JRXlsExporter();
            xlsExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
//            xlsExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, ops);
            xlsExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, byteArrayOutputStream);
//            xlsExporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, ops);
            xlsExporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.TRUE);
            xlsExporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
            xlsExporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
            xlsExporter.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);

            xlsExporter.exportReport();
            ops.write(byteArrayOutputStream.toByteArray());
            ops.flush();
            ops.close();

        } catch (JRException ex) {
            System.out.println("Error : " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("IOException " + ex.getMessage());
        }
    }
}
