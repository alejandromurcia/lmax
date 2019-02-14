package com.uniandes.lmax.events.factory;
import com.lmax.disruptor.EventFactory;
import com.uniandes.lmax.events.ProcessorEvent;

public class ProcessorEventFactory implements EventFactory<ProcessorEvent>
{
    public ProcessorEvent newInstance()
    {
        return new ProcessorEvent();
    }
}