package cn.liangzai.controller.user;

import cn.liangzai.service.impl.registerServiceImpl;
import com.alibaba.fastjson2.JSONObject;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/***
 * @author 睡醒继续做梦
 * @date 2023/5/22 11:20
 */

/**
 * 用户
 *
 * @module liangzai
 */
@RestController
public class RegisterController {

    @Autowired
    private registerServiceImpl register;


    @ApiOperation("注册")
    @GetMapping("/user/register/")
    public JSONObject reigster(@RequestParam String name,
                               @RequestParam String password){
        return register.register(name, password);
    }

}
