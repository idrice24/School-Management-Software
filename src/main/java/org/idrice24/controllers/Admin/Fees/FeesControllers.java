package org.idrice24.controllers.Admin.Fees;

import java.util.Date;

import javax.validation.Valid;

import org.idrice24.entities.Admin.Fee.Payement;
import org.idrice24.entities.Admin.Fee.StudentBill;
import org.idrice24.entities.Students.Student;
import org.idrice24.services.Admin.ClasseService;
import org.idrice24.services.Admin.Fees.StudentBillServiceImpl;
import org.idrice24.services.Students.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fees/")
public class FeesControllers {
    private StudentBillServiceImpl paymentService;
    private ClasseService classeService;
    private StudentService studentService;

    @Autowired
    public void setFessController(StudentBillServiceImpl paymentService, ClasseService classeService, StudentService studentService){
        this.paymentService = paymentService;
        this.classeService = classeService;
        this.studentService = studentService;
    }

    @GetMapping("show/form")
    public String showFeeForm(Model model, StudentBill studentBill){
        model.addAttribute("fees", studentBill);
        model.addAttribute("classes", classeService.getAllClasse());
        model.addAttribute("students", studentService.listAllStudents());
        return "add-fees";
    }

    @GetMapping("list/fees")
    public String listAllFees(Model model, Student student, StudentBill studentBill){
        //long t = feesService.count();
        model.addAttribute("feess", paymentService.getAllPayement());
        return "fees";
    }

    @PostMapping("pay/fees")
    public String payFees(@Valid Payement payement, StudentBill studentBill, Model model, BindingResult result, Student student){
        model.addAttribute("payment", new Object());
        
        if(result.hasErrors()){
            return "add-payment";
        }
        Date date = new Date();
        payement.setPaymentdate(date);
        payement.setPayment(studentBill.getAmount());
        payement.setPaymentdate(date);

        long paid = payement.getPayment();

        paymentService.save(payement);

        return "redirect:/fees/list/fees";
    }


}
