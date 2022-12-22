public class Main {
	public static void main(String[] args ) {		
		
		Point point = new Point();
		Card card = new Card();
		
		card.Deck();
		card.Shuffle();
		card.Cut();
		card.DealandSelect();	
		card.EndGame();
		
	}

}