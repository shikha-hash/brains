package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class VanishAction extends Action{

	@Override
	public String execute(Actor actor, GameMap map) {
		// TODO Auto-generated method stub
		map.removeActor(actor);
		return actor+" vanishes into thin air!";
	
	}

	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return null;
	}

}
