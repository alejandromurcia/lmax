package com.uniandes.lmax.models;
import com.lmax.disruptor.EventHandler;

public class TraceEventHandler implements EventHandler<TraceEvent>
{
	public void onEvent(TraceEvent event, long sequence, boolean endOfBatch)
    {
    	if(!event.isAlert()){
    		endOfBatch = true;
    	}
    }
}