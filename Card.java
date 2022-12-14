import java.util.Scanner;
import java.util.Random;
public class Card {
	
	public String[] TableDeck = new String[10];
	public String[] player1 = new String[4];
	public String[] playercomp = new String[4];
	public String[] deck = new String [52];
	public String[] shapes = { "MACA " ,"KARO ","SINEK ","KUPA " /*" ♠ ", " ♥ ", " ♣ " ," ♦ "*/};
	public String[] others = { "A","2","3","4","5","6","7","8","9","10","J","Q","K"};
	
	
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
			for(int i=1;i<randomcut;i++) {
				Cutup[i] = deck[i];
				aftercut[i] = Cutup[i];
			}
			
			//SECOND PART OF THE DECK
			for (int i=randomcut; i<52; i++) {
				Cutdown[i-randomcut] = deck[i];
				aftercut[i] = Cutdown[i-randomcut];
			}
		System.out.println("COMPUTER CHOSE " + randomcut + "TH CARD TO CUT");
		
	}
	 
	public void Onebyone() {
		String topcard = deck[8];
		//GIVING CARDS ONE BY ONE
		for (int i=0;i<8;i++) {
			if (i % 2 == 0) {
				player1[i/2] = deck[i] ;
			} else { 
				playercomp[(i-1)/2] = deck[i] ;
			}
		}
		System.out.println("_____________________________________________");
		
		//PREPARING TABLE CARD
		System.out.println("     -TABLE DECK-        ");
		for (int i=8;i<12;i++) {
			TableDeck[i-8] = deck[i];
			if (i==11) {
				System.out.println("TOP CARD ->   " + topcard );
			} 
		}
		System.out.println("_____________________________________________");
		
		//SHOWING CARD TO PLAYER
		System.out.println("     -YOUR CARDS-     ");
		int num = 1;
		for(int i=0; i<8; i=i+2) {
			System.out.print(num + "-" + player1[i/2] + "   ");
			num++;
		}
		System.out.println(" ");
	
	}
	
	public void CardSelect() {
		Scanner sc = new Scanner(System.in);
		String topcard = "empty";
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
			
			//PLAYER'S TURN
			if (player1[atılan-1] == TableDeck[0]) {
				System.out.println("ALL CARDS ARE YOURS");
				//PLAYER 1 PUANINA EKLE
			} else {
				topcard = player1[atılan-1];
				System.out.println("TOP CARD -> " + topcard);
				System.out.println("Enter 1 TO SEE ALL TABLE CARDS -- ENTER 0 TO SKIP");
				int skip = sc.nextInt();
				while (!(skip == 1 || skip == 0)) {
					if ( skip == 1) {
						for (int j=0; ;j++) {
							System.out.println(TableDeck[j]);
						}
					} else if (skip == 0) {
					} else {
						System.out.println("PLEASE ENTER VALID NUMBER");
						skip = sc.nextInt();
					}
				}
				System.out.println("COMPUTERS TURN");
				System.out.println("_____________________________________________");


			}
			player1[atılan-1]="";

			for (int j=0;j<4;j++) {
				System.out.print(j+1 + "-" + player1[j] + "   ");
			}
		}
	}
}
				
					
			
			
			
			

