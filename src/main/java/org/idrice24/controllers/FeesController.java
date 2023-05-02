package org.idrice24.controllers;

import java.util.Date;

import javax.validation.Valid;

import org.idrice24.entities.Fees;
import org.idrice24.entities.Student;
import org.idrice24.services.ClasseService;
import org.idrice24.services.FeesService;
import org.idrice24.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fees/")
public class FeesController {
    private FeesService feesService;
    private ClasseService classeService;
    private StudentService studentService;

    @Autowired
    public void setFessController(FeesService feesService, ClasseService classeService, StudentService studentService){
        this.feesService = feesService;
        this.classeService = classeService;
        this.studentService = studentService;
    }

    @GetMapping("show/form")
    public String showFeeForm(Model model, Fees fees){
        model.addAttribute("fees", fees);
        model.addAttribute("classes", classeService.getAllClasse());
        model.addAttribute("students", studentService.listAllStudents());
        return "add-fees";
    }

    @GetMapping("list/fees")
    public String listAllFees(Model model){
        //long t = feesService.count();
        model.addAttribute("feess", feesService.getAllFees());
        return "fees";
    }

    @PostMapping("pay/fees")
    public String payFees(@Valid Fees fees, Model model, BindingResult result, Student student){
        model.addAttribute("fees", new Object());
        
        if(result.hasErrors()){
            return "add-fees";
        }
        fees.setTotal(70000);
        fees.setYearp(Date());
        long r = fees.getTotal() - fees.getAmount();
        if( r <= 0){
            r = (3/100)*fees.getAmount();
        }
        fees.setRest(r);
        Date date = new Date();
        fees.setPmdate(date);
        
        feesService.save(fees);
        model.addAttribute("feess", feesService.getAllFees());
        return "redirect:/fees/list/fees";
    }

    private Date Date() {
        Date date = new Date();
        return date;
    }

    @GetMapping("edit/fees/{id}")
    public String editFees(@PathVariable("id") long id, Model model, Fees fees, BindingResult result, Student student){
        fees = feesService.findById(id);
        
        model.addAttribute("fees", fees);
        model.addAttribute("classe", classeService.getAllClasse());
        model.addAttribute("student", student);
        return "update-fees";
    }

    @GetMapping("view/{sui}/{id}")
    public String viewFees(@PathVariable("id") long id, Model model, @PathVariable("sui") String sui){
        Fees fee = feesService.findById(id);
        //model.addAttribute("students", studentService.listAllStudents());
        //Student student = ((Student) studentService.listAllStudents());
        //String student = new Student().getSui();
        model.addAttribute("fees", fee);
       // model.addAttribute("students", studentService.findBySui(fee.getSui()));
        model.addAttribute("students", studentService.listAllStudents());
        model.addAttribute("classe", classeService.getAllClasse());
        return "viewfees";
    }

    @PostMapping("update/fees/{id}")
    public String updateFees(@PathVariable("id") long id, Model model, Fees fees, BindingResult result){
        if(result.hasErrors()){
            fees.setId(id);
            return "update-fees";
        }
        feesService.save(fees);
        model.addAttribute("fees", feesService.getAllFees());
        model.addAttribute("classe", classeService.getAllClasse());
        return "fees";
    }

    @GetMapping("delete/fees/{id}")
    public String deleteFees(@PathVariable("id") long id, Model model){
        Fees fees = feesService.findById(id);
        feesService.delete(fees);
        model.addAttribute("feess", feesService.getAllFees());
        return "fees";
    }
    
}
