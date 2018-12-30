package com.aa.aainventorysystembe.controllers;

import com.aa.aainventorysystembe.models.Response;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class GlobalController {
    private static String ROOT_DIR = new File("").getAbsolutePath() + "/images/";

    public <T> Response toResponse(T value){
        return Response.builder()
                .code("200")
                .message("Success")
                .data(value)
                .build();
    }

    public String saveUploadedFiles(MultipartFile file, String dir) throws IOException {
        String UPLOAD_DIR = ROOT_DIR + dir;

        File uploadDir = new File(UPLOAD_DIR);
        uploadDir.mkdirs();

        String uploadFilePath = UPLOAD_DIR + "/" + file.getOriginalFilename();
        byte[] bytes = file.getBytes();
        Path path = Paths.get(uploadFilePath);
        Files.write(path, bytes);

        return file.getOriginalFilename();
    }

}
