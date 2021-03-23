package com.oracle.tao.kafka;

import com.oracle.tao.service.VideoJsonService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.SQLException;

@Component
public class KafkaConsumer {
//    @Autowired
//    OracleDao oracleDao;

    @Resource
    VideoJsonService videoJsonService;

 //   Connection conn;



    @KafkaListener(topics = "${spring.kafka.template.default-topic}")
    public void receive(String message) throws SQLException {

        //this.conn= OracleDao.getConnection();
        //oracleDao.insertJSON(conn,message);
        videoJsonService.create(message);
        System.out.println("app_log--消费消息:" + message);
    }
}
