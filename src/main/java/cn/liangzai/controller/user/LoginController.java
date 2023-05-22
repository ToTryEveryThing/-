package cn.liangzai.controller.user;

import cn.liangzai.service.impl.loginServiceImpl;
import com.alibaba.fastjson2.JSONB;
import com.alibaba.fastjson2.JSONObject;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/***
 * @author 睡醒继续做梦
 * @date 2023/5/22 11:34
 */

/**
 * 用户
 *
 * @module liangzai
 */
@RestController
public class LoginController {

    @Autowired
    private loginServiceImpl loginService;

    @ApiOperation("登录")
    @GetMapping("/user/login/")
    public JSONObject login(@RequestParam String name,
                            @RequestParam String password){
        return loginService.login(name, password);
    }

}
