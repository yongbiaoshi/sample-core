package com.my.sample.core.entity.qo;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * 用户查询对象
 *
 * @author shiyongbiao
 */
@Data
public class UserQo {


    /**
     * 主键
     */
    private Long id;
    /**
     * 用户唯一编号
     */
    private String uid;
    /**
     * 姓名
     */
    @NotBlank
    private String name;
    /**
     * 年龄
     */
    @Range(min = 0, max = 150)
    private Integer age;
    /**
     * 手机号
     */
    @Pattern(regexp = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$")
    private String mobileNum;
    /**
     * email地址
     */
    @Email
    private String email;
    /**
     * 地址
     */
    private String address;
    /**
     * 更新时间
     */
    @Null
    private Date modifyTime;

}
