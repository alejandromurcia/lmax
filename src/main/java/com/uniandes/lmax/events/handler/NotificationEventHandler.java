package com.uniandes.lmax.events.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;

import com.lmax.disruptor.EventHandler;
import com.uniandes.lmax.events.NotificationEvent;

import java.sql.Timestamp;

public class NotificationEventHandler implements EventHandler<NotificationEvent>
{
	private static int counter = 0;

	/**
	 * LOGGER
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(NotificationEventHandler.class);
	
	public void onEvent(NotificationEvent event, long sequence, boolean endOfBatch)
    {
		sendNotifications(event);
		counter++;
		if(counter % 500 == 0)
		LOGGER.info("counter: {} not: {}", counter, new Timestamp(System.currentTimeMillis()));
    }
	
	@Async
	void sendNotifications(NotificationEvent event)
    {

    }
}