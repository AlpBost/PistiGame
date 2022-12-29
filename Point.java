public class Point {
	
	public int player1point;
	public int comppoint;
	
		
	//SET-GET(1)
	
	public void setplayer1point(int point1) {
		this.player1point += point1;
	}
	public int getplayer1point() {
		return player1point;
	}
	
	//SET-GET(2)
		public void setcomppoint(int pointcomp) {
		this.comppoint += pointcomp; 
	}
		public int getcomppoint() {
			return comppoint;
	}

}

