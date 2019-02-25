package com.uniandes.lmax.events.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lmax.disruptor.EventHandler;
import com.uniandes.lmax.enums.NotificationType;
import com.uniandes.lmax.events.NotificationEvent;
import com.uniandes.lmax.model.BaseMessage;
import com.uniandes.lmax.model.NotificationModel;
import com.uniandes.lmax.utils.KafkaUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;

public class NotificationEventHandler implements EventHandler<NotificationEvent>
{
	private static int counter = 0;

	/**
	 * LOGGER
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(NotificationEventHandler.class);
	
	public void onEvent(NotificationEvent event, long sequence, boolean endOfBatch) throws JsonProcessingException {
		sendNotifications(event);
		counter++;
		if(counter % 500 == 0)
		LOGGER.info("counter: {} not: {}", counter, new Timestamp(System.currentTimeMillis()));
    }
	
	public void sendNotifications(NotificationEvent event) throws JsonProcessingException {

		for(NotificationType notificationType : event.getNotificationTypeList()){
			this.buildAndSendNotification(event.getAddress(), event.getPhone(),
					notificationType);
		}
		this.buildAndSendNotification(event.getAddress(), event.getPhone(),
				NotificationType.OWNER);
    }

	private void buildAndSendNotification(String address, String phone, NotificationType notificationType) throws JsonProcessingException {
		NotificationModel notificationModel = new NotificationModel(address, phone,
				notificationType);

		this.sendEventCredits(notificationModel);
	}

    private void sendEventCredits(NotificationModel notificationModel) throws JsonProcessingException {
		String notification = new ObjectMapper().writeValueAsString(notificationModel);
		BaseMessage message = new BaseMessage();
		message.setBody(notification);

		KafkaUtils.send(message);
	}
}