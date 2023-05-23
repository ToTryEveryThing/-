package cn.liangzai.service.impl;

import cn.liangzai.utils.redisUtil;
import com.alibaba.fastjson2.JSONObject;
import cn.liangzai.pojo.Play;
import cn.liangzai.service.PlayService;
import cn.liangzai.mapper.PlayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 睡醒继续做梦
* @description 针对表【play】的数据库操作Service实现
* @createDate 2023-05-22 12:28:32
*/
@Service
public class PlayServiceImpl implements PlayService{

    public static final String REDIS_PLAY = "play";

    @Autowired
    private redisUtil redisUtil;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private PlayMapper playMapper;


    @Override
    public JSONObject Select() {
        List<Object> allValuesFromHash = getAllValuesFromHash(REDIS_PLAY);
        JSONObject res = new JSONObject();
        res.put("message", "success");
        res.put("data", allValuesFromHash);
        return res;
    }

    @Override
    public JSONObject Update(Play play) {
        System.out.println(play);
        JSONObject res = new JSONObject();
        int i = playMapper.updateById(play);
        if(i>=1)
            res.put("message", "success");
        else res.put("message", "fail");

        redisUtil.hset(REDIS_PLAY, String.valueOf(play.getId()),play);

        return res;
    }

    @Override
    public JSONObject Delete(String id) {
        JSONObject res = new JSONObject();
        int i = playMapper.deleteById(id);
        if(i>=1)
            res.put("message", "success");
        else res.put("message", "fail");

        redisUtil.hdel(REDIS_PLAY,id);

        return res;
    }

    @Override
    public JSONObject Add(Play play) {
        JSONObject res = new JSONObject();
        Integer random = (int) (Math.random()*1000000+1);
        play.setId(random);
        int insert = playMapper.insert(play);

        redisUtil.hset(REDIS_PLAY, String.valueOf(play.getId()),play);

        if(insert>=1)
            res.put("message", "success");
        else res.put("message", "fail");
        return res;
    }

    public List<Object> getAllValuesFromHash(String hashKey) {
        HashOperations<String, String, Object> hashOperations = redisTemplate.opsForHash();


        // 获取Hash结构中的所有值
        List<Object> values = hashOperations.values(hashKey);

        return values;
    }
}




