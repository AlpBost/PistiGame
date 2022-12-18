public class Point {
	private int[] Cardpoints = new int[52];
	public int player1point;
	public int comppoint;
	public int heplerp;
	
	
	//SET-GET(0)
	public int getCardpoints() {
		return Cardpoints[0];
	}
	public void setCardpoints() {
		
		this.Cardpoints[28] = 2;
		this.Cardpoints[23] = 3;
		}
	
	//SET-GET(1)
	public int getplayer1point() {
		return player1point;
	}
	public void setplayer1point(int point1) {
		point1 =0;
		this.player1point = player1point+point1;
		System.out.println(player1point);
	}
	
	//SET-GET(2)
	public int getcomppoint() {
		return comppoint;
	}
	public void setcomppoint(int pointcomp) {
		this.comppoint = pointcomp; 
	}
}

