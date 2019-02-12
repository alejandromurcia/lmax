package com.uniandes.lmax.models;
import com.lmax.disruptor.EventHandler;

public class LongEventHandler2 implements EventHandler<LongEvent>
{
	public int id = 1;
    public void onEvent(LongEvent event, long sequence, boolean endOfBatch)
    {
    	System.out.print("test2:"+ ++id +"\n");
    	System.out.print("event2:"+ event.getValue() +"\n");
    }
}