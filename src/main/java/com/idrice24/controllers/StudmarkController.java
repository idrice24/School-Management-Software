package com.idrice24.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//TODO@IDirci why wrong packahe name here??
//package com.ensat.controllers;

/* import com.ensat.entities.Product; */

import com.idrice24.entities.Studmark;
import com.idrice24.services.CourseService;
import com.idrice24.services.SpecialityService;
import com.idrice24.services.StudlistService;
import com.idrice24.services.StudmarkService;

/**
 * Product controller.
 */
@Controller
public class StudmarkController
{

    /* private ProductService productService; */
    private StudmarkService studmarkService;

    private SpecialityService specialityService;

    private StudlistService studlistService;

    private CourseService courseService;

    @Autowired
    public void setCourseService(CourseService courseService)
    {
        this.courseService = courseService;
    }

    @Autowired
    public void setSpecialityService(SpecialityService specialityService)
    {
        this.specialityService = specialityService;
    }

    /**
     * List all products.x
     *
     * @param model
     * @return
     */
    /*
     * @RequestMapping(value = "/products", method = RequestMethod.GET) public
     * String list(Model model) { model.addAttribute("products",
     * productService.listAllProducts());
     * System.out.println("Returning rpoducts:"); return "products"; }
     */

    @RequestMapping(value = "/studmarks", method = RequestMethod.GET)
    public String list(Model model)
    {
        model.addAttribute("studmarks", studmarkService.listAllStudmarks());
        System.out.println("Returning studmark:");
        return "studmarks";
    }

    /*
     * /** View a specific product by its id.
     *
     * @param id
     * 
     * @param model
     * 
     * @return
     */
    @RequestMapping("studmark/{id}")
    public String showStudmark(@PathVariable Integer id, Model model)
    {
        model.addAttribute("studmark", studmarkService.getStudmarkById(id));
        return "studmarkshow";
    }

    @RequestMapping("studmark/edit/{id}")
    public String edit(@PathVariable Integer id, Model model)
    {
        model.addAttribute("studmark", studmarkService.getStudmarkById(id));

        /* 'les autres */
        model.addAttribute("specialitys", specialityService.listAllSpecialitys());
        model.addAttribute("courses", courseService.listAllCourses());
        model.addAttribute("studlists", studlistService.listAllStudlists());
        return "update-studmarks";
    }

    /**
     * New product.
     *
     * @param model
     * @return
     */
    @RequestMapping("studmark/add")
    public String newStudmark(Model model)
    {
        model.addAttribute("studmark", new Studmark());
        model.addAttribute("specialitys", specialityService.listAllSpecialitys());
        model.addAttribute("courses", courseService.listAllCourses());
        model.addAttribute("studlists", studlistService.listAllStudlists());
        return "add-studmarks";
    }

    /**
     * Save product to database.
     *
     * @param product
     * @return
     */
    @RequestMapping(value = "studmark", method = RequestMethod.POST)
    public String saveStudmark(Studmark studmark)
    {
        studmarkService.saveStudmark(studmark);
        return "redirect:/studmarks/" + studmark.getId();
    }

    /**
     * Delete product by its id.
     *
     * @param id
     * @return
     */
    @RequestMapping("studmark/delete/{id}")
    public String delete(@PathVariable Integer id)
    {
        studmarkService.deleteStudmark(id);
        return "redirect:/studmarks";
    }

}
