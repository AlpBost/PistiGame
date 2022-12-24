
public class Deck {
	private String shape;
	private String num;
	
	
	
	Deck() {
		this.shape = "helper";
		this.num = "helper";
	}
	
	//SET-GET0
	public String getShape() {
		return shape;
	}
	public void setShape(String Shape) {
		this.shape= Shape;
	}
	
	//SET-GET1
	public Object getNum() {
		return num;
	}
	public void setNum(String Num) {
		this.num= Num;
	}
}
