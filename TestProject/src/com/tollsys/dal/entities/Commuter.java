package com.tollsys.dal.entities;

import java.util.Set;

public class Commuter {

	private String name;
	private String mobile;
	private String vehicleNo;
	private Set<SmartCard> smartCard;
	
	public Commuter() {
		
	}
	
	public Commuter(String name, String mobile, String vehicleNo, Set<SmartCard> smartCard) {
		this.name = name;
		this.mobile = mobile;
		this.vehicleNo = vehicleNo;
		this.smartCard = smartCard;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getVehicleNo() {
		return vehicleNo;
	}
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public Set<SmartCard> getSmartCard() {
		return smartCard;
	}

	public void setSmartCard(Set<SmartCard> smartCard) {
		this.smartCard = smartCard;
	}
}
