import java.util.Scanner;

public class MyProject {
	
	public static void main(String[] args) {
		int [] deck = new int [52];
		String[] shapes = { " karo", " kupa", " sinek", " maça"};
		String[] others = { "A", "1","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
		for (int i = 0; i < deck.length; i++) {
			deck[i]=i;
		}
		
		for (int i = 0; i < deck.length; i++) {
			int value = (int)(Math.random()*deck.length);
			int not = deck[i];
			deck[i] = deck [value];
			deck[value] = not;
		}
		for (int i = 0; i < 52; i++) {
			String shape = shapes[deck[i]/13];
			String other = others[deck[i]%13];
			System.out.println(shape + "" + other );
		}
		System.out.println("");
		for (int i = 0; i<8; i++) {
			String shape = shapes[deck[i]/13];
			String other = others[deck[i]%13];
			if (i%2 == 0) {
				System.out.println("player 1 cards = " + shape + " " + other);//control
			} else {
				System.out.println("player 2 cards = " + shape + " " + other );//wrong
			}
		}
	}
}





	
		
		

		

	

