package com.trainingplanner;

public class Requester {
	private int reqId;
	private String name;
	private String phoneNo;
	private String reqProgName;
	private String location;
	private int traineesExpected;
	public int getReqId() {
		return reqId;
	}
	public void setReqId(int reqId) {
		this.reqId = reqId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getReqProgName() {
		return reqProgName;
	}
	public void setReqProgName(String reqProgName) {
		this.reqProgName = reqProgName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getTraineesExpected() {
		return traineesExpected;
	}
	public void setTraineesExpected(int traineesExpected) {
		this.traineesExpected = traineesExpected;
	}
	@Override
	public String toString() {
		return "Requester [reqId=" + reqId + ", name=" + name + ", phoneNo=" + phoneNo + ", reqProgName=" + reqProgName
				+ ", location=" + location + ", traineesExpected=" + traineesExpected + "]";
	}
	
}
