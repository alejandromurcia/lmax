package com.uniandes.lmax.services;

import java.io.IOException;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.*;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.EventTranslator;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.uniandes.lmax.models.LongEvent;
import com.uniandes.lmax.models.LongEventFactory;
import com.uniandes.lmax.models.LongEventHandler;
import com.uniandes.lmax.models.LongEventHandler2;
import com.uniandes.lmax.models.LongEventTranslator;
import com.uniandes.lmax.models.TraceEvent;
import com.uniandes.lmax.models.TraceEventFactory;
import com.uniandes.lmax.models.TraceEventHandler;
import com.uniandes.lmax.models.TraceEventTranslator;

@Service
public class ReceptionerService {
	
	/**
	 * LOGGER
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(ReceptionerService.class);
	
	public void recepcionerTrace(TraceEvent traceEvent) throws JsonParseException, JsonMappingException, IOException{
		
		TraceEventFactory traceEventFactory = new TraceEventFactory();
		Disruptor<TraceEvent> disruptor = new Disruptor<TraceEvent>(traceEventFactory, 1024,
				Executors.newCachedThreadPool());

		
		EventHandler<TraceEvent> handler = new TraceEventHandler();
		disruptor.handleEventsWith(handler);
		//disruptor.after(handler).handleEventsWith(new LongEventHandler2());

		RingBuffer<TraceEvent> ringBuffer = disruptor.start();

		EventTranslator<TraceEvent> eventTranslator = new TraceEventTranslator(traceEvent);
		
		ringBuffer.publishEvent(eventTranslator);
		
		LOGGER.info("Log Test: {}", objectToString(traceEvent));
	}
	
	
	
	
	
	public TraceEvent stringToObject(String trace) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();

	    return mapper.readValue(trace, TraceEvent.class);
	}
	
	public String objectToString(TraceEvent traceEvent) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();

	    return mapper.writeValueAsString(traceEvent);
	}
}