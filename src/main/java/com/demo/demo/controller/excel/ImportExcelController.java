package com.demo.demo.controller.excel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luwenxin
 * @create 2020/1/13
 */
@Slf4j
@RestController
@RequestMapping("/importExcel")
public class ImportExcelController {
    @RequestMapping("/import")
    public String importTest(){
        return "<input value='你好'>";
    }
}
