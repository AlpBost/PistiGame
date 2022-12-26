import java.util.Scanner;
import java.io.IOException;
import java.util.Random;
public class Card {
	
	private Deck[] table = new Deck[52];
	private Deck[] deck = new Deck[52];
	private String[] shapes = { "MACA " ,"KARO ","SINEK ","KUPA " /*" ♠ ", " ♥ ", " ♣ " ," ♦ "*/};
	public String[] others = { "A","2","3","4","5","6","7","8","9","10","J","Q","K"};
	public Deck[] player1 = new Deck[4];
	public Deck[] playercomp = new Deck[4];
	public Deck[] P1taken = new Deck[52];
	public Deck[] Pcomptaken = new Deck[52];
	
	Point point = new Point();

	
	
	public void Deck() {  
	
		//CREATING A DECK
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
		
		//SHUFFLE (WITH EXTRA STRING HELPER )
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
			
			int cardcounter =0; // DEALCARDCOUNTER IS NECESSARY TO DEAL. I ADDED 8 TO "DEALCARDCOUNTER" EVERY DEAL STEP 
			int P1takencardcounter =0; // I NEED IT TO COUNT PLAYER 1 CARDS
			int P2takencardcounter=0;  // I NEED IT TO COUNT PLAYER 1 CARDS
			int LASTFIELD=0; // END OF THE GAME IF IT IS 1 IT MEANS PLAYER TAKE LAST IF IT IS 0 COMPUTER
			
			//-----------------------------------------------------------------DEAL------------------------------------------------------------
			for(int a=0;a<6;a++) {
				//GIVING CARDS ONE BY ONE
				for (int i=0;i<8;i++) {
					if (i % 2 == 0) {
						player1[i/2] = deck[i+cardcounter] ;
					} else { 
						playercomp[(i-1)/2] = deck[i+cardcounter] ;
					}
				}
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~" + (a+1) +"~~~~~~~~~~~~~~~~~~~~~~");				
				
				
				//SHOWING CARD TO PLAYER
				System.out.println("               -YOUR CARDS-      ");
				int m = 1;
				for(int i=0; i<8; i=i+2) {
					System.out.print(m + "-" + player1[i/2].getShape()+player1[i/2].getNum() + "   ");
					m++;
				}
				System.out.println(" ");
				
				
				
				//----------------------------------------------------CHOOSING A CARD--------------------------------------------------
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
					
				
					//--------------------------------------------PLAYER'S TURN---------------------------------------------
					int ç=0;
					if (lastindex > 1 ) {                                                                                      //IF IT IS SAME
						if (((String) (player1[atılan-1]).getNum()).compareTo((String) table[lastindex-2].getNum())==0) { 
							
							
							//-----PISTI-------
							if(lastindex-1==2) {
								point.setplayer1point(10);
								System.out.println("PISTI!!");
							}
							
							System.out.println("ALL CARDS ARE YOURS");
							System.out.println("_____________________________________________");
							System.out.println("TOP CARD -> " );
							lastindex++;
							for (int j=P1takencardcounter;j < P1takencardcounter+lastindex;j++) {
								P1taken[j] = table[j];
							}
							for (int j=0;j<lastindex;j++) {
								table[j] = null;
							}
							
							P1takencardcounter += lastindex ;
							lastindex = 0;
							ç++;
							LASTFIELD=1;
						}
					} 
					if(ç==0) {                                                                                                  // IF IT IS "J"
						if(lastindex>1) {
							if ((String) (player1[atılan-1].getNum()) == "J") {
							System.out.println("ALL CARDS ARE YOURS");
							System.out.println("_____________________________________________");
							System.out.println("TOP CARD -> " );
							lastindex++;
							
							for (int j=P1takencardcounter ; j<P1takencardcounter+lastindex ; j++) {
								P1taken[j] = table[j];
							}
							for (int j=0;j<lastindex;j++) {
								table[j] = null;
							}
							P1takencardcounter += lastindex ;
							lastindex = 0;
							LASTFIELD=1;

							
							} else {                                                                                                 // JUST PUT IT TABLE
									System.out.println("TOP CARD -> " + table[lastindex-1].getShape()+ table[lastindex-1].getNum());
							System.out.println("_____________________________________________");
							}
						}	
					}
					player1[atılan-1] = null;   
					

					//--------------------------------------------------------COMPUTER'S TURN--------------------------------------------------------
					Random rd = new Random();
					int helper =2;
					for(int s=0;s<4;s++) {
						if (lastindex > 0 ) {  // IF LASTINDEX LOWER THAN 2 IT MEANS COMPUTER CAN'T TAKE CARDS. I ADDED ELSE TO PUT IT TO TABLE IF LASTINDEX LOWER THAN 2
							if(playercomp[s]!= null) {
								if (((String) playercomp[s].getNum()).compareTo((String) table[lastindex-1].getNum())==0) {
									System.out.println("COMPUTER PLAYED = " + playercomp[s].getShape()+playercomp[s].getNum());
									System.out.println("ALL CARDS ARE COMPUTERS");
									lastindex++;
									for (int j=P2takencardcounter;j<P2takencardcounter+lastindex;j++) {
										Pcomptaken[j] = table[j];
									}
									for (int j=0;j<lastindex;j++) {
										table[j] = null;
									}
									
									P2takencardcounter += lastindex;
									lastindex=0;
									helper++;
									LASTFIELD=0;
									playercomp[s]=null;
								}
							}
						}
					}
						
					if (helper == 2) {
							for(int d=0;d<4;d++) {
								if(playercomp[d]!=null) {   // WHEN I SEARCHED THAT THE COMPUTER HAS J, SOME OF THESE HAVE A PROBLEM IF IT IS NULL.
															// SO I WROTE IF IT IS NOT NULL, TO SEARCH IT
									if (lastindex != 0 || lastindex != 1 ) {
										if (playercomp[d].getNum()=="J") {
											System.out.println("COMPUTER PLAYED = " + playercomp[d].getShape()+playercomp[d].getNum());
											System.out.println("ALL CARDS ARE COMPUTERS");
											lastindex++;
											for (int j=P2takencardcounter;j<P2takencardcounter+lastindex;j++) {
												Pcomptaken[j] = table[j];
												table[j] = null;
											}
											P2takencardcounter += lastindex;
											helper++;
											LASTFIELD=0;
											lastindex=0;
											playercomp[d]=null;
										}
									}
								}
							}
								
						
						int compcard = 0;
						if (helper==2) {
							compcard = rd.nextInt(4);
							while(playercomp[compcard] == null) { // IF IT IS NOT NULL I WRITE BECAUSE THE COMPUTER CANNOT PLAY ONE CARD TWICE
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
				cardcounter=cardcounter+8; //DEAL CARD AFTER ADD 8 TO "DEALCARDCOUNTER"
			}
			
			//----------------------------------------------GIVING PLAYER TO LAST TABLE CARDS-----------------------------------------
			if (LASTFIELD==0) {
				for(int i=0; i<lastindex;i++) {
					Pcomptaken[i] = table[i];
					table[i] = null;
				}
			} else {
				for(int i=0; i<lastindex;i++) {
					P1taken[i] = table[i];
					table[i] = null;
				}
			
			}
		
			
			//------------------------------------------------------------CALCULATION---------------------------------------------------
			for(int i=0;i<P1taken.length;i++) {
				if (P1taken[i] != null) {
					if(P1taken[i].getShape() == "SINEK" && P1taken[i].getNum() == "2") {
						point.setplayer1point(2);
					} else if(P1taken[i].getShape() == "KARO" && P1taken[i].getNum() == "10") {
						point.setplayer1point(3);
					} else {
						point.setplayer1point(1);
					}
					if (P1takencardcounter > P2takencardcounter) point.setplayer1point(3);
					
				}
			}
			for(int i=0;i<Pcomptaken.length;i++) {
				if(Pcomptaken[i] != null) {
					if(Pcomptaken[i].getShape() == "SINEK" && Pcomptaken[i].getNum() == "2") {
						point.setcomppoint(2);
					} else if(Pcomptaken[i].getShape() == "KARO" && Pcomptaken[i].getNum() == "10") {
						point.setcomppoint(3);
					} else {
						point.setcomppoint(1);
					}
					
					if (P2takencardcounter > P1takencardcounter) point.setcomppoint(3) ;
				}
			}
		}
		

		public void EndGame() {
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
