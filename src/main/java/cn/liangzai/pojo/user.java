package cn.liangzai.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 * @author 睡醒继续做梦
 * @date 2023/5/22 11:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class user {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String password;
}
