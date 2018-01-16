package com.boot.controller;

import java.io.BufferedOutputStream;  
import java.io.File;  
import java.io.FileOutputStream;  
   
import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.bind.annotation.RequestParam;  
import org.springframework.web.bind.annotation.ResponseBody;  
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;  
   
@Controller  
public class FileUploadController {  
   
    @RequestMapping(value="/toUpload", method=RequestMethod.GET)  
    public ModelAndView provideUploadInfo() {  
        return new ModelAndView("index");
    }
   
    @RequestMapping(value="/upload", method=RequestMethod.POST)
    @ResponseBody
    public String handleFileUpload(@RequestParam("name") String name,  
            @RequestParam("file") MultipartFile file){  
        if (!file.isEmpty()) {
            try {  
                byte[] bytes = file.getBytes();  
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(name + "-uploaded")));  
                stream.write(bytes);  
                stream.close();  
                return "You successfully uploaded " + name + " into " + name + "-uploaded !";  
            } catch (Exception e) {  
                return "You failed to upload " + name + " => " + e.getMessage();  
            } 
        } else {  
            return "You failed to upload " + name + " because the file was empty.";  
        }  
    }  
   
}  
