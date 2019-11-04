package com.example.demo.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.demo.fastDFS.FastDFSCLient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class deleteController {
    @RequestMapping("/delete")
    public String delete(String fileName) throws Exception {
        System.out.println(fileName);
        String groupName =fileName.substring(20,26);
        String FileName = fileName.substring(27);
        FastDFSCLient fastDFSCLient = new FastDFSCLient();
        int i  = fastDFSCLient.delete(groupName,FileName);
        return "return";
    }
}
