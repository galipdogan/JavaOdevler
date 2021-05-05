package gameProject;

import Abstract.GamerCheckService;
import Concrete.GamerManager;
import Entities.Campaign;
import Entities.Game;
import Entities.Gamer;
import Entities.Order;

public class Main {

	public static void main(String[] args) {
		// Gamer bölümü
		
		Gamer gamer1 = new Gamer(1,1234567987L,"Galip","Doðan",2000);
		Gamer gamer2 = new Gamer(1,1234567828L,"Gamer2","Gamer2LN",1995);
		Gamer gamer3 = new Gamer(1,12345678911L,"Gamer3","Gamer3LN",1990);
		
		GamerManager gamerManager=new GamerManager(new GamerCheckService() {
			
			@Override
			public boolean checkIfRealPerson(Gamer gamer) {
				// TODO Auto-generated method stub
				return false;
			}
		});
		
		gamerManager.add(gamer1);

//		// Game Bölümü
//		Game game1 = new Game(1,"Cs Go",50);
//		Game game2 = new Game(2,"Red Alert",100);
//		Game game3 = new Game(3,"Half Life",150);
//		Game[] games = {game1,game2,game3};
//		
//		// Campaign bölümü
//		Campaign campaign1 = new Campaign(1,"Yaz Kampanyasý",75);
//		Campaign campaign2 = new Campaign(2,"Kýþ Kampanyasý",25);
//		Campaign campaign3 = new Campaign(3,"Yeni Gelen Kampanyasý",50);
//		Campaign[] campaigns= {campaign1,campaign2,campaign3};
//
//		// Order bölümü
//		Order order1 = new Order(1, 1, 1, 1, 50, 100, 0);
//		Order order2 = new Order(2, 2, 2, 2, 100, 25, 75);
//		Order order3 = new Order(3, 3, 3, 3, 50, 25, 37.5);
		
		
	}

}
