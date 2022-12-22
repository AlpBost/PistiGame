public class Point {
	
	public int player1point;
	public int comppoint;
	
	
	
		
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

