package net.shahram.practice.upload.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;

import java.io.File;

@Controller
@RequestMapping("/uploadFile.do")
@Slf4j
public class FileUploadController {

    private String saveDirectory = "upload/";

    @RequestMapping(method = RequestMethod.POST)
    public String handleFileUpload(HttpServletRequest request,
                    @RequestParam CommonsMultipartFile[] fileUpload) throws Exception {

        log.info("description: [{}]", request.getParameter("description"));

        if (fileUpload != null && fileUpload.length > 0) {
            for (CommonsMultipartFile aFile : fileUpload) {

                log.info("Saving file: [{}]", aFile.getOriginalFilename());

                if (!aFile.getOriginalFilename().equals("")) {
                    aFile.transferTo(new File(saveDirectory + aFile.getOriginalFilename()));
                }
            }
        }

        // returns to the view "Result"
        return "Result";
    }
}
