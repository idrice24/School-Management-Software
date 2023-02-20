package org.idrice24.controllers;

// import java.io.File;
// import java.io.FileOutputStream;
// import java.io.IOException;

// import org.springframework.http.MediaType;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RequestParam;
 import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadFileController {
    // @RequestMapping(value="/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    // public String fileUplaod(@RequestParam("file") MultipartFile file) throws IOException{
    //     File convertFile = new File("/var/tmp/"+file.getOriginalFilename());
    //     convertFile.createNewFile();
    //     FileOutputStream fout = new FileOutputStream(convertFile);
    //     fout.write(file.getBytes());
    //     fout.close();
    //     return "File is upload sucessfully";
    // }
}
