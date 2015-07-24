package domain;

import java.util.Date;

/**
 * Created by Super on 2015/7/23.
 * 学生类
 */
public class Students {
    private  int sid;//学号
    private  String sname;//姓名
    private  String gender;//性别
    private Date birthday;//出生日期
    private String address;//地址

    public Students() {
    }

    public Students(String address, int sid, String sname, String gender, Date birthday) {
        this.address = address;
        this.sid = sid;
        this.sname = sname;
        this.gender = gender;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Students{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                '}';
    }

    //getter and setter
    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
