package com.lzhch.fileupload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @packageName： com.lzhch.fileupload
 * @className: FileUploadApplication
 * @description: TODO
 * @version: v1.0
 * @author: liuzhichao
 * @date: 2020-07-20 10:07
 */
@SpringBootApplication
@ComponentScan("com.lzhch.*")
public class FileUploadApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileUploadApplication.class, args);
        System.out.println("------start------");
    }

}
