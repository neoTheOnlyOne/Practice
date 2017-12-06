package com.tollsys.dal.entities;

import java.util.Date;

public class SmartCard {

	private String smartCardId;
	private Date issueDate;

	public SmartCard(String smartCardId) {
		this.smartCardId = smartCardId;
	}
	
	public String getSmartCardId() {
		return smartCardId;
	}
	public void setSmartCardId(String smartCardId) {
		this.smartCardId = smartCardId;
	}
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
}
