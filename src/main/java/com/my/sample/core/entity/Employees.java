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
public class Employees extends Model<Employees> {

    private static final long serialVersionUID = 1L;

    @TableId("emp_no")
    private Integer empNo;
    @TableField("birth_date")
    private Date birthDate;
    @TableField("first_name")
    private String firstName;
    @TableField("last_name")
    private String lastName;
    private String gender;
    @TableField("hire_date")
    private Date hireDate;


    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @Override
    protected Serializable pkVal() {
        return this.empNo;
    }

    @Override
    public String toString() {
        return "Employees{" +
        "empNo=" + empNo +
        ", birthDate=" + birthDate +
        ", firstName=" + firstName +
        ", lastName=" + lastName +
        ", gender=" + gender +
        ", hireDate=" + hireDate +
        "}";
    }
}
