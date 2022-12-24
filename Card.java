import java.util.Scanner;
import java.util.Random;
public class Card {
	
	Deck[] table = new Deck[52];
	Point point = new Point();
	Deck[] deck = new Deck[52];
	public String[] shapes = { "MACA " ,"KARO ","SINEK ","KUPA " /*" ♠ ", " ♥ ", " ♣ " ," ♦ "*/};
	public String[] others = { "A","2","3","4","5","6","7","8","9","10","J","Q","K"};
	public Deck[] player1 = new Deck[4];
	public Deck[] playercomp = new Deck[4];
	public Deck[] P1taken = new Deck[52];
	public Deck[] Pcomptaken = new Deck[52];
	
	
	
	//CREATING A DECK
	public void Deck() {  
	
		
		for(int i = 0; i<52;i++) {
			deck[i]=new Deck();
		}
		int count=0;
		System.out.println("GAME IS STARTING!");
		for(int j=0; j<4; j++) {
			for(int i=0;i<13;i++) {
				deck[count].setShape(shapes[j]);
				deck[count].setNum(others[i]);
				count++;
			}
		}
	
	}
		
	void Shuffle() {
		Random rd = new Random();
		
		//SHUFFLE (WITH EXTRA HELPER STRING)
		for (int i = 0; i < deck.length; i++) {
			int helper = rd.nextInt(52);                                             
			Deck empty = deck[i];
			deck[i] = deck[helper];
			deck[helper] = empty;
		}
		System.out.println("THE DECK OF CARDS IS SHUFFLED.");
	}
		 
	
	void Cut() {
		Random rd = new Random();
		int randomcut = rd.nextInt(52);
		Deck[] aftercut = new Deck[52];
		Deck[] Cutup = new Deck[randomcut];
		Deck[] Cutdown = new Deck[52-randomcut];
			
			//FIRST PART OF THE DECK
			for(int i=0;i<randomcut;i++) {
				Cutup[i] = deck[i];
				aftercut[i] = Cutup[i];
			}
			
			//SECOND PART OF THE DECK
			for (int i=randomcut; i<52; i++) {
				Cutdown[i-randomcut] = deck[i];
				aftercut[i] = Cutdown[i-randomcut];
			}
			for (int i = 0; i<52; i++) {
				deck[i]=aftercut[i];
			}
		System.out.println("COMPUTER CHOSE " + randomcut + "TH CARD TO CUT");
		
	}
	 
	
		
		
		
