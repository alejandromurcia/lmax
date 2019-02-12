package com.uniandes.lmax.models;
import com.lmax.disruptor.EventTranslator;

public class TraceEventTranslator implements EventTranslator<TraceEvent>
{
	TraceEvent traceEvent;
	public TraceEventTranslator(TraceEvent traceEvent){
		this.traceEvent = traceEvent;
	}
	
	@Override
	public void translateTo(TraceEvent event, long sequence) {
		event.setAlert(this.traceEvent.isAlert());
		event.setControlModelList(this.traceEvent.getControlModelList());
	}
}