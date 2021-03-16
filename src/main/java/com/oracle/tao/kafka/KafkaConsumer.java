package com.oracle.tao.kafka;

import com.oracle.tao.dao.OracleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

@Component
public class KafkaConsumer {
    @Autowired
    OracleDao oracleDao;
    Connection conn;


    @KafkaListener(topics = "${spring.kafka.template.default-topic}")
    public void receive(String message) throws SQLException {

        this.conn= OracleDao.getConnection();
        oracleDao.insertJSON(conn,message);
        System.out.println("app_log--消费消息:" + message);
    }
}
