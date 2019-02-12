package com.uniandes.lmax.models;
import com.lmax.disruptor.EventTranslator;

public class LongEventTranslator implements EventTranslator<LongEvent>
{
	@Override
	public void translateTo(LongEvent event, long sequence) {
		event.setValue(99);
	}
}