package com.prueba.imatia.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderTracking {
	
	OrderTracking(){
		
	}
	
	public OrderTracking(Integer orderId, Integer trackingStatusId, Date changeStatusDate){
		this.orderId = orderId;
		this.trackingStatusId = trackingStatusId;
		this.changeStatusDate = changeStatusDate;
	}
	
	private Integer orderId;
	
	private Integer trackingStatusId;
	
	private Date changeStatusDate;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getTrackingStatusId() {
		return trackingStatusId;
	}

	public void setTrackingStatusId(Integer trackingStatusId) {
		this.trackingStatusId = trackingStatusId;
	}

	public Date getChangeStatusDate() {
		return changeStatusDate;
	}

	public void setChangeStatusDate(Date changeStatusDate) {
		this.changeStatusDate = changeStatusDate;
	}
	
	
}
