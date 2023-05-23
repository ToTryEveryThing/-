package cn.liangzai.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/***
 * @author 睡醒继续做梦
 * @date 2023/5/22 11:47
 */
@Data
@TableName("login_log")
@AllArgsConstructor
@NoArgsConstructor
public class Log {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;
    private Date time;
}
