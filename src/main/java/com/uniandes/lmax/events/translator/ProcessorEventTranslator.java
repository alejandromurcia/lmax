package com.uniandes.lmax.events.translator;
import com.lmax.disruptor.EventTranslator;
import com.uniandes.lmax.events.ProcessorEvent;

public class ProcessorEventTranslator implements EventTranslator<ProcessorEvent>
{
	ProcessorEvent event;
	public ProcessorEventTranslator(ProcessorEvent procesorEvent){
		this.event = procesorEvent;
	}
	
	@Override
	public void translateTo(ProcessorEvent procesorEvent, long sequence) {
		procesorEvent.setAlert(this.event.isAlert());
		procesorEvent.setSensorList(this.event.getSensorList());
		procesorEvent.setPhone(this.event.getPhone());
		procesorEvent.setAddress(this.event.getAddress());
		procesorEvent.setRingBufferNotification(this.event.getRingBufferNotification());
	}
}