package com.cys.blog.controller;

import com.cys.blog.exception.customize.CustomizeErrorCode;
import com.cys.blog.exception.customize.CustomizeException;
import com.cys.blog.util.UCloudProvider;
import com.cys.blog.vo.FileVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author sam
 * @apiNote
 * @since 2019-09-18-20:27
 **/
@Controller
public class FileController {
    @Autowired
    private UCloudProvider uCloudProvider;

    @RequestMapping("/file/upload")
    @ResponseBody
    public FileVO upload(HttpServletRequest request) {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartRequest.getFile("editormd-image-file");
        try {
            String fileName = uCloudProvider.upload(file.getInputStream(), file.getContentType(), file.getOriginalFilename());
            System.out.println(fileName);
            FileVO fileVO = new FileVO();
            fileVO.setSuccess(1);
            fileVO.setUrl(fileName);
            return fileVO;
        } catch (IOException e) {
            throw new CustomizeException(CustomizeErrorCode.FILE_UPLOAD_FAIL);
        }
    }
}
