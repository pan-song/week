package com.bawei.pss20191204.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Android Studio.
 * User: 潘世松
 * Date: 2019/12/4
 * Time: 8:49
 */
@Entity
public class LawyerData {
    @Id(autoincrement = true)
    private long id;
    private String name;
    private String iofo;
    @Generated(hash = 1506656415)
    public LawyerData(long id, String name, String iofo) {
        this.id = id;
        this.name = name;
        this.iofo = iofo;
    }
    @Generated(hash = 95617002)
    public LawyerData() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getIofo() {
        return this.iofo;
    }
    public void setIofo(String iofo) {
        this.iofo = iofo;
    }

    @Override
    public String toString() {
        return "LawyerData{" +
                "name='" + name + '\'' +
                ", iofo='" + iofo + '\'' +
                '}';
    }

    public LawyerData(String name, String iofo) {
        this.name = name;
        this.iofo = iofo;
    }
}
