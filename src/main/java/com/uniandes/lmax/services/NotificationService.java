package com.uniandes.lmax.services;

import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.*;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.EventTranslator;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.uniandes.lmax.models.LongEvent;
import com.uniandes.lmax.models.LongEventFactory;
import com.uniandes.lmax.models.LongEventHandler;
import com.uniandes.lmax.models.LongEventHandler2;
import com.uniandes.lmax.models.LongEventTranslator;

@Service
public class NotificationService {
	/**
	 * LOGGER
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(ReceptionerService.class);
	
	public void recepcionerTrace(String trace){

		LongEventFactory ef = new LongEventFactory();
		Disruptor<LongEvent> disruptor = new Disruptor<LongEvent>(ef, 1024,
				Executors.newCachedThreadPool());

		
		EventHandler<LongEvent> handler = new LongEventHandler();
		disruptor.handleEventsWith(handler);
		disruptor.after(handler).handleEventsWith(new LongEventHandler2());

		RingBuffer<LongEvent> ringBuffer = disruptor.start();

		EventTranslator<LongEvent> et = new LongEventTranslator();
		
		long initDate = System.currentTimeMillis();
		for (int i = 0; i < 20; i++) {
			ringBuffer.publishEvent(et);
		}
		long endDate = System.currentTimeMillis();
		String resultado = "Lo hizo en " + (endDate-initDate) + " milisegundos en total";
		System.out.println(resultado);
		
		LOGGER.info("Log Test: {}", trace);
	}
}