
import Abstract.GamerCheckService;
import Concrete.GameManager;
import Concrete.GamerManager;
import Entities.Campaign;
import Entities.Game;
import Entities.Gamer;
import Entities.Order;

public class Main {

	public static void main(String[] args) {
			
		
		// Gamer b�l�m�
		GamerManager gamerManager=new GamerManager(new GamerCheckService() {
			
			@Override
			public boolean checkIfRealPerson(Gamer gamer) {
				// TODO Auto-generated method stub
				return false;
			}
		});
		
		Gamer gamer1 = new Gamer(1,144564752386L, "Galip", "Do�an", 1986);
		gamerManager.add(gamer1);

		// Game B�l�m�
		//Game game1 = new Game(1, "Cs Go", 50);
		
		// Campaign b�l�m�
		//Campaign campaign1 = new Campaign(1, "Yaz Kampanyas�", 75);
		
		// Order b�l�m�
		//Order order1 = new Order(1, 1, 1, 1, 50, 100, 0);
	

	}

}
