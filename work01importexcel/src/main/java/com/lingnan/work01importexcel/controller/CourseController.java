package com.lingnan.work01importexcel.controller;

import com.lingnan.work01importexcel.entity.Course;
import com.lingnan.work01importexcel.excelUtils.ExcelForList;
import com.lingnan.work01importexcel.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author whongf
 * @create 2020-05-26-10:19
 */
@RestController
@RequestMapping("/excel")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @RequestMapping(value="/import",method = RequestMethod.POST,produces = { "application/json;charset=UTF-8"})
    public  String imporCourse(@RequestParam MultipartFile excelFile, HttpSession httpSession) throws IOException {
        InputStream in =excelFile.getInputStream();
        String fileOriginalName=excelFile.getOriginalFilename();
        String fileName=excelFile.getName();
        String excelType=fileOriginalName.substring(fileOriginalName.indexOf(".")+1);

        //记录插入多条记录到了数据库；
        int importSuccessNum=0;
        int importAllNum=0;
        boolean importSuccess;

        System.out.println("in:::"+in);
        System.out.println("fileOriginalName:::"+fileOriginalName);
        System.out.println("fileName:::"+fileName);
        System.out.println("excelType:::"+excelType);
        List<Object> forlist= ExcelForList.ExcelForList(excelFile,Course.class,true,excelType);
        for (Object object: forlist) {
            Course course=(Course) object;
            importAllNum++;
            importSuccess=courseService.importExcel(course);
            if(importSuccess)
                importSuccessNum++;

        }
        httpSession.setAttribute("importAllNum",importAllNum);
        httpSession.setAttribute("importSuccessNum",importSuccessNum);

        if(importSuccessNum>0)
            return "success!"+"应处理"+importAllNum+"条,已成功处理"+importSuccessNum+"条！";
        else{
            return "error!";
        }
    }

}
