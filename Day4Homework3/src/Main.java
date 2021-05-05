
import Abstract.GamerCheckService;
import Concrete.GameManager;
import Concrete.GamerManager;
import Entities.Campaign;
import Entities.Game;
import Entities.Gamer;
import Entities.Order;

public class Main {

	public static void main(String[] args) {
			
		
		// Gamer bölümü
		Gamer gamer1 = new Gamer(1,14132752386L, "Galip", "Doðan", 1986);
		GamerManager gamerManager=new GamerManager(new GamerCheckService() {
			
			@Override
			public boolean checkIfRealPerson(Gamer gamer) {
				// TODO Auto-generated method stub
				return false;
			}
		} );
		
		gamerManager.add(gamer1);

		// Game Bölümü
		//Game game1 = new Game(1, "Cs Go", 50);
		
		// Campaign bölümü
		//Campaign campaign1 = new Campaign(1, "Yaz Kampanyasý", 75);
		
		// Order bölümü
		//Order order1 = new Order(1, 1, 1, 1, 50, 100, 0);
	

	}

}
