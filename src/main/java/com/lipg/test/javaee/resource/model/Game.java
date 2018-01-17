package com.lipg.test.javaee.resource.model;

import java.util.List;

public class Game {
	private String gameName;
	private int score;
	private List<Player> players;
	
	public static Game mock() {
		Game g=new Game();
		g.setScore(80);
		g.setGameName("cards game");
		g.setPlayers(Player.players());
		return g;
	}
	
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public List<Player> getPlayers() {
		return players;
	}
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
	
}
