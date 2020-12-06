package com.trainingplanner;

public class Trainee {
	private int tId;
	private String name;
	private String qualification;
	private String email;
	private String contry;
	public int gettId() {
		return tId;
	}
	public void settId(int tId) {
		this.tId = tId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContry() {
		return contry;
	}
	public void setContry(String contry) {
		this.contry = contry;
	}
	@Override
	public String toString() {
		return "Trainee [tId=" + tId + ", name=" + name + ", qualification=" + qualification + ", email=" + email
				+ ", contry=" + contry + "]";
	}
}
