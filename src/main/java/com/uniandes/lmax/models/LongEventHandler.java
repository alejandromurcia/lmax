package com.uniandes.lmax.models;
import com.lmax.disruptor.EventHandler;

public class LongEventHandler implements EventHandler<LongEvent>
{
	public int id = 1;
    public void onEvent(LongEvent event, long sequence, boolean endOfBatch)
    {
    	System.out.print("test1:"+ ++id +"\n");
    	System.out.print("event1:"+ event.getValue() +"\n");
    }
}