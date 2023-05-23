package cn.liangzai.controller.test;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * @author 睡醒继续做梦
 * @date 2023/5/22 11:37
 */

/**
 * 测试
 * @module liangzai
 */
@RestController
public class testController {



    @ApiOperation("测试")
    @GetMapping("/test/")
    public String hh(){
        return "hello world";
    }

}
