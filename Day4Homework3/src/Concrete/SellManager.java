package Concrete;


import Abstract.SellService;
import Entities.Campaign;
import Entities.Game;
import Entities.Gamer;

public class SellManager implements SellService {

	@Override
	public void sellNotDiscount(Gamer gamer, Game game) {
		System.out.println("Tebrikler oyun sat�n al�nd� "+gamer.getFirstName()+game.getName());
		
	}

	@Override
	public void sellWithDiscount(Gamer gamer, Game game, Campaign campaign) {
		System.out.println("Tebrikler oyunu indirimli sat�n ald�n�z "+gamer.getFirstName()+game.getName()+campaign.getName());
		
	}

}
