package com.my.sample.core.entity.form;

import com.baomidou.mybatisplus.annotations.TableField;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;
import java.util.Date;

/**
 * 接收用户数据
 *
 * @author shiyongbiao
 */
@Data
public class UserForm {


    /**
     * 分组-新增用户，用于参数校验
     */
    public interface UserAddGroup {
    }

    /**
     * 分组-更新用户，用于参数校验
     */
    public interface UserUpdateGroup {
    }

    /**
     * 主键
     */
    @Null(groups = {UserAddGroup.class})
    private Long id;
    /**
     * 用户唯一编号
     */
    @Null(groups = {UserAddGroup.class})
    @NotBlank(groups = {UserUpdateGroup.class})
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
