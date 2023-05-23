package cn.liangzai.service.impl;

import cn.liangzai.mapper.LogMapper;
import cn.liangzai.pojo.Log;
import cn.liangzai.pojo.user;
import cn.liangzai.service.loginService;
import cn.liangzai.service.utils.UserDetailsImpl;
import cn.liangzai.utils.JwtUtil;
import com.alibaba.fastjson2.JSONObject;
import lombok.Data;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

import static cn.liangzai.config.RabbitmqConfig.ARTICLE_DIRECT_ROUTE;
import static cn.liangzai.config.RabbitmqConfig.EXCHANGE_NAME;

/***
 * @author 睡醒继续做梦
 * @date 2023/5/22 11:32
 */
@Service
public class loginServiceImpl implements loginService {

    @Autowired
    private LogMapper logMapper;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public JSONObject login(String username, String password) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(username, password);

        System.out.println("jinlaile ");
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);  // 登录失败，会自动处理
        UserDetailsImpl loginUser = (UserDetailsImpl) authenticate.getPrincipal();
        user user = loginUser.getUser();
        String jwt = JwtUtil.createJWT(user.getName().toString());
        JSONObject map = new JSONObject();
        System.out.println("拿到了 ");
        map.put("message", "success");
        map.put("token", jwt);
//记录日志
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ARTICLE_DIRECT_ROUTE, username);
//        logMapper.insert(new Log(null, username, new Date()));
        System.out.println("hhhh");

        return map;
    }

}
