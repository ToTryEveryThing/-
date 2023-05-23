package cn.liangzai.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName play
 */
@TableName(value ="play")
@Data
public class Play implements Serializable {
    /**
     * 
     */

    private Integer id;

    /**
     * 地址
     */
    private String address;

    /**
     * 人数
     */
    private Integer numberOfPeople;

    /**
     * 费用/每人
     */
    private BigDecimal cost;

    /**
     * 演出标题
     */
    private String title;

    /**
     * 演出信息
     */
    private String message;

    /**
     * 发行方
     */
    private String issuer;

    /**
     * 演出时间
     */
    private Date time;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}