package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import game.maps.MapClass;


public class ChangeMapAction extends Action {
	protected Vehicle vehicle;
	private GameMap otherMap;
	public ChangeMapAction(Vehicle vehicle) {
		// TODO Auto-generated constructor stub
		this.vehicle=vehicle;
	}
	@Override
	public String execute(Actor actor, GameMap map) {
		// TODO Auto-generated method stub
		if(map==MapClass.townMap) {
			otherMap=MapClass.zombieWorldMap;
		}
		else if(map==MapClass.zombieWorldMap) {
			otherMap=MapClass.townMap;
		}
		map.moveActor(actor, otherMap.at(2, 2));
		return menuDescription(actor);
//		map.addActor(actor, location);
	}

	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return actor+" uses "+vehicle;
	}

}
