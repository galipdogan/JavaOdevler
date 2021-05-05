package Abstract;

import Entities.Campaign;
import Entities.Game;
import Entities.Gamer;

public interface SellService {
	void sellNotDiscount(Gamer gamer,Game game);
	void sellWithDiscount(Gamer gamer,Game game,Campaign campaign);
}
