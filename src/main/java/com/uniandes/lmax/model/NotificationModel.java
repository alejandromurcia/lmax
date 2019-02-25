package com.uniandes.lmax.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.uniandes.lmax.enums.NotificationType;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class NotificationModel {

	/** The notification Type. */
    private NotificationType notificationType;

    /** The address *. */
    private String address;

    /** The phone *. */
    private String phone;

    public NotificationModel(String address, String phone, NotificationType notificationType){
    	this.address = address;
    	this.phone = phone;
    	this.notificationType = notificationType;
	}

	@JsonProperty("address")
    public String getAddress() {
		return address;
	}

	@JsonProperty("address")
	public void setAddress(String address) {
		this.address = address;
	}

	@JsonProperty("phone")
	public String getPhone() {
		return phone;
	}

	@JsonProperty("phone")
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@JsonProperty("notification_type")
	public NotificationType getNotificationType() {
		return notificationType;
	}

	@JsonProperty("notification_type")
	public void setNotificationType(NotificationType notificationType) {
		this.notificationType = notificationType;
	}
}
