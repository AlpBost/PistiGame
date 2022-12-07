
public class GamePrepare {
	public void Shuffle(Deck deck) {
		int [] ck1 = new int [52];
		String[] shapes = { " karo ", " kupa ", " sinek ", " maça "};
		String[] others = { "A", "1","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
		for (int i = 0; i < ck1.length; i++) {
			ck1[i]=i;
		}
		
		for (int i = 0; i < ck1.length; i++) {
			int value = (int)(Math.random()*ck1.length);
			int not = ck1[i];
			ck1[i] = ck1 [value];
			ck1 [value] = not;
		}
		for (int i = 0; i < 52; i++) {
			String shape = shapes[ck1[i]/13];
			String other = others[ck1[i]%13];
			System.out.println(shape + "" + other ); 
		}
		System.out.println("mixed deck = " + deck.ShuffleDeck);
 	} 
		
	

}
