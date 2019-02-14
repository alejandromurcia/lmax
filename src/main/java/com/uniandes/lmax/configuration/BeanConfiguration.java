package com.uniandes.lmax.configuration;

import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.uniandes.lmax.events.NotificationEvent;
import com.uniandes.lmax.events.ProcessorEvent;
import com.uniandes.lmax.events.factory.NotificationEventFactory;
import com.uniandes.lmax.events.factory.ProcessorEventFactory;
import com.uniandes.lmax.events.handler.NotificationEventHandler;
import com.uniandes.lmax.events.handler.ProcessorEventHandler;

@Configuration
public class BeanConfiguration {
		
	@Bean
	@Qualifier("ringProcessor")
	public RingBuffer<ProcessorEvent> ringProcessor(){
		ProcessorEventFactory traceEventFactory = new ProcessorEventFactory();
		
		Disruptor<ProcessorEvent> disruptor = new Disruptor<ProcessorEvent>(traceEventFactory, 1024,
				Executors.newCachedThreadPool());
		
		EventHandler<ProcessorEvent> handler = new ProcessorEventHandler();
		disruptor.handleEventsWith(handler);
		return disruptor.start();		 
	}
	
	@Bean
	@Qualifier("ringNotification")
	public RingBuffer<NotificationEvent> ringNotification(){
		NotificationEventFactory notificationEventFactory = new NotificationEventFactory();
		
		Disruptor<NotificationEvent> disruptor = new Disruptor<NotificationEvent>(notificationEventFactory, 1024,
				Executors.newCachedThreadPool());
		
		EventHandler<NotificationEvent> handler = new NotificationEventHandler();
		disruptor.handleEventsWith(handler);
		return disruptor.start();		 
	}
}