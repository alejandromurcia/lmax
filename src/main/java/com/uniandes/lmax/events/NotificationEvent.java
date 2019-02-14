package com.uniandes.lmax.events;

import java.util.List;

import com.uniandes.lmax.enums.NotificationType;

public class NotificationEvent{
	
	/** The notification Type. */
    private List<NotificationType> notificationTypeList;
    
    /** The address *. */
    private String address;
    
    /** The phone *. */
    private String phone;
    
    public NotificationEvent(String address, String phone, List<NotificationType> notificationTypeList){
	  this.address = address;
	  this.phone = phone;
	  this.notificationTypeList = notificationTypeList;
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

	public List<NotificationType> getNotificationTypeList() {
		return notificationTypeList;
	}

	public void setNotificationTypeLis(List<NotificationType> notificationTypeList) {
		this.notificationTypeList = notificationTypeList;
	}
}
