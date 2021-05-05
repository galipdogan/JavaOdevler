package Concrete;


import Abstract.SellService;
import Entities.Campaign;
import Entities.Game;
import Entities.Gamer;

public class SellManager implements SellService {

	@Override
	public void sellNotDiscount(Gamer gamer, Game game) {
		System.out.println("Tebrikler oyun satýn alýndý "+gamer.getFirstName()+game.getName());
		
	}

	@Override
	public void sellWithDiscount(Gamer gamer, Game game, Campaign campaign) {
		System.out.println("Tebrikler oyunu indirimli satýn aldýnýz "+gamer.getFirstName()+game.getName()+campaign.getName());
		
	}

}
