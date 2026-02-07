package org.example.kafka;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class StringRawData {
    private long id;
    private String data;
    private Date createdTime;
    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    public StringRawData (long id, String data) {
        this.id = id;
        this.data = data;
        this.createdTime = Calendar.getInstance().getTime();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "StringRawData{" +
                "id=" + id +
                ", data='" + data + '\'' +
                ", createdTime='" + dateFormat.format(createdTime) + '\'' +
                '}';
    }
}