		public void DealandSelect() {
						
			Scanner sc = new Scanner(System.in);

			int lastindex=0; //HOW MANY CARDS ON THE TABLE AND WHAT IS THE TOP ONE
			
			//PREPARING TABLE CARD
			System.out.println("_____________________________________________");
			System.out.println("              -TABLE DECK-        ");
			for (int i=8;i<12;i++) {
				table[i-8] = deck[i];
				if (i==11) {
					System.out.println("TOP CARD ->   " + table[3].getShape()+table[3].getNum());
					lastindex = lastindex+4;
				} 
			}
			int tur =0;
			
			//DEAL
			for(int a=0;a<6;a++) {
				
				
	
				//GIVING CARDS ONE BY ONE
				for (int i=0;i<8;i++) {
					if (i % 2 == 0) {
						player1[i/2] = deck[i+tur] ;
					} else { 
						playercomp[(i-1)/2] = deck[i+tur] ;
					}
				}
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~" + (a+1) +"~~~~~~~~~~~~~~~~~~~~~~");				
				
				//SHOWING CARD TO PLAYER
				System.out.println("               -YOUR CARDS-     ");
				int m = 1;
				for(int i=0; i<8; i=i+2) {
					System.out.print(m + "-" + player1[i/2].getShape()+player1[i/2].getNum() + "   ");
					m++;
				}
				System.out.println(" ");
				
				
				
				//CHOOSING A CARD
				
				
				for(int i=0;i<4;i++) {
					//CARD SELECT
					System.out.println("_____________________________________________");
					System.out.println("SELECT A CARD POSITION TO PLAY ");
					//ENTERING VALID NUMBER
					int atılan = sc.nextInt();
					
					while (!(atılan == 1 || atılan == 2 || atılan == 3 || atılan == 4) || player1[atılan-1] == null ) {
							System.out.println("PLEASE ENTER VALID NUMBER");
							atılan = sc.nextInt();
						
					}
					
					table[lastindex] = (player1[atılan-1]);
					lastindex++;
					
					//PLAYER'S TURN
					int ç=0;
					if (lastindex > 1 ) {
						if (((String) (player1[atılan-1]).getNum()).compareTo((String) table[lastindex-2].getNum())==0) { 
							//IF TABLE.LENGTH == 2 -> PISTI +10 => SYSTO PISTI!
							System.out.println("ALL CARDS ARE YOURS");
							System.out.println("_____________________________________________");
							System.out.println("TOP CARD -> " );
							
							for (int j=0;j<lastindex;j++) {
								P1taken[j] = table[j];
								table[j] = null;
							}	
							lastindex = 0;
							ç++;
						}
					} 
					if(ç==0) {
						if ((String) (player1[atılan-1].getNum()) == "J") {
							System.out.println("ALL CARDS ARE YOURS");
							System.out.println("_____________________________________________");
							System.out.println("TOP CARD -> " );
	
							for (int j=0;j<lastindex;j++) {
								P1taken[j] = table[j];
								table[j] = null;
							}
							lastindex = 0;
							
						} else {
							System.out.println("TOP CARD -> " + table[lastindex-1].getShape()+ table[lastindex-1].getNum());
							System.out.println("_____________________________________________");
						}
					}
					player1[atılan-1] = null;   
					

					//COMPUTER'S TURN
					Random rd = new Random();
					
					int helper =2;
					for(int s=0;s<4;s++) {
						if (lastindex > 1 ) {
							if(playercomp[s]!= null) {
								if (((String) playercomp[s].getNum()).compareTo((String) table[lastindex-1].getNum())==0) {
									System.out.println("COMPUTER PLAYED = " + playercomp[s].getShape()+playercomp[s].getNum());
									System.out.println("ALL CARDS ARE COMPUTERS");
									lastindex++;
									for (int j=0;j<lastindex;j++) {
										Pcomptaken[j] = table[j];
										table[j] = null;
									}
									lastindex=0;
									helper++;
									playercomp[s]=null;
								}
							
							}
						}
					}
						
					if (helper == 2) {
							for(int d=0;d<4;d++) {
								if(playercomp[d]!=null) {
									if (lastindex != 0 || lastindex != 1 ) {
									if (playercomp[d].getNum()=="J") {
										lastindex =0;
										System.out.println("COMPUTER PLAYED = " + playercomp[d].getShape()+playercomp[d].getNum());
										System.out.println("ALL CARDS ARE COMPUTERS");
										for (int j=0;j<lastindex;j++) {
											P1taken[j] = table[j];
											table[j] = null;
										}
										helper++;
										lastindex=0;
										playercomp[d]=null;
									}
								}
						}
					}
								
						
						int compcard = 0;
						if (helper==2) {
							compcard = rd.nextInt(4);
							while(playercomp[compcard] == null) {
								compcard=rd.nextInt(4);
							}
							System.out.println("COMPUTER PLAYED = " + playercomp[compcard].getShape()+playercomp[compcard].getNum());
							lastindex ++;
							table[lastindex-1] = playercomp[compcard];
							System.out.println("TOP CARD -> " + table[lastindex-1].getShape()+playercomp[compcard].getNum());
							helper++;
							playercomp[compcard]=null;
						}
					}
					
				
						
					
					
					System.out.println("_____________________________________________");
					System.out.println("               -YOUR CARDS-     ");
					for (int j=0;j<4;j++) {
						if (player1[j]!=null) {
							System.out.print(j+1 + "-" + player1[j].getShape()+player1[j].getNum()+ "   ");
						} else { 
							System.out.print(j+1 + "-     ");
						}
						
					}
					System.out.println(" ");
					
					
				}	
				tur=tur+8;
			}
		}
		

		public void EndGame() {
			Point point = new Point();
			System.out.println("_____________________________________________");
			System.out.println("THIS IS THE END OF THE GAME");
			if(point.getplayer1point() < point.getcomppoint()) {
				System.out.println("YOU LOSE!");
				System.out.println("YOUR POINT = " + point.getplayer1point());
				System.out.println("COMPUTER POINT = " + point.getcomppoint());
			} else if (point.getplayer1point() == point.getcomppoint()) {
				System.out.println("DRAW!");
				System.out.println("YOUR POINT = " + point.getplayer1point());
				System.out.println("COMPUTER POINT = " + point.getcomppoint());


			} else {
				System.out.println("YOU WON!");
				System.out.println("YOUR POINT = " + point.getplayer1point());
				System.out.println("COMPUTER POINT = " + point.getcomppoint());
			}
		}
}
