package cn.liangzai.task;

import cn.liangzai.utils.redisUtil;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static cn.liangzai.config.RabbitmqConfig.ARTICLE_QUEUE;

/***
 * @author 睡醒继续做梦
 * @date 2023/5/22 17:43
 */
@Component
public class updateLog {

    @Autowired
    private redisUtil redisUtil;

    @RabbitListener(queues = ARTICLE_QUEUE)
    public void hh(String msg){
        System.out.println("我是日志");
        System.out.println(msg);
    }

}



