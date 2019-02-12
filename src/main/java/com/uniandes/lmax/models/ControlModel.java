package com.uniandes.lmax.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ControlModel {

	private int sensorNumber;
	
	private int stateNumber;
	
	private int alertNumber;

	@JsonProperty("sensor_number")
	public int getSensorNumber() {
		return sensorNumber;
	}

	@JsonProperty("sensor_number")
	public void setSensorNumber(int sensorNumber) {
		this.sensorNumber = sensorNumber;
	}

	@JsonProperty("state_number")
	public int getStateNumber() {
		return stateNumber;
	}

	@JsonProperty("state_number")
	public void setStateNumber(int stateNumber) {
		this.stateNumber = stateNumber;
	}

	@JsonProperty("alert_number")
	public int getAlertNumber() {
		return alertNumber;
	}

	@JsonProperty("alert_number")
	public void setAlertNumber(int alertNumber) {
		this.alertNumber = alertNumber;
	}
}
