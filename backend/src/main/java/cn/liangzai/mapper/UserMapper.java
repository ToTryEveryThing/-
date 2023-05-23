package cn.liangzai.mapper;

import cn.liangzai.pojo.user;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/***
 * @author 睡醒继续做梦
 * @date 2023/5/22 11:06
 */
@Mapper
public interface UserMapper extends BaseMapper<user> {
}
