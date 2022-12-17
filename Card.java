import java.util.Scanner;
import java.util.Random;
public class Card {
	
	private String[] TableDeck = new String[4];
	private String[] player1 = new String[4];
	private String[] playercomp = new String[4];
	private String[] deck = new String [52];
	private String[] shapes = { "MACA " ,"KARO ","SINEK ","KUPA " /*" ♠ ", " ♥ ", " ♣ " ," ♦ "*/};
	private String[] others = { "A","2","3","4","5","6","7","8","9","10","J","Q","K"};
	
	Point cardpoint = new Point();
	
	
	public void Deck() {   
		System.out.println("GAME IS STARTING!");
		
		//CREATING A DECK
		for (int i=0; i<52; i++) {
			deck[i] = shapes[i/13] + others[i%13];
		}
		
	}
		
	void Shuffle() {
		Random rd = new Random();
		
		//SHUFFLE (WITH EXTRA HELPER STRING)
		for (int i = 0; i < deck.length; i++) {
			int helper = rd.nextInt(52);                                             
			String empty = deck[i];
			deck[i] = deck[helper];
			deck[helper] = empty;
		}
		System.out.println("THE DECK OF CARDS IS SHUFFLED.");
	}
		 
	
	void Cut() {
		Random rd = new Random();
		int randomcut = rd.nextInt(52);
		String[] aftercut = new String[52];
		String[] Cutup = new String[randomcut];
		String[] Cutdown = new String[52-randomcut];
			
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
	 
	/*public void Deal1() {
		String topcard = deck[8];
		
		//GIVING CARDS ONE BY ONE
		for (int i=0;i<8;i++) {
			if (i % 2 == 0) {
				player1[i/2] = deck[i] ;
			} else { 
				playercomp[(i-1)/2] = deck[i] ;
			}
		}
		System.out.println("____________________1________________________");
		
		//PREPARING TABLE CARD
		System.out.println("              -TABLE DECK-        ");
		for (int i=8;i<12;i++) {
			TableDeck[i-8] = deck[i];
			if (i==11) {
				System.out.println("TOP CARD ->   " + topcard );
			} 
		}
		System.out.println("_____________________________________________");
		
		//SHOWING CARD TO PLAYER
		System.out.println("               -YOUR CARDS-     ");
		int num = 1;
		for(int i=0; i<8; i=i+2) {
			System.out.print(num + "-" + player1[i/2] + "   ");
			num++;
		}
		System.out.println(" ");
	
	}*/
	
	/*public void CardSelect() {
		Scanner sc = new Scanner(System.in);
		String topcard = " ";
		System.out.println("_____________________________________________");
		
		//CHOOSING A CARD
		System.out.println("SELECT A CARD POSITION TO PLAY ");
		
		for(int i=0;i<4;i++) {
		
			//ENTERING VALID NUMBER
			int atılan = sc.nextInt();
			
			while (!(atılan == 1 || atılan == 2 || atılan == 3 || atılan == 4)) {
				System.out.println("PLEASE ENTER VALID NUMBER");
				atılan = sc.nextInt();
			}
			topcard = player1[atılan-1];
			
			//PLAYER'S TURN
			if (deck[atılan-1].compareTo(topcard) == 0) {
				System.out.println("ALL CARDS ARE YOURS");
				System.out.println("_____________________________________________");
				System.out.println("TOP CARD -> " );
				if (topcard == "SINEK 2") {
					cardpoint.player1point += 2;
				}
			} else {
				System.out.println("TOP CARD -> " + topcard);
				System.out.println("_____________________________________________");
			}
			player1[atılan-1]=" ";

			for (int j=0;j<4;j++) {
				System.out.print(j+1 + "-" + player1[j] + "   ");
			}
			System.out.println(" ");
			
			
			//COMPUTER'S TURN
			Random rd = new Random();
			int compcard = rd.nextInt(4);
			System.out.println(playercomp[compcard]);
			
			
			//aynıysa kart
			//vale varsa vale
			//random
			
			}
	}*/
		
	/*	public void Deal2() {
			
			// ONCEKI DAGITIMDAN TOPCARD'I BURAYA GE
			System.out.println();
			String topcard = " ";
			//GIVING CARDS ONE BY ONE
			for (int i=0;i<8;i++) {
				if (i % 2 == 0) {
					player1[i/2] = deck[i+8] ;
				} else { 
					playercomp[(i-1)/2] = deck[i+8] ;
				}
			}
			System.out.println("____________________2________________________");
			
			//PREPARING TABLE CARD
			System.out.println("              -TABLE DECK-        ");
			System.out.println("TOP CARD ->   " + topcard );
				
			
			System.out.println("_____________________________________________");
			
			//SHOWING CARD TO PLAYER
			System.out.println("               -YOUR CARDS-     ");
			int num = 1;
			for(int i=0; i<8; i=i+2) {
				System.out.print(num + "-" + player1[i/2] + "   ");
				num++;
			}
			System.out.println(" ");
		
		}*/
		
		/*public void Deal3() {
			
			// ONCEKI DAGITIMDAN TOPCARD'I BURAYA GE
			System.out.println();
			String topcard = "";
			//GIVING CARDS ONE BY ONE
			for (int i=0;i<8;i++) {
				if (i % 2 == 0) {
					player1[i/2] = deck[i+16] ;
				} else { 
					playercomp[(i-1)/2] = deck[i+16] ;
				}
			}
			System.out.println("____________________2________________________");
			
			//PREPARING TABLE CARD
			System.out.println("              -TABLE DECK-        ");
			System.out.println("TOP CARD ->   " + topcard );
				
			
			System.out.println("_____________________________________________");
			
			//SHOWING CARD TO PLAYER
			System.out.println("               -YOUR CARDS-     ");
			int num = 1;
			for(int i=0; i<8; i=i+2) {
				System.out.print(num + "-" + player1[i/2] + "   ");
				num++;
			}
			System.out.println(" ");
		
		}*/
		
		/*public void Deal4() {
			
			// ONCEKI DAGITIMDAN TOPCARD'I BURAYA GE
			System.out.println();
			String topcard = "";
			//GIVING CARDS ONE BY ONE
			for (int i=0;i<8;i++) {
				if (i % 2 == 0) {
					player1[i/2] = deck[i+24] ;
				} else { 
					playercomp[(i-1)/2] = deck[i+24] ;
				}
			}
			System.out.println("____________________2________________________");
			
			//PREPARING TABLE CARD
			System.out.println("              -TABLE DECK-        ");
			System.out.println("TOP CARD ->   " + topcard );
				
			
			System.out.println("_____________________________________________");
			
			//SHOWING CARD TO PLAYER
			System.out.println("               -YOUR CARDS-     ");
			int num = 1;
			for(int i=0; i<8; i=i+2) {
				System.out.print(num + "-" + player1[i/2] + "   ");
				num++;
			}
			System.out.println(" ");
		
		}*/
		
		
		
		
		
		public void DealandSelect() {
			Scanner sc = new Scanner(System.in);
			String topcard = deck[8];
			
			//DEAL
			for(int a=0;a<6;a++) {
				
				int tur =0;
				//GIVING CARDS ONE BY ONE
				for (int i=0;i<8;i++) {
					if (i % 2 == 0) {
						player1[i/2] = deck[i+tur] ;
					} else { 
						playercomp[(i-1)/2] = deck[i+tur] ;
					}
				}
				System.out.println("____________________" + (a+1) +"________________________");
				
				//PREPARING TABLE CARD
				System.out.println("              -TABLE DECK-        ");
				for (int i=8;i<12;i++) {
					TableDeck[i-8] = deck[i+tur];
					if (i==11) {
						System.out.println("TOP CARD ->   " + topcard );
					} 
				}
				System.out.println("_____________________________________________");
				
				//SHOWING CARD TO PLAYER
				System.out.println("               -YOUR CARDS-     ");
				int num = 1;
				for(int i=0; i<8; i=i+2) {
					System.out.print(num + "-" + player1[i/2] + "   ");
					num++;
				}
				System.out.println(" ");
				
				
				//CARD SELECT
				System.out.println("_____________________________________________");
				
				//CHOOSING A CARD
				System.out.println("SELECT A CARD POSITION TO PLAY ");
				
				for(int i=0;i<4;i++) {
				
					//ENTERING VALID NUMBER
					int atılan = sc.nextInt();
					
					while (!(atılan == 1 || atılan == 2 || atılan == 3 || atılan == 4)) {
						System.out.println("PLEASE ENTER VALID NUMBER");
						atılan = sc.nextInt();
					}
					topcard = player1[atılan-1];
					
					//PLAYER'S TURN
					if (deck[atılan-1].compareTo(topcard) == 0) {
						System.out.println("ALL CARDS ARE YOURS");
						System.out.println("_____________________________________________");
						System.out.println("TOP CARD -> " );
						if (topcard == "SINEK 2") {
							cardpoint.player1point += 2;
						}
					} else {
						System.out.println("TOP CARD -> " + topcard);
						System.out.println("_____________________________________________");
					}
					player1[atılan-1]=" ";

					
					
					
					//COMPUTER'S TURN
					Random rd = new Random();
					int compcard = rd.nextInt(4);
					System.out.println("COMPUTER PLAYED = " + playercomp[compcard]);
					topcard = playercomp[compcard];
					System.out.println("TOP CARD -> " + topcard);

					System.out.println("_____________________________________________");
					System.out.println("               -YOUR CARDS-     ");
					for (int j=0;j<4;j++) {
						System.out.print(j+1 + "-" + player1[j] + "   ");
					}
					System.out.println(" ");
					
					//aynıysa kart
					//vale varsa vale
					//random
					
					tur=tur+8;
				}
				
			}
		}	

		public void EndGame() {
			Point point = new Point();
			System.out.println("THIS IS THE END OF THE GAME");
			if(point.getplayer1point() < point.getcomppoint()) {
				System.out.println("YOU LOSE!");
			} else if (point.player1point() = point.comppoint()) {
				System.out.println("DRAW!");
			} else {
				System.out.println("YOU WON!")
			}
		}
}



				
			