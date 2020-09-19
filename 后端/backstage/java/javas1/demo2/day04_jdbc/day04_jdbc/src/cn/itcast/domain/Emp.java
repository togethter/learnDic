package cn.itcast.domain;

import java.util.Date;

/**
 * 封装Emp表数据的javaBean
 */
public class Emp {
    private int id;
    private String name;
    private String gender;
    private Date join_date;
    private double salary;

    public Date getJoin_date(java.sql.Date join_date) {
        return this.join_date;
    }

    public void setJoin_date(Date join_date) {
        this.join_date = join_date;
    }

    private int dept_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }



    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getDept_id(int dept_id) {
        return this.dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }
    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", join_date=" + join_date +
                ", salary=" + salary +
                ", dept_id=" + dept_id +
                '}';
    }

}
