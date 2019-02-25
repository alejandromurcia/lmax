package com.uniandes.lmax.producer;

import com.uniandes.lmax.model.BaseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

public class Sender {

    private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

    @Autowired
    private KafkaTemplate<String, BaseMessage> kafkaTemplate;

    private static String topic="kafka_topic_2";

    public void send(BaseMessage message) {
        //LOGGER.info("sending message='{}'", message.toString());

        ListenableFuture<SendResult<String, BaseMessage>> future = kafkaTemplate.send(topic, message);
        future.addCallback(new ListenableFutureCallback<SendResult<String, BaseMessage>>() {

            @Override
            public void onSuccess(SendResult<String, BaseMessage> result) {
                //LOGGER.info("sent message='{}' with offset={}", message.toString(),
                        //result.getRecordMetadata().offset());
            }

            @Override
            public void onFailure(Throwable ex) {
                LOGGER.error("unable to send message='{}'", message.toString(), ex);
            }
        });
    }
}