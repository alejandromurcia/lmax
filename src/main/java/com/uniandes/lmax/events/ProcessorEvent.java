package com.uniandes.lmax.events;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lmax.disruptor.RingBuffer;

public class ProcessorEvent{

	/** The alert param *. */
    private boolean isAlert;
	
	/** The sensor List. */
    private List<Boolean> sensorList;
    
    /** The address *. */
    private String address;
    
    /** The phone *. */
    private String phone;
    
    /** The ring Buffer Notification *. */
    private RingBuffer<NotificationEvent> ringBufferNotification;

    @JsonProperty("is_alert")
	public boolean isAlert() {
		return isAlert;
	}

	@JsonProperty("is_alert")
	public void setAlert(boolean isAlert) {
		this.isAlert = isAlert;
	}
	
	@JsonProperty("sensor_list")
	public List<Boolean> getSensorList() {
		return sensorList;
	}

	@JsonProperty("sensor_list")
	public void setSensorList(List<Boolean> sensorList) {
		this.sensorList = sensorList;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public RingBuffer<NotificationEvent> getRingBufferNotification() {
		return ringBufferNotification;
	}

	public void setRingBufferNotification(RingBuffer<NotificationEvent> ringBufferNotification) {
		this.ringBufferNotification = ringBufferNotification;
	}
}
