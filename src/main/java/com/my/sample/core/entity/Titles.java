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
public class Titles extends Model<Titles> {

    private static final long serialVersionUID = 1L;

    @TableId("emp_no")
    private Integer empNo;
    private String title;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
        return "Titles{" +
        "empNo=" + empNo +
        ", title=" + title +
        ", fromDate=" + fromDate +
        ", toDate=" + toDate +
        "}";
    }
}
