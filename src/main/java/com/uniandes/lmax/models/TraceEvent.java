package com.uniandes.lmax.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TraceEvent{

	/** The alert param *. */
    private boolean isAlert;
	
	/** The control Model. */
    private List<ControlModel> controlModelList;

    @JsonProperty("is_alert")
	public boolean isAlert() {
		return isAlert;
	}

	@JsonProperty("is_alert")
	public void setAlert(boolean isAlert) {
		this.isAlert = isAlert;
	}
	
	@JsonProperty("control_model_list")
	public List<ControlModel> getControlModelList() {
		return controlModelList;
	}

	@JsonProperty("control_model_list")
	public void setControlModelList(List<ControlModel> controlModelList) {
		this.controlModelList = controlModelList;
	}
}
