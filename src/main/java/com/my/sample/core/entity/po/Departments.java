package com.my.sample.core.entity.po;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author shiyongbiao
 * @since 2018-06-13
 */
public class Departments extends Model<Departments> {

    private static final long serialVersionUID = 1L;

    @TableId("dept_no")
    private String deptNo;
    @TableField("dept_name")
    private String deptName;


    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    protected Serializable pkVal() {
        return this.deptNo;
    }

    @Override
    public String toString() {
        return "Departments{" +
        "deptNo=" + deptNo +
        ", deptName=" + deptName +
        "}";
    }
}
