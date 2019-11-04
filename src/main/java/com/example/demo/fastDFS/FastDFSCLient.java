package com.example.demo.fastDFS;

import com.example.demo.Config.WebSecurityConfig;
import org.csource.fastdfs.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.attribute.FileStoreAttributeView;

public class FastDFSCLient {

    public static String upload(String filename,String suffix) throws FileNotFoundException, IOException, Exception {
        //加载festDFS配置文件
        ClientGlobal.init("C:\\Users\\XH\\Workspaces\\MyEclipse 2017 CI\\fastDFSdemo\\src\\main\\resources\\fdfs_client.conf");
        //2构建一个管理者客户端
        TrackerClient client = new TrackerClient();
        //连接管理者服务端
        TrackerServer trackerServer = client.getConnection();
        //声明存储服务端
        StorageServer storageServer = null;
        //获取存储服务器的客户端对象
        StorageClient storageClient = new StorageClient(trackerServer, storageServer);
        //上传文件
        String[] strings  = storageClient.upload_file(filename, suffix, null);
        //显示上传结果 file_id
        StringBuilder sb = new StringBuilder("http://47.94.83.112/");
        sb.append(strings[0]).append("/").append(strings[1]);
        return sb.toString();
    }
    public  static int delete(String groupNname,String fileName) throws Exception {
        ClientGlobal.init("C:\\Users\\XH\\Workspaces\\MyEclipse 2017 CI\\fastDFSdemo\\src\\main\\resources\\fdfs_client.conf");
        TrackerClient client = new TrackerClient();
        TrackerServer trackerServer = client.getConnection();
        StorageServer storageServer = null;
        StorageClient storageClient =  new StorageClient(trackerServer,storageServer);
        int i = storageClient.delete_file(groupNname,fileName);
        Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);
        logger.info(i==0 ? "删除成功" : "删除失败:"+i);
        return i;
    }
}
