package com.trainingplanner;

public class TrainingReport {
	private int progId;
	private String title;
	private String instructorName;
	private String traineeName;
	private double fee;
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
	public String getInstructorName() {
		return instructorName;
	}
	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}
	public String getTraineeName() {
		return traineeName;
	}
	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}
	
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
	@Override
	public String toString() {
		return "TrainingReport [progId=" + progId + ", title=" + title + ", instructorName=" + instructorName
				+ ", traineeName=" + traineeName + ", fee=" + fee + "]";
	}
	
}
