import java.util.Scanner;
import java.util.Random;

public class MyProject {
	Random rd = new Random(System.currentTimeMillis());
	int [] deck = new int [52];
	int [] ♦ = new int [13];
	int [] ♥ = new int [13];
	int [] ♣ = new int [13];
	int [] ♠ = new int [13];
	// started deck
	for (int i= 2; i<11; i++) {
		♦ [i] = i ;
		♥ [i] = i ;
		♣ [i] = i ;
		♠ [i] = i ;
	}// gaven point
	♦ [1] = A;
	♥ [1] = A;
	♣ [1] = A;
	♠ [1] = A;

	♦ [11] = J;
	♥ [11] = J;
	♣ [11] = J;
	♠ [11] = J;

	♦ [12] = Q;
	♥ [12] = Q;
	♣ [12] = Q;
	♠ [12] = Q;

	♦ [13] = K;
	♥ [13] = K;
	♣ [13] = K;
	♠ [13] = K;

	//dont forget to shuffle 

	

