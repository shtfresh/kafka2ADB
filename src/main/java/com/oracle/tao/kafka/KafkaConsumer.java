package com.oracle.tao.kafka;

import com.oracle.tao.service.VideoJsonService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class KafkaConsumer {
//    @Autowired
//    OracleDao oracleDao;

    @Resource
    VideoJsonService videoJsonService;

 //   Connection conn;



//    @KafkaListener(topics = "${spring.kafka.template.default-topic}")
//    public void receive(String message) throws SQLException {
//
//        //this.conn= OracleDao.getConnection();
//        //oracleDao.insertJSON(conn,message);
//        videoJsonService.create(message);
//        System.out.println("app_log--消费消息:" + message);
//    }

    @KafkaListener(topics = "${spring.kafka.template.default-topic}")
    public void myListener(List<ConsumerRecord<Integer, String>> list){
        System.out.print(list.size()+",");
         list.forEach( it -> {
             videoJsonService.create(it.value());
        });
    }


    @KafkaListener(topics = "${spring.kafka.template.default-topic}", id = "consumer", containerFactory = "batchFactory")
    public void listen(List<ConsumerRecord<?, ?>> list) {
        List<String> messages = new ArrayList<>();
        for (ConsumerRecord<?, ?> record : list) {
            Optional<?> kafkaMessage = Optional.ofNullable(record.value());
            // 获取消息
            kafkaMessage.ifPresent(o -> messages.add(o.toString()));
            System.out.println(kafkaMessage);
        }
//        if (messages.size() > 0) {
//            // 更新索引
//            updateES(messages);
//        }
    }


}
