import java.util.Scanner;
import java.util.Random;
public class Card {
	
	public String[] player1 = new String[4];
	public static String[] playercomp = new String[4];
	public static String[] deck = new String [52];
	public String[] shapes = { "MACA " ,"KARO ","SINEK ","KUPA " /*" ♠ ", " ♥ ", " ♣ " ," ♦ "*/};
	public String[] others = { "A","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
	
	
	public void Deck() {   
		System.out.println("GAME IS STARTING!");
		for (int i=0; i<52; i++) {
			deck[i] = shapes[i/13] + others[i%13];
		}
		
	}
		
	void Shuffle() {
		Random rd = new Random();
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
			for(int i=1;i<randomcut;i++) {
				Cutup[i] = deck[i];
				aftercut[i] = Cutup[i];
			}
			for (int i=randomcut; i<52; i++) {
				Cutdown[i-randomcut] = deck[i];
				aftercut[i] = Cutdown[i-randomcut];
			}
		System.out.println("COMPUTER CHOSE " + randomcut + "TH CARD TO CUT");
	}
	 
	public void Onebyone() {
		for (int i=0;i<8;i++) {
			if (i % 2 == 0) {
				player1[i/2] = deck[i] ;
			} else { 
				playercomp[(i-1)/2] = deck[i] ;
			}
		}
		System.out.println("      ↓ YOUR CARDS ↓      ");
		for(int i=0; i<8; i=i+2) {
			System.out.print( player1[i/2] + "   ");
		}
		
	}
	
	
}
		

