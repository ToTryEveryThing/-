package cn.liangzai.service;

import cn.liangzai.pojo.Play;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 睡醒继续做梦
* @description 针对表【play】的数据库操作Service
* @createDate 2023-05-22 12:28:32
*/
public interface PlayService {

    JSONObject Select();

    JSONObject Update(Play play);

    JSONObject Delete(String id);

    JSONObject Add(Play play);
}
