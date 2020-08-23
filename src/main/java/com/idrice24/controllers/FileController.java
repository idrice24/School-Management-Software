package com.idrice24.controllers;

import com.idrice24.entities.DBFile;
import com.idrice24.entities.UploadFileResponse;
import com.idrice24.services.DBFileStorageService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.idrice24.repositories.DBFileRepository;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import javax.servlet.http.HttpServletRequest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/uploads/")
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);
    
    private DBFileRepository dbfilerepository;


    @Autowired
    private DBFileStorageService dbFileStorageService;

    @Autowired
    private FileController(DBFileRepository dbfilerepository){
        this.dbfilerepository = dbfilerepository;
    }
	@GetMapping("file")
	public String showSignUpForm(DBFile DBFile) {
		return "upload";
	}

	// @GetMapping("list")
	// public String showUpdateForm(Model model) {
	// 	model.addAttribute("dbfiles", DBFileRepository.findAll());
	// 	return "upload";
    // }
    
    @PostMapping("uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
        DBFile dbFile = dbFileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(dbFile.getId())
                .toUriString();

        return new UploadFileResponse(dbFile.getFileName(), fileDownloadUri,
                file.getContentType(), file.getSize());
    }
    // @RequestMapping(value = "uploadFiles", method = RequestMethod.POST)
    // public String handleFileUpload(HttpServletRequest request, @RequestParam CommonsMultipartFile[] fileUpload) throws Exception {
    //     if (fileUpload != null && fileUpload.length > 0 ){
    //         for(CommonsMultipartFile aFile : fileUpload){
    //             System.out.println("Saving file : "+ aFile.getOriginalFilename());

    //             DBFile uploadFile = new DBFile();
    //             uploadFile.setFileName(aFile.getOriginalFilename());
    //             uploadFile.setData(aFile.getBytes());
    //             dbFileStorageService.storeFile(uploadFile);
    //         }
    //     }
    //     return "success";
    // }

    @PostMapping("/uploadMultipleFiles")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
    }

    @GetMapping("/downloadFile/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) {
        // Load file from database
        DBFile dbFile = dbFileStorageService.getFile(fileId);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFile.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getFileName() + "\"")
                .body(new ByteArrayResource(dbFile.getData()));
    }

}