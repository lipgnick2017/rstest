package com.lipg.test.javaee.resource.model;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Player {
	private String userId;
	private String name;
	private Date joinTime;
	public static Player mock(String name) {
		Player p=new Player();
		p.setName(name);
		p.setUserId("uid-"+name.toLowerCase());
		p.setJoinTime(new Date());
		return p;
	}
	public static List<Player> players(){
		return Stream.of("Nick","Tom","Mike").map(u->Player.mock(u)).collect(Collectors.toList());
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getJoinTime() {
		return joinTime;
	}
	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}
	
	
}
