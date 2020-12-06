package com.trainingplanner;

import java.sql.Date;

public class Program {
	private int progId;
	private String title;
	private String location;
	private Date startDate;
	private Date endDate;
	private double fee;
	private int instId;

	public int getProgId() {
		return progId;
	}

	public void setProgId(int progId) {
		this.progId = progId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	public int getInstId() {
		return instId;
	}

	public void setInstId(int instId) {
		this.instId = instId;
	}

	@Override
	public String toString() {
		return "Program [progId=" + progId + ", title=" + title + ", location=" + location + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", fee=" + fee + ", instId=" + instId + "]";
	}

}
