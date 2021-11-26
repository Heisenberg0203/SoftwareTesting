package com.example.alumni.bean;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Feed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int feed_id;

    @OneToOne
    private AlumniDetails alumni;

    private String text;

    private Date createdDate;

    @PrePersist
    protected void onCreate(){
        createdDate=new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        updatedDate=new Date();
    }
    private Date updatedDate;

    int likes;

    public Feed() {
    }

    public Feed(int feed_id, AlumniDetails alumni, String text, Date createdDate, Date updatedDate,int likes) {
        this.feed_id = feed_id;
        this.alumni = alumni;
        this.text = text;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.likes=likes;
    }

    public int getFeed_id() {
        return feed_id;
    }

    public void setFeed_id(int feed_id) {
        this.feed_id = feed_id;
    }

    public AlumniDetails getAlumni() {
        return alumni;
    }

    public void setAlumni(AlumniDetails alumni) {
        this.alumni = alumni;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public int getLikes() { return likes; }

    public void setLikes(int likes) { this.likes = likes; }

    @Override
    public String toString() {
        return "Feed{" +
                "feed_id=" + feed_id +
                ", alumni=" + alumni +
                ", text='" + text + '\'' +
                ", likes='" + likes + '\'' +
                '}';
    }
}
