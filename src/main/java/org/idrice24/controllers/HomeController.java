package org.idrice24.controllers;

import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileOutputStream;
import java.io.IOException;

//import org.springframework.context.annotation.Bean;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.http.HttpHeaders;

@Controller
@RequestMapping("/")
public class HomeController{

	public HomeController(){

    }

    @GetMapping(value="home/app")
    public String homePage(Model model){
        
        return "home";
    }
    
    @GetMapping(value="index")
    public String index(Model model){
        model.addAttribute("index", model);
        return "index";
    }

    @GetMapping(value="media")
    public String medaiPage(Model model){
        model.addAttribute("media", model);
        return "media";
    }

    /*@GetMapping(value="upload/file", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadFiles(@RequestParam("file") MultipartFile file) throws IOException{
        File convertFile = new File("/var/tmp/"+file.getOriginalFilename());
        convertFile.createNewFile();
        FileOutputStream fout = new FileOutputStream(convertFile);
        fout.write(file.getBytes());
        fout.close();

        return "media";
    }*/

    @RequestMapping(value ="upload/file", method = RequestMethod.POST)
    public String submit(@RequestParam("file") MultipartFile file, ModelMap modelMap){
        modelMap.addAttribute("file", file);
        return "media";
    }

   /*  @Bean(name = "multipartResolver") 
    public CommonsMultipartResolver multipartResolver(){
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(100000);
        return multipartResolver;
    }*/

    @GetMapping(value="download/file")
        public ResponseEntity<Object> downloadFile() throws IOException {
            String filename = "/var/tmp/mysql.png";
            File file = new File(filename);
            InputStreamResource resource = new InputStreamResource(new 
            FileInputStream(file));
            HttpHeaders headers = new HttpHeaders(null);
            headers.add("Content-Disposition", String.format("attachment",
            filename="%s\"", file.getName()));
            headers.add("Cache-Control", "no-cache, no-store, mustrevalidate");
            headers.add("Pragma", "no-cache");
            headers.add("Expires", "0");
            ResponseEntity<Object> responseEntity = 
            ResponseEntity.ok().headers(headers).contentLength(file.length()).contentType(MediaType.parseMediaType("application/txt")).body(resource);
            return responseEntity;
        }
}