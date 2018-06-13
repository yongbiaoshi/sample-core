package com.my.sample.core.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author shiyongbiao
 * @since 2018-06-13
 */
@TableName("dept_emp")
public class DeptEmp extends Model<DeptEmp> {

    private static final long serialVersionUID = 1L;

    @TableId("emp_no")
    private Integer empNo;
    @TableField("dept_no")
    private String deptNo;
    @TableField("from_date")
    private Date fromDate;
    @TableField("to_date")
    private Date toDate;


    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    @Override
    protected Serializable pkVal() {
        return this.empNo;
    }

    @Override
    public String toString() {
        return "DeptEmp{" +
        "empNo=" + empNo +
        ", deptNo=" + deptNo +
        ", fromDate=" + fromDate +
        ", toDate=" + toDate +
        "}";
    }
}
