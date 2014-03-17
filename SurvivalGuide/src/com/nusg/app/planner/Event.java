package com.nusg.app.planner;

public class Event {
	private String name;
	private int startTime;
	private int endTime;
	private String description;
	
	
	public Event(String name, int startTime, int endTime, String description) {
		super();
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
		this.description = description;
	}
	
	
	public String getName() {
		return name;
	}
	public int getStartTime() {
		return startTime;
	}
	public int getEndTime() {
		return endTime;
	}
	public String getDescription() {
		return description;
	}
	
	
	
}
