package com.example.demo.controller;


import com.example.demo.fastDFS.FastDFSCLient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

@Controller
public class UploadController {
    @RequestMapping("/upload")
    public String index(){
        return "upload";
    }
    @RequestMapping("/return")
    public String return1(){
        return "return";
    }
    public  static String filename =null;
    public  static String suffix =null;
    private  static  void executeUpload(String uploadDir, MultipartFile file) throws Exception
    {   if(file!=null) {
        //文件后缀名
        suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        //上传文件名
        filename = UUID.randomUUID() + suffix;
        //服务器端保存的文件对象
        File serverFile = new File(uploadDir + filename);
        //将上传的文件写入到服务器端文件内
        file.transferTo(serverFile);
    }
    }

    /**
     * 上传文件方法
     * @param file 前台上传的文件对象
     * @return
     */
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public  String upload(HttpServletRequest request, MultipartFile file)
    {
        try {
            //目录地址
            String uploadDir = request.getSession().getServletContext().getRealPath("/") +"upload/";
            //如果目录不存在，自动创建文件夹
            File dir = new File(uploadDir);
            if(!dir.exists())
            {
                dir.mkdir();
            }
            //调用上传方法
            executeUpload(uploadDir,file);
            String filename2 = request.getSession().getServletContext().getRealPath("/")+"upload/"+filename+".";
            FastDFSCLient fastDFSCLient = new FastDFSCLient();
            String httpweb  = fastDFSCLient.upload(filename2,suffix);
            System.out.println(httpweb);
            request.getSession().setAttribute("http",httpweb);
        }catch (Exception e)
        {
            //打印错误堆栈信息
            e.printStackTrace();
            return "上传失败";
        }

        return "return";
    }

    /**
     * 上传多个文件
     * @param request 请求对象
     * @param file 上传文件集合
     * @return
     */
    @RequestMapping(value = "/uploads",method = RequestMethod.POST)
    public  String uploads(HttpServletRequest request, MultipartFile[] file)
    {
        try {
            //上传目录地址
            String uploadDir = request.getSession().getServletContext().getRealPath("/") +"upload/";
            //如果目录不存在，自动创建文件夹
            File dir = new File(uploadDir);
            if(!dir.exists())
            {
                dir.mkdir();
            }
            //遍历文件数组执行上传
            for (int i =0;i<file.length;i++) {
                if(file[i] != null) {
                    //调用上传方法
                    executeUpload(uploadDir, file[i]);
                    String filename2 = request.getSession().getServletContext().getRealPath("/")+"upload/"+filename;
                    FastDFSCLient fastDFSCLient = new FastDFSCLient();
                    String httpweb  = fastDFSCLient.upload(filename2,suffix);
                    System.out.println(httpweb);
                    request.getSession().setAttribute("http"+i,httpweb);
                }
            }
        }catch (Exception e)
        {
            //打印错误堆栈信息
            e.printStackTrace();
            return "上传失败";
        }
        return "return";
    }


}
