import java.util.ArrayList;
public class Deck {
	
	public String ShuffleDeck;
	private String Player1deck;
	private String Player2deck;
	private String Tabledeck;
	private int player1p, computerp;
	private ArrayList <String> decklist;
	
	//set
	getGameDeck().add("Sinek A");
	..
	
	
	public void setGameList(ArrayList<String> decklist) {
		this.decklist = decklist;
	}
	
	public ArrayList<String> getGameDeck() {
		return decklist;
	}
	
}