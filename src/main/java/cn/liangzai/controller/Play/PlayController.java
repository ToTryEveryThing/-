package cn.liangzai.controller.Play;

import cn.liangzai.pojo.Play;
import cn.liangzai.service.impl.PlayServiceImpl;
import com.alibaba.fastjson2.JSONObject;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/***
 * @author 睡醒继续做梦
 * @date 2023/5/22 12:39
 */

/**
 * 演唱会
 *
 * @module liangzai
 */
@RestController
public class PlayController {


    @Autowired
    PlayServiceImpl playService;

    @ApiOperation("查询所有演出")
    @GetMapping("/play/select/")
    public JSONObject select(){
        return playService.Select();
    }

    @ApiOperation("更新演出")
    @PostMapping("/play/update/")
    public JSONObject update(@RequestBody  Play play){
        System.out.println(">>>>>>>");
        return playService.Update(play);
    }

    @ApiOperation("删除演出")
    @DeleteMapping("/play/delete/")
    public JSONObject delete(Integer id){
        return playService.Delete(id);
    }

    @ApiOperation("添加演出")
    @PutMapping("/play/add/")
    public JSONObject add(@RequestBody Play play){
        return playService.Add(play);
    }

}
