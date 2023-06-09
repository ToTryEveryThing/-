package cn.liangzai.service.impl;

import cn.liangzai.mapper.UserMapper;
import cn.liangzai.pojo.user;
import cn.liangzai.service.registerService;
import com.alibaba.fastjson2.JSONB;
import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * @author 睡醒继续做梦
 * @date 2023/5/22 11:24
 */
@Service
public class registerServiceImpl implements registerService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public JSONObject register(String username, String password) {

        JSONObject res = new JSONObject();
        QueryWrapper<user> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", username);
        List<user> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
        if(users.size() != 0){
            System.out.println("用户名存在");
            res.put("message", "用户名存在");
            return res;
        }
        String encodedPassword = passwordEncoder.encode(password);
        user user = new user(null, username, encodedPassword);
        userMapper.insert(user);

        res.put("message", "success");

        return res;
    }

}
