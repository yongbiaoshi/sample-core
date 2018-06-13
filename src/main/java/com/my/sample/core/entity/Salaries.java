package com.my.sample.core.entity;

import java.util.Date;
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
public class Salaries extends Model<Salaries> {

    private static final long serialVersionUID = 1L;

    @TableId("emp_no")
    private Integer empNo;
    private Integer salary;
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

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
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
        return "Salaries{" +
        "empNo=" + empNo +
        ", salary=" + salary +
        ", fromDate=" + fromDate +
        ", toDate=" + toDate +
        "}";
    }
}
