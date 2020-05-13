package main.java.dto;

public class Player {

	private String name;
	private Integer score;
	private Boolean flg;
	
	
	public Player(String name, Integer score, Boolean flg) {
		super();
		this.name = name;
		this.score = score;
		this.flg = flg;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public Boolean getFlg() {
		return flg;
	}
	public void setFlg(Boolean flg) {
		this.flg = flg;
	}
	
	
}
