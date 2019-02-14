package com.uniandes.lmax.events.translator;
import com.lmax.disruptor.EventTranslator;
import com.uniandes.lmax.events.NotificationEvent;

public class NotificationEventTranslator implements EventTranslator<NotificationEvent>
{
	NotificationEvent event;
	public NotificationEventTranslator(NotificationEvent event){
		this.event = event;
	}
	
	@Override
	public void translateTo(NotificationEvent notificationEvent, long sequence) {
		notificationEvent.setNotificationTypeLis(this.event.getNotificationTypeList());
		notificationEvent.setAddress(this.event.getAddress());
		notificationEvent.setPhone(this.event.getPhone());
	}
}