package group5.viope2014;
import java.util.Random;

public class RandomMove implements ArtificialIntelligence {
	
	public int intMove(int x, int y){
		Random r = new Random();
		
		return (r.nextInt(4));
		
	}

}
