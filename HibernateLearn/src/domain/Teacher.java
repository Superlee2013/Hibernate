package domain;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by Super on 2015/7/25.
 */
@Entity
public class Teacher {
    private int tid;
    private String tname;
    private Date date;

    public Teacher() {
    }

    public Teacher(int tid, String tname, Date date) {
        this.tid = tid;
        this.tname = tname;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                ", date=" + date +
                '}';
    }

    @Id
    public int getTid() {
        return tid;
    }


    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
