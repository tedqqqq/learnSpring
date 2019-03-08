package com.springMvcController;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/fileupload")
public class FileUploadController {

  @RequestMapping(method=RequestMethod.GET)
  public String uploadForm() {
    return "uploadForm";
  }
  
  @RequestMapping(method=RequestMethod.POST)
  public String processUpload(@RequestPart("file") MultipartFile file) throws IllegalStateException, IOException {
  
    System.out.println(file.getSize());
    File file1=new File("C:\\Users\\invengo\\Desktop\\v2\\1.txt");
    file.transferTo(file1);
   System.out.println("---->  " + file.getName() + "  ::  "  + file.getSize());
    System.out.println("文件内容"+file);
    return "redirect:/";
  }
  
}
