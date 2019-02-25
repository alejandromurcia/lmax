package com.uniandes.lmax.utils;

import com.uniandes.lmax.model.BaseMessage;
import com.uniandes.lmax.producer.Sender;

public final class KafkaUtils {

    private static Sender sender;

    public static void setSender(Sender sender) {
        KafkaUtils.sender = sender;
    }

    private KafkaUtils() {
    }

    public static void send(BaseMessage baseMessage) {
        KafkaUtils.sender.send(baseMessage);
    }
}