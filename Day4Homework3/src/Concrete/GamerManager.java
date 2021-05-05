package Concrete;

import Abstract.GamerCheckService;
import Abstract.GamerService;
import Entities.Gamer;

public class GamerManager implements GamerService {
	GamerCheckService gamerCheckService;

	public GamerManager(GamerCheckService gamerCheckService) {
		this.gamerCheckService = gamerCheckService;
	}

	@Override
	public void add(Gamer gamer) {

		if (gamerCheckService.checkIfRealPerson(gamer)) {
			System.out.println("Oyuncu Eklendi " + gamer.getFirstName());
		} else {
			System.out.println("�nsan m�s�n�z");
		}
	}

	@Override
	public void update(Gamer gamer) {
		System.out.println("Oyuncu G�ncellendi " + gamer.getFirstName());

	}

	@Override
	public void delete(Gamer gamer) {
		System.out.println("Oyuncu Silindi " + gamer.getFirstName());

	}

}
