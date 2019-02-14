package com.uniandes.lmax.services;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.*;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.lmax.disruptor.EventTranslator;
import com.lmax.disruptor.RingBuffer;
import com.uniandes.lmax.events.NotificationEvent;
import com.uniandes.lmax.events.ProcessorEvent;
import com.uniandes.lmax.events.translator.ProcessorEventTranslator;

@Service
public class ReceptionerService {
	
	/**
	 * LOGGER
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(ReceptionerService.class);

	@Autowired
	@Qualifier("ringProcessor")
	private RingBuffer<ProcessorEvent> ringBufferProcessor;
	
	@Autowired
	@Qualifier("ringNotification")
	private RingBuffer<NotificationEvent> ringBufferNotification;
	
	public void recepcionerTrace(ProcessorEvent traceEvent) throws JsonParseException, JsonMappingException, IOException{
		
		traceEvent.setRingBufferNotification(ringBufferNotification);
		EventTranslator<ProcessorEvent> eventTranslator = new ProcessorEventTranslator(traceEvent);
		this.ringBufferProcessor.publishEvent(eventTranslator);
	}	
}