package com.uniandes.lmax.events.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;

import com.lmax.disruptor.EventHandler;
import com.uniandes.lmax.events.NotificationEvent;

public class NotificationEventHandler implements EventHandler<NotificationEvent>
{
	/**
	 * LOGGER
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(NotificationEventHandler.class);
	
	public void onEvent(NotificationEvent event, long sequence, boolean endOfBatch)
    {
		sendNotifications(event);
		LOGGER.info("notificationHandler enter and phone is: {}", event.getPhone());
    }
	
	@Async
	private void sendNotifications(NotificationEvent event)
    {
		LOGGER.info("Sending notification");
    }
}