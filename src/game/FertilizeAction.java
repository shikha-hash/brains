package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

public class FertilizeAction extends Action{
	
	@Override
	
	public String execute(Actor actor, GameMap map) {
		Location location = map.locationOf(actor);
		for (int i = 0; i<10; i ++) {
			location.getGround().tick(map.locationOf(actor));
		}
		return menuDescription(actor);
	}

	@Override
	public String menuDescription(Actor actor) {
		return "Farmer " + actor + " fertilises some crops";
	}

}
