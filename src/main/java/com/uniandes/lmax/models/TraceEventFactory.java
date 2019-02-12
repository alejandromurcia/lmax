package com.uniandes.lmax.models;
import com.lmax.disruptor.EventFactory;

public class TraceEventFactory implements EventFactory<TraceEvent>
{
    public TraceEvent newInstance()
    {
        return new TraceEvent();
    }
}