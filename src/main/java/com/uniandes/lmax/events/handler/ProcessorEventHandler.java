package com.uniandes.lmax.events.handler;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.EventTranslator;
import com.uniandes.lmax.enums.NotificationType;
import com.uniandes.lmax.events.NotificationEvent;
import com.uniandes.lmax.events.ProcessorEvent;
import com.uniandes.lmax.events.translator.NotificationEventTranslator;

public class ProcessorEventHandler implements EventHandler<ProcessorEvent>
{
	/**
	 * LOGGER
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(ProcessorEventHandler.class);
	
	public void onEvent(ProcessorEvent processorEvent, long sequence, boolean endOfBatch)
    {
    	if(processorEvent.isAlert()){
    		NotificationEvent notificationEvent = verifySensorList(processorEvent);    		
    		if(notificationEvent != null) {
    			LOGGER.info("notificationEvent is not null and phone is: {}", notificationEvent.getPhone());
    			EventTranslator<NotificationEvent> notificationEventTranslator = new NotificationEventTranslator(notificationEvent);
    			processorEvent.getRingBufferNotification().publishEvent(notificationEventTranslator);
			}    	
    	}
    }
	
	public NotificationEvent verifySensorList(ProcessorEvent processorEvent)
    {
		//LOGGER.info("Log SensorList: {}", sensorList);		
		HashSet<NotificationType> notificationTypeHash = new HashSet<NotificationType>();
		int sensorCounter = 0;
		for (Boolean sensor : processorEvent.getSensorList()) {
			if(sensor){
				switch (sensorCounter) {
					case 0:
					case 1:
							notificationTypeHash.add(NotificationType.FIREMAN);
						break;
					case 2:
					case 3:
							notificationTypeHash.add(NotificationType.FIREMAN);
							notificationTypeHash.add(NotificationType.AMBULANCE);
						break;
					case 4:
							notificationTypeHash.add(NotificationType.POLICE);
						break;
				}
			}
			sensorCounter++;
		}
		
		NotificationEvent notificationEvent;
		if(notificationTypeHash.isEmpty()){
			notificationEvent = null;
		}else{
			List<NotificationType> notificationTypeList = new ArrayList<NotificationType>(notificationTypeHash);
			notificationEvent = new NotificationEvent(processorEvent.getAddress(), processorEvent.getPhone(), notificationTypeList); 
		}		
		
    	return notificationEvent;
    }
	
}