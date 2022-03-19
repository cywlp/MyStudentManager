package com.MyStudentManager;

/**
 * @author :珠代
 * @description :
 * @create :2022-03-03 17:05:00
 */

import java.io.Serializable;

public class Student implements Serializable {//实现Serializable接口序列化实体类


    private static final long serialVersionUID = -4003999962842683112L;
    private String sid;//学号
    private String name;//姓名
    private String sex;//性别
    private String age;//年龄
    private String major;//专业
    private String location;//位置
    private String length;//长度

    @Override
    public String toString() {
        return "Student{" +
                "sid='" + sid + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", major='" + major + '\'' +
                '}';
    }

    public Student() {
    }

    public Student(String sid, String name, String sex, String age, String major) {
        this.sid = sid;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.major = major;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

}
