package com.example.alumni.dao;

import com.example.alumni.bean.Feed;
import com.example.alumni.bean.Organisation;
import com.example.alumni.utils.Main;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class FeedDAO {

    public static List<Feed> getFeeds(){
        Session session = Main.getSession();
        Transaction transaction = session.beginTransaction();
        Query fetchquery =session.createQuery("from Feed ");
        List<Feed> feeds= fetchquery.list();
        transaction.commit();
        session.close();
        return feeds;
    }
}
