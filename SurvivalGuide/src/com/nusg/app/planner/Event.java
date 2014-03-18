package com.nusg.app.planner;

public class Event {
	private String name;
	private String desc;
	private long startTime;
	private long endTime;
	
	
	public Event(String name, String desc, long startTime, long endTime) {
		super();
		this.name = name;
		this.desc = desc;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	
	public String getName() {
		return name;
	}
	public String getDesc() {
		return desc;
	}
	public long getStartTime() {
		return startTime;
	}
	public long getEndTime() {
		return endTime;
	}
	
	
	
}
