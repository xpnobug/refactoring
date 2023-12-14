package com.kdg.refactoring.kdgservice.controller.pic;

import com.kdg.refactoring.kdgcommon.baseresult.JsonObjectResult;
import com.kdg.refactoring.kdgservice.picgo.minio.util.MinioUtils;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author 86136
 */
@CrossOrigin
@RestController
@RequestMapping("/api")
public class MinioFileUploadController {

    @Autowired
    private MinioUtils minioUtils;

    /**
     * @param file     文件
     * @param fileName 文件名称
     * @Description 上传文件
     */
    @PostMapping("/upload")
    public JsonObjectResult uploadFile(@RequestParam("file") MultipartFile file, String fileName) {
        String originalFilename = file.getOriginalFilename();
        minioUtils.upload(file, originalFilename);
        HashMap map = new HashMap();
        map.put("fileUrl", minioUtils.getFileUrl(originalFilename));
        map.put("fileName", originalFilename);
        return JsonObjectResult.success(map);

    }

    /**
     * @param fileName 文件名称
     * @Description dowload文件
     */
    @GetMapping("/dowload")
    public ResponseEntity dowloadFile(@RequestParam("fileName") String fileName) {
        return minioUtils.download(fileName);
    }

    /**
     * @param fileName 文件名称
     * @Description 得到文件url
     */
    @GetMapping("/getUrl")
    public JsonObjectResult getFileUrl(@RequestParam("fileName") String fileName) {
        HashMap map = new HashMap();
        map.put("fileUrl", minioUtils.getFileUrl(fileName));
        return JsonObjectResult.success(map);
    }
}
