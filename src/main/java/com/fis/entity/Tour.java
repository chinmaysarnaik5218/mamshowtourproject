package com.fis.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tour {
	@Id
	@Column(length = 7,nullable = false,unique = true)
	private String package_id;
	@Column(nullable = false)
	private String source_place;
	@Column(nullable = false)
	private int fare;
	
	@Column(nullable = false)
	private String destination_place;
	public String getPackage_id() {
		return package_id;
	}
	public void setPackage_id(String package_id) {
		this.package_id = package_id;
	}
	public String getSource_place() {
		return source_place;
	}
	public void setSource_place(String source_place) {
		this.source_place = source_place;
	}
	public int getFare() {
		return fare;
	}
	public void setFare(int fare) {
		this.fare = fare;
	}
	public String getDestination_place() {
		return destination_place;
	}
	public void setDestination_place(String destination_place) {
		this.destination_place = destination_place;
	}
	@Override
	public String toString() {
		return "Tour [package_id=" + package_id + ", source_place=" + source_place + ", fare=" + fare
				+ ", destination_place=" + destination_place + "]";
	}
	public Tour(String package_id, String source_place, int fare, String destination_place) {
		super();
		this.package_id = package_id;
		this.source_place = source_place;
		this.fare = fare;
		this.destination_place = destination_place;
	}
	public Tour() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}


