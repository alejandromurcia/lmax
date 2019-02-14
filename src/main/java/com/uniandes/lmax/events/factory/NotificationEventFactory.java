package com.uniandes.lmax.events.factory;
import com.lmax.disruptor.EventFactory;
import com.uniandes.lmax.events.NotificationEvent;

public class NotificationEventFactory implements EventFactory<NotificationEvent>
{
    public NotificationEvent newInstance()
    {
        return new NotificationEvent(null, null, null);
    }
}