package cn.liangzai.service;

import com.alibaba.fastjson2.JSONObject;

/***
 * @author 睡醒继续做梦
 * @date 2023/5/22 11:30
 */
public interface loginService {

    JSONObject login(String name, String password);
}
